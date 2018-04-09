package Expr;

import Exceptions.*;
import Objets.*;
import org.antlr.runtime.tree.CommonTree;

import java.util.ArrayList;

public class TreeParser {
	public static void analyseRec(CommonTree t, TableDesSymboles tds) throws Exception {

		if (t.getText().equals("nil")) {
			int nbChilds = t.getChildCount();

			for (int i = 0; i < nbChilds; i++)
				TreeParser.analyseRec((CommonTree) t.getChild(i), tds);
		}

		if (t.getText().equals("DECL")) {
			String name;
			boolean mut = false;
			int nbChilds = t.getChildCount();

			if (nbChilds == 1)
				name = t.getChild(0).getText();
			else if (nbChilds == 2) {
				if (t.getChild(1).getChildCount() == 0) {
					mut = true;
					name = t.getChild(1).getText();
				} else
					name = t.getChild(0).getText();
			} else {
				mut = true;
				name = t.getChild(1).getText();
			}

			if (t.getChild(nbChilds - 1).getChildCount() > 0) { // AFFECT
				CommonTree node = (CommonTree) t.getChild(nbChilds - 1);
				String value = TreeParser.analyseExp((CommonTree) node.getChild(0), tds);
				tds.ajouterVariable(name, mut, value);
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

			tds.ajouterStructure(nameStruct, varNames, varTypes);
		}

		if (t.getText().equals("BLOC")) {
			TableDesSymboles tds2 = new TableDesSymboles(tds);
			int nbChilds = t.getChildCount();

			for (int i = 0; i < nbChilds; i++)
				TreeParser.analyseRec((CommonTree) t.getChild(i), tds2);
		}

		if (t.getText().equals("IF")) {
			TreeParser.analyseExp((CommonTree) t.getChild(0), tds);
			for (int i = 1; i < t.getChildCount(); i++)
				TreeParser.analyseRec((CommonTree) t.getChild(i), tds);
		}

		if (t.getText().equals("ELSE")) {
			TreeParser.analyseRec((CommonTree) t.getChild(0), tds);
		}

		if (t.getText().equals("WHILE")) {
			TreeParser.analyseExp((CommonTree) t.getChild(0), tds);
			TreeParser.analyseRec((CommonTree) t.getChild(1), tds);
		}

		if (t.getText().equals("FUNC")) {
			String nameFunc = t.getChild(0).getText();
			String returnType = null;
			Arguments args = null;
			ArrayList<String> argNames;
			ArrayList<String> argTypes;

			for (int i = 1; i < t.getChildCount(); i++) {
				CommonTree node = (CommonTree) t.getChild(i);
				switch (node.getText()) {
				case "FUNC_ARGS":
					argNames = new ArrayList<>();
					argTypes = new ArrayList<>();

					for (int j = 0; j < node.getChildCount(); j++) {
						CommonTree node2 = (CommonTree) node.getChild(j);
						fillVarNamesTypes(node2, argNames, argTypes);
					}

					args = new Arguments(argNames, argTypes, null);
					break;
				case "BLOC":
					tds.ajouterFonction(nameFunc, returnType, args);
					TreeParser.analyseRec(node, tds);
					break;
				default:
					returnType = node.getText();
					break;
				}
			}
		}

		if (t.getText().equals("print") || t.getText().equals("RETURN"))
			TreeParser.analyseExp((CommonTree) t.getChild(0), tds);
	}

	private static String analyseExpUnaire(CommonTree t, String spe_unaire, TableDesSymboles tds) throws Exception {
		switch (spe_unaire) {
		case "-":
			return "-" + analyseExp(t, tds);
		case "!":
			return "!" + analyseExp(t, tds);
		case "&":
			return "&" + analyseExp(t, tds);
		case "*":
			return "*" + analyseExp(t, tds);
		default:
			return "";
		}

	}

	private static String analyseExp(CommonTree t, TableDesSymboles tds) throws Exception {
		String s = t.getText();

		switch (s) {
		case "SPE_UNAIRE":
			return analyseExpUnaire((CommonTree) t.getChild(1), t.getChild(0).getText(), tds);
		case "+":
		case "-":
		case "*":
		case "/":
		case "<":
		case "<=":
		case ">":
		case ">=":
		case "==":
		case "!=":
		case "&&":
		case "||":
			String fg = TreeParser.analyseExp((CommonTree) t.getChild(0), tds);
			String fd = TreeParser.analyseExp((CommonTree) t.getChild(1), tds);

			switch (s) {
			case "+":
				return fg + " + " + fd;
			case "-":
				return fg + " - " + fd;
			case "*":
				return fg + "*" + fd;
			case "/":
				return fg + "/" + fd;
			case "<":
				return fg + "<" + fd;
			case "<=":
				return fg + "<=" + fd;
			case ">":
				return fg + ">" + fd;
			case ">=":
				return fg + ">=" + fd;
			case "==":
				return fg + "==" + fd;
			case "!=":
				return fg + "!=" + fd;
			case "&&":
				return fg + "&&" + fd;
			case "||":
				return fg + "||" + fd;
			}
			break;
		default:
			if (isInteger(t.getText())) {
				return t.getText();
			} else {
				int nbChilds = t.getChildCount();
				if (nbChilds == 0) {
					try {
						TableDesVariables tdv = ((TableDesVariables) (tds.get(TableType.VAR)));
						System.out.println("s");
						System.out.println(s);
						System.out.println("tdv");
						System.out.println(tdv);
						Variable variable = tdv.getVariable(tds, s);
						return variable.getName();
					} catch (NonExistantVariable nonExistantVariable) {
					}
				} else if (t.getChild(0).getText().equals("IND")) {
					String name = t.getText();
					t = (CommonTree) t.getChild(0).getChild(0);

					try {
						Vecteur vect = ((TableDesVecteurs) (tds.get(TableType.VEC))).getVecteur(tds, name);

						if (t.getChildCount() == 0) {
							try {
								String variable = TreeParser.analyseExp(t, tds);
								isSameTypeVecteurVariable(vect.getName(), vect.getType(), variable, findType(variable));
							} catch (InvalidVecteurVariableType e) {
							}
						} else if (t.getChild(0).getText().equals("IND")) {
							try {
								TreeParser.analyseExp(t, tds);
								Vecteur vectFils = ((TableDesVecteurs) (tds.get(TableType.VEC))).getVecteur(tds,
										t.getChild(0).getText());
								isSameTypeVecteurVariable(vect.getName(), vect.getType(), vectFils.getName(),
										vectFils.getType());
							} catch (InvalidVecteurVariableType e) {
							} catch (NonExistantVecteur e2) {
							}
						} else if (t.getChild(0).getText().equals("CALL_ARGS")) {
							try {
								Fonction fonctionFils = ((TableDesFonctions) (tds.get(TableType.FONC))).getFonction(tds,
										t.getChild(0).getText());
								isSameTypeVecteurVariable(vect.getName(), vect.getType(), fonctionFils.getName(),
										fonctionFils.getReturnType());
							} catch (InvalidVecteurVariableType e) {
							}
							catch (NonExistantFunction e2){
								
							}
							 /*
								 * } else if (t.getChild(0).getText() ==
								 * "ASSOC") { Structure structureFils =
								 * ((TableDesStructures)
								 * (tds.get(TableType.STRUCT)))
								 * .getStructure(tds, t.getChild(0).getText());
								 * isSameTypeStructureVariable(vect.getName(),
								 * vect.getType(), structureFils.getName(),
								 * structureFils.getReturnType());
								 */

						} else if (t.getChild(0).getText().equals("CALL_ARGS")) {
							String name1 = t.getText();
							try {
								Fonction fonc = ((TableDesFonctions) (tds.get(TableType.FONC))).getFonction(tds, name1);
								t = (CommonTree) t.getChild(0);
								int nbChilds2 = t.getChildCount();
								try {
									fonc.validNumberArgs(fonc, nbChilds2);

									for (int i = 0; i < nbChilds2; i++) {
										String theoricalType = fonc.getArgs().getTypes().get(i);
										String nameVal = t.getChild(i).getText();
										String realType = TreeParser.findType(nameVal);

										try {
											TreeParser.isSameType(name1, theoricalType, realType);
											try {
												boolean theoricalPointerType = fonc.getArgs().getPointeurs().get(i);
												char pointertest[] = null;

												nameVal.getChars(0, 0, pointertest, 0);
												TreeParser.isSamePointerType(theoricalPointerType, pointertest[0]);

												if (fonc.getReturnType() == null) {
													return null;
												}
												// return Calcul valeur de
												// fonction(args);
											} catch (PointerTypeException pointeurTypeException) {

											}

										} catch (InvalidTypeArgument invalidTypeArgument) {
										}

									}
									if (nbChilds2 == 0) {
										if (fonc.getReturnType() == null) {
											return null;
										}
										// ajouter valeur fonction dans le cas 0
										// args
									}
								} catch (InvalidArgumentsNumber invalidArgumentsNumber) {
								}
							} catch (NonExistantFunction nonExistantFunction) {
							}
						}
					} catch (NonExistantVariable e) {
					}
					break;
				}

			}
		}
		return null;

	}

	private static void fillVarNamesTypes(CommonTree node, ArrayList<String> varNames, ArrayList<String> varTypes) {
		String name = node.getChild(0).getText();
		String temp = node.getChild(1).getText();
		String type = temp;
		node = (CommonTree) node.getChild(1);

		while (temp.equals("VEC")) {
			node = (CommonTree) node.getChild(0);
			temp = node.getText();
			type = type.concat(" ");
			type = type.concat(temp);
		}

		varNames.add(name);
		varTypes.add(type);
	}

	public static String findType(String value) {
		try {
			Integer.parseInt(value);
			return "i32";
		} catch (NumberFormatException e) {
			return isBoolean(value) ? "bool" : "";
		}
	}

	private static void isSameType(String name, String theoricalType, String realType) throws InvalidTypeArgument {
		if (!(theoricalType.equals(realType)))
			throw new InvalidTypeArgument(name, theoricalType, realType);
	}

	private static void isSameTypeVecteurVariable(String vecteurName, String vecteurType, String variableName,
			String variableType) throws InvalidVecteurVariableType {
		if (variableType == null)
			throw new InvalidVecteurVariableType(vecteurName, vecteurType, variableName, variableType);

		if (!(vecteurType.equals(variableType)))
			throw new InvalidVecteurVariableType(vecteurName, vecteurType, variableName, variableType);
	}

	private static void isSamePointerType(Boolean VV, char test) throws PointerTypeException {
		if (!((VV && test == '*') || (!VV && test != '*')))
			throw new PointerTypeException(VV, test);
	}

	private static boolean isBoolean(String str) {
		return (str.equals("true") || str.equals("false"));
	}

	private static Boolean isInteger(String str) {
		int length = str.length(), c;

		if (length == 0)
			return false;

		for (int i = 0; i < length; i++) {
			c = (int) str.charAt(i) - 48;

			if (!(c >= 0 && c < 10))
				return false;
		}

		return true;
	}
}