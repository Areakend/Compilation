package Expr;

import Exceptions.*;
import Objets.*;
import sun.security.action.GetBooleanAction;

import org.antlr.runtime.tree.CommonTree;

import java.util.ArrayList;

public class TreeParser {

	private static void analyseRec(CommonTree t, TableDesSymboles tds, Tables tables) throws Exception {

		if (t.isNil()) {
			return;
		}

		if (t.getText().equals("nil")) {
			int nbChilds = t.getChildCount();
			for (int i = 0; i < nbChilds; i++) {
				analyseRec((CommonTree) t.getChild(i), tds, tables);
			}
		}

		if (t.getText().equals("DECL")) {
			boolean mut = false;
			String name = null;
			int nbChilds = t.getChildCount();

			if (nbChilds == 1) {
				name = t.getChild(0).getText();
			} else if (nbChilds == 2) {
				if (t.getChild(1).getChildCount() == 0) {
					mut = true;
					name = t.getChild(1).getText();
				} else {
					name = t.getChild(0).getText();
				}
			} else {
				mut = true;
				name = t.getChild(1).getText();
			}

			if (t.getChild(nbChilds - 1).getChildCount() > 0) { // AFFECT
				CommonTree node = (CommonTree) t.getChild(nbChilds - 1);
				String value = analyseExp((CommonTree) node.getChild(0), tds, tables);
				tds.ajouterVariable(tds, name, mut, value);
			}
		}

		if (t.getText().equals("STRUCT")) {
			String nameStruct = t.getChild(0).getText();
			ArrayList<String> varNames = new ArrayList<>();
			ArrayList<String> varTypes = new ArrayList<>();
			int nbChilds = t.getChildCount();
			for (int i = 1; i < nbChilds; i++) {
				CommonTree node = (CommonTree) t.getChild(i);
				fillVarNamesTypes(node, varNames, varTypes);
			}
			TableDesStructures tdstruct = new TableDesStructures();
			tdstruct.ajouterStructure(nameStruct, varNames, varTypes);
		}

		if (t.getText().equals("BLOC")) {
			TableDesSymboles tds2 = new TableDesSymboles(tds);
			int nbChilds = t.getChildCount();
			for (int i = 0; i < nbChilds; i++) {
				analyseRec((CommonTree) t.getChild(i), tds2, tables);
			}
		}

		if (t.getText().equals("IF")) {
			analyseExp((CommonTree) t.getChild(0), tds, tables);
			for (int i = 1; i < t.getChildCount(); i++) {
				analyseRec((CommonTree) t.getChild(i), tds, tables);
			}
		}

		if (t.getText().equals("ELSE")) {
			analyseExp((CommonTree) t.getChild(0), tds, tables);
		}

		if (t.getText().equals("WHILE")) {
			analyseExp((CommonTree) t.getChild(0), tds, tables);
			analyseRec((CommonTree) t.getChild(1), tds, tables);
		}

		if (t.getText().equals("FUNC")) {
			String nameFunc = t.getChild(0).getText();
			String returnType = null;
			Arguments args;
			ArrayList<String> argNames;
			ArrayList<String> argTypes;
			for (int i = 1; i < t.getChildCount(); i++) {
				CommonTree node = (CommonTree) t.getChild(i);
				if (node.getText().equals("FUNC_ARGS")) {
					argNames = new ArrayList<>();
					argTypes = new ArrayList<>();
					for (int j = 1; j < node.getChildCount(); j++) {
						CommonTree node2 = (CommonTree) node.getChild(j);
						fillVarNamesTypes(node2, argNames, argTypes);
					}
					args = new Arguments(argNames, argTypes);
				} else if (node.getText().equals("BLOC")) {
					analyseRec(node, tds, tables);
				} else {
					returnType = node.getText();
				}
			}
			tds.ajouterFonction(nameFunc, returnType, args);
		}

		if (t.getText().equals("print") || t.getText().equals("RETURN")) {
			analyseExp((CommonTree) t.getChild(0), tds, tables);
		}

	}

	private static String analyseExp(CommonTree t, TableDesSymboles tds, Tables tables) throws Exception {
		Double fg = Double.valueOf(analyseExp((CommonTree) t.getChild(0), tds, tables));
		Double fd = Double.valueOf(analyseExp((CommonTree) t.getChild(1), tds, tables));
		if (t.getText().equals("+") || t.getText().equals("-") || t.getText().equals("*") || t.getText().equals("/")) {
			double value = 0.0;
			if (t.getText().equals("+")) {
				value = fg + fd;
			} else if (t.getText().equals("-")) {
				value = fg - fd;
			} else if (t.getText().equals("*")) {
				value = fg * fd;
			} else if (t.getText().equals("/")) {
				value = fg / fd;
			}
			return String.valueOf(value);
		} else if (t.getText().equals("<")) {
			return String.valueOf(fg < fd);
		} else if (t.getText().equals("<=")) {
			return String.valueOf(fg <= fd);
		} else if (t.getText().equals(">")) {
			return String.valueOf(fg > fd);
		} else if (t.getText().equals(">=")) {
			return String.valueOf(fg >= fd);
		} else if (t.getText().equals("==")) {
			return String.valueOf(fg == fd);
		} else if (t.getText().equals("!=")) {
			return String.valueOf(fg != fd);
		} else {
			try {
				Double.valueOf(t.getText());
				return t.getText();
			} catch (NumberFormatException e) {
				try {
					int nbChilds = t.getChildCount();
					if (nbChilds == 0) {
						return String.valueOf(
								((TableDesVariables) (tds.get(TableType.VAR))).getValeurVariable(tds, t.getText()));
					}
					if (t.getChild(0).getText() == "IND") {
						String name = t.getText();
						t = (CommonTree) t.getChild(0).getChild(0);
						try {
							Vecteur vect = ((TableDesVecteurs) (tds.get(TableType.VEC))).getVecteur(tds, name);
							int indice = Integer.valueOf(analyseExp(t, tds, tables));
							try {
								vect.validSize(vect, indice);
							} catch (IndexOutOfBounds e3) {
								
							}
							String val = vect.getValeurs().get(indice);
							return val;
						} catch (NonExistantVariable e4) {

						}

					}

					if (t.getChild(0).getText() == "FUNC_ARGS") {
						String name = t.getText();
						try {
							Fonction fonc = ((TableDesFonctions) (tds.get(TableType.FONC))).getFunction(tds, name);
							int nbChilds2 = t.getChildCount();
							try {
								fonc.validNumberArgs(fonc, nbChilds2);
							}
							catch (InvalidArgumentsNumber e5){
								
							}
							t = (CommonTree) t.getChild(0);
							for (int i = 0; i < nbChilds2; i++) {
								analyseRec((CommonTree) t.getChild(i), tds, tables);
								fonc.getArgs().getTypes().get(i);
								Integer.parseInt(t.getChild(i).getText());
							}
						} catch (NonExistantFunction e1) {

						}

					}

				} catch (NonExistantVariable nonExistantVariable) {
				}
			}
		}
	}

	private static void fillVarNamesTypes(CommonTree node, ArrayList<String> varNames, ArrayList<String> varTypes) {
		String name = node.getChild(0).getText();
		String temp = node.getChild(1).getText();
		String type = temp;
		node = (CommonTree) node.getChild(1);
		while (temp.equals("VEC")) {
			node = (CommonTree) node.getChild(0);
			temp = node.getText();
			type.concat(" ");
			type.concat(temp);
		}
		varNames.add(name);
		varTypes.add(type);
	}

}
