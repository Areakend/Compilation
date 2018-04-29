package Assembleur;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.antlr.runtime.tree.CommonTree;

import Exceptions.InvalidTypeArgument;
import Expr.TreeParser;
import Objets.Arguments;
import Objets.TableDesSymboles;
import objet.ListeOffset;
import objet.Tables;



public class Code_gen {
	
	//le code micropiup que nous allons ecrire tout du long et ajouter a notre fichier excecutable
	private String code ="";
	
	//le fichier dans lequel on stockera le code
	private String filename;
	
	// objets pour ecrire dans le fichier
	private File fichier = null;
	private FileWriter out = null;
	
	// Tables neccessaire a "l'intérpretation" de l'assembleur
	private Tables listTDS;
	public static TableDesSymboles TDScourante;
	public static ListeOffset offsets;
	
	// Indice d'evolution pour les boucle for/while...
	public static int iLoop = 0;
	public static int iBoucle = 0;
	
	public Code_gen(String filename, Tables t)
	{
		this.listTDS = t;
		this.offsets = new ListeOffset();
		this.TDScourante = (TableDesSymboles) this.listeTDS.get(0);
		String[] split = filename.split("\\.");
		this.filename = split[0] + ".src";
		this.fileDeleter();
		this.fichier = new File(this.filename);
		try {
			this.out = new FileWriter(this.fichier, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	public void gen_runner(CommonTree t)
	{
			this.initialize();
			this.parcoursTree(t);
			this.out.close();
	}
	
	private void initialize()
	{
		
		code =  "EXIT_EXC 	EQU 64\n"+  	//num d'exception de EXIT
				"READ_EXC 	EQU 65\n"+  	// num d'exception de READ
				"WRITE_EXC 	EQU 66\n"+		// num d'exception de WRITE
				"STACK_ADRS EQU 0x1000\n" + //base de la pile en 1000h
				"LOAD_ADRS 	EQU 0xF000\n"+  //adresse de chargement de l'executable
				"INT_SIZE EQU 4\n"+ 		// chaque entier prend 4 case mémoire soit 32 bits
				"NIL EQU 0\n"+				// fin de liste: contenu initial de BP
				"SP		EQU R15\n"+			// alias pour R15: Stack Pointer (pointeur de pile)
				"WR		EQU R14\n"+			// alias pour R14: Work Register (reg. de travail)
				"BP 	EQU R13\n" +		//alias pour R13: frame Base Pointer (point. envir.)
				"ORG LOAD_ADRS\n"+			// adresse de chargement
				"START main\n\n\n";  		// adresse de démarrage 
		
				/*
				"main LDW SP,#STACK_ADRS\n "+
				"LDW BP, #NIL\n" +
				"STW BP,-(SP)\n" +
				"LDW BP,SP\n";
				*/
		this.add();
	}
	
	private void add()
	{
		try {
			this.out.write(code);
			code = "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void parcoursTree(CommonTree t) {

		if (t.isNil()) {
			
		
			int nbChilds = t.getChildCount();
			for (int i = 0; i < nbChilds; i++)
				parcoursTree((CommonTree) t.getChild(i));
		
		} else {

			switch (t.getText()) {
			
			case "DECL": 
				// on assigne une case mémoire pour le truc a gauche / 
				// on cherche sa case avec le déplacement dans la TDS
				parcoursTree((CommonTree) t.getChild(1));
				// on place la valeur de l'expr dans la case mémoire
			case "BLOC": {
				for(int i=0; i<t.getChildCount();i++) {
					// on parcours les differents enfants
					parcoursTree((CommonTree) t.getChild(i));
				}
				break;
			}
			case "IF":
				//test de la condition
				code = ""
				this.GenerateIf.gen_runner();
				String test=t.getChild(0).getText();
				String filsgauche=t.getChild(0).getChild(0).getText();
				String filsdroit=t.getChild(0).getChild(1).getText();
				
				if(filsgauche.is
				code += "LDW R0,#"+ filsgauche + "\n" +
						"LDW R1,#"+ filsdroit  + "\n" ;
				
				switch(test) {
				case "==":
				case "!=":
				case "<":
				case ">":
				case "=>":
				case "<=":
					
				}
				//si oui lecture du bloc enfant 1
				//si non lecture du ELSE enfant 2/passage au bloc suivant si il n'y a pas d'alternative
				break;
				
			case "WHILE":
				TreeParser.analyseExp((CommonTree) t.getChild(0), tds);
				//test de la condition
				//si oui ecriture du bloc enfant
				//retour sur la condition
				//si non on saute au bloc suivant
				break;
			case "FUNC":
				//ecriture du bloc de fonction
				break;
			case "print":
				//lecture de la case variable en question 
				//on continue la lecture
			case "RETURN":
				// on place dans la case mémoire de retour de la fonction l'info en question
				parcoursTree((CommonTree) t.getChild(0));
				break;
				
			case "+":
			case "-":
			case "*":
			case "/":
				//on réalise les opération en succésives
			case "&&":
			case "||":
				//opérations logique

				
			}
		}
	}
	
	private void fileDeleter()
	{
		File file = new File(filename);
		if(file.exists())
		{
			file.delete();
		}
	}
	
	
	
}