import antlr.PlaygroundBaseListener;
import antlr.PlaygroundLexer;
import antlr.PlaygroundParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by User on 16.11.2016.
 */
public class AntlrCodeCreator extends PlaygroundBaseListener {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        PlaygroundLexer lexer = new PlaygroundLexer(new ANTLRInputStream(new FileReader("AntlerCodeCreator\\res\\playground")));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Pass the tokens to the parser
        PlaygroundParser parser = new PlaygroundParser(tokens);
        // Specify our entry point
        PlaygroundParser.FileContext fileContext = parser.file();
        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        PlaygroundListenerImpl listener = new PlaygroundListenerImpl();
        walker.walk(listener, fileContext);

        try {
            FileUtils.writeFile("AntlerCodeCreator\\gen\\Playground.java", listener.getPlaygroundCodeAsList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
