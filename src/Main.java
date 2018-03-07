import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("File to load: " + args[0]);
        ANTLRFileStream input = null;

		try {
		    input = new ANTLRFileStream(args[0]);
		} catch (IOException e) {
            e.printStackTrace();
        }
        
        System.exit(0);
    }
}