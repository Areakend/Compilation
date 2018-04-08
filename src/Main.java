
import Expr.ExprLexer;
import Expr.ExprParser;
import Objets.TableDesSymboles;
import Objets.Tables;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static Expr.TreeParser.analyseRec;

public class Main {
    public static void main(String[] args) throws Exception {

        String file = "ExemplesRust/testsSimples.rs";
        System.out.println("File to load: " + file);

        try {
            InputStream stream = new FileInputStream(file);
            ANTLRInputStream input = new ANTLRInputStream(stream);

            ExprLexer lexer = new ExprLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ExprParser parser = new ExprParser(tokens);



            ExprParser.fichier_return result = parser.fichier();
            CommonTree t = (CommonTree) result.getTree();

            if (file==null) {
                System.out.println("file");
            }

            if (stream==null) {
                System.out.println("stream");
            }

            if (input==null) {
                System.out.println("input");
            }

            if (lexer==null) {
                System.out.println("lexer");
            }

            if (tokens==null) {
                System.out.println("tokens");
            }

            if (parser==null) {
                System.out.println("parser");
            }

            if (result==null) {
                System.out.println("result");
            }

            if (t==null) {
                System.out.println("t");
            }

            Tables tables = new Tables();
            TableDesSymboles tds = new TableDesSymboles();
            tables.add(tds);

            analyseRec(t,tds);

            System.out.println(tables.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}