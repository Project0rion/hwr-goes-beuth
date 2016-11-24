import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by User on 15.11.2016.
 */
public class CSVMain extends CSVBaseListener {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // Get CSV lexer
        CSVLexer lexer = new CSVLexer(new ANTLRInputStream(new FileReader("CSVTester\\res\\CSV.csv")));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Pass the tokens to the parser
        CSVParser parser = new CSVParser(tokens);
        // Specify our entry point
        CSVParser.FileContext fileContext = parser.file();
        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        CSVBaseListener listener = new CSVMain();
        walker.walk(listener, fileContext);
    }
    public void exitFile(CSVParser.FileContext ctx) {
        System.out.println(
                "If no error outputs occurred, then file has valid format!");
        System.out.println(ctx.getText());
    }
}