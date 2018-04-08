import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import Expr.ExprLexer;
import Expr.ExprParser;
import Expr.TreeParser;
import Objets.TableDesSymboles;
import Objets.Tables;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;

public class Main {
    public static void main(String[] args) throws Exception {

        String file = args[0];
        System.out.println("File to load: " + file);

		try {
            InputStream stream = new FileInputStream(file);
            ANTLRInputStream input = new ANTLRInputStream(stream);

            ExprLexer lexer = new ExprLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ExprParser parser = new ExprParser(tokens);

            ExprParser.fichier_return result = parser.fichier();
            CommonTree t = (CommonTree)result.getTree();

            Tables tables = new Tables();
            TableDesSymboles tds = new TDS("Global TDS");
            tables.add(globalTable);
            ast.parcoursProf(tables, globalTable, 1);


		} catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        System.exit(0);
    }
}