import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * Created by Project0rion on 12.11.2016.
 */
public class BattleshipOpponentGenerator {

    public static void main(String[] args) {

        String opponentInstructions = null;
        try {
            opponentInstructions = FileUtils.readFile("BattleshipCodeGenerator\\res\\opponent.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        OpponentLexer lexer = new OpponentLexer(new ANTLRInputStream(opponentInstructions));

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        OpponentParser parser = new OpponentParser(tokens);

        // Specify our entry point
        OpponentParser.InstructionsContext opponentInstructionsContext = parser.instructions();

        // Walk it and attach our listener
        ParseTreeWalker walker = new ParseTreeWalker();
        OpponentListenerImpl listener = new OpponentListenerImpl();
        walker.walk(listener, opponentInstructionsContext);

        try {
            FileUtils.writeFile("BattleshipCodeGenerator\\gen\\Opponent.java", listener.getOpponentCodeAsList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
