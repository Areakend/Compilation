package Assembleur;

import org.antlr.runtime.tree.CommonTree;

import objet.ListeOffset;
import objet.Offset;
import objet.TableDesSymboles;


public class GenerateIf {

	public String gen_runner(CommonTree t){
		String test = t.getChild(0).getText();
		String code="";
		String isElse = "";
		
		if (t.getChildCount()==3) {
			isElse="ELSE";
		}else {
			isElse="FI";
		}
		
		if (t.getChild(0).getChildCount()>0) { //plusieurs enfant donc comparaison
			String fg = t.getChild(0).getChild(0).getText();
			String fd = t.getChild(0).getChild(1).getText();
			if ("true".equals(fg) || "false".equals(fg)) {
				code += "LDW R0,#"+fg+"\n";
			} else {
				Offset var_offset = offsets.getbyID(fg,TDScourante.getId());
				code += "LDW R0, (BP) - " + var_offset.getDeplacement() + "\n";
			}
			if ("true".equals(fd) || "false".equals(fd)) {
				code += "LDW R1,#"+fd+"\n";
			} else {
				Offset var_offset = offsets.getbyID(fd,TDScourante.getId());
				code += "LDW R1, (BP) - " + var_offset.getDeplacement() + "\n";
			}
			
			code += "CMP R0,R1\n";
			
			switch(test){
			case "==":
				code +=  "BEQ BLOC" + Code_gen.iLoop+"-$-2\n"
						+"BNE" + isElse + Code_gen.iLoop+"-$-2\n";
				break;
		
			case "!=":
				code +=  "BNE BLOC" + Code_gen.iLoop+"-$-2\n"
						+"BEQ" + isElse + Code_gen.iLoop+"-$-2\n" ;
				break;
			case "<":
				code +=  "BLW BLOC"+ Code_gen.iLoop+"-$-2\n"
						+"BGE" + isElse + Code_gen.iLoop+"-$-2\n";
				break;
			case ">":
				code +=  "BGT BLOC" + Code_gen.iLoop+"-$-2\n"
						+"BLE" + isElse + Code_gen.iLoop+"-$-2\n";
				break;
			case "=>":
				code +=  "BGE BLOC"+ Code_gen.iLoop+"-$-2\n"
						+"BLW" + isElse + Code_gen.iLoop+"-$-2\n";
				break;
			case "<=":
				code +=  "BLE BLOC" + Code_gen.iLoop+"-$-2\n"
						+"BGT" + isElse + Code_gen.iLoop+"-$-2\n";
				break;
			}
		} else { //cas ou il n'y a pas de comparaison mais juste une constante/variable
			
			if("true".equals(test) || "false".equals(test)) {
				code =  "CMP #"+ test + ", #true \n"
					 + "BEQ BLOC"     + Code_gen.iLoop+"-$-2\n"
					 + "BNE" + isElse + Code_gen.iLoop+"-$-2\n";
			} else {// cas ou on a juste une variable 
				Offset var_offset = offsets.getbyID(t.getChild(0).getText(),TDScourante.getId());
				code = "LDW R0, (BP) - " + var_offset.getDeplacement() + "\n"
						+ "CMP #"+ test + ", #true \n"
						+ "BEQ BLOC"     + Code_gen.iLoop+"-$-2\n"
						+ "BNE" + isElse + Code_gen.iLoop+"-$-2\n";
			}
		}
		return code;
	}
}
