import antlr.PlaygroundBaseListener;
import antlr.PlaygroundParser;

import java.util.ArrayList;

/**
 * Created by Project0rion on 12.11.2016.
 */
public class PlaygroundListenerImpl extends PlaygroundBaseListener {

    private CodeBuilder cb;

    @Override
    public void enterValue(PlaygroundParser.ValueContext ctx) {
        System.out.println("parsed PlaygroundValue: " + ctx.getText());
        cb.addValue(ctx.getText());
    }

    @Override
    public void enterRow(PlaygroundParser.RowContext ctx) {
        //TODO
    }

    @Override
    public void enterFile(PlaygroundParser.FileContext ctx) {
        System.out.println("Playground File entered");
        initPlaygroundCode();
    }

    @Override
    public void exitFile(PlaygroundParser.FileContext ctx) {
        System.out.println("parsing completed");
        finishPLaygroundCode();
    }

    public ArrayList<String> getPlaygroundCodeAsList() {
        return cb.getCodeLines();
    }

    private void initPlaygroundCode() {
        cb = new CodeBuilder();
        cb.addLine("class PlayFieldGenerator {");
        cb.addLine("public static int[][] GeneratePlayField() {");
        cb.addLine("return new int[][] {");
    }

    private void finishPLaygroundCode() {
        cb.addLine("};");
        cb.addLine("}");
        cb.addLine("}");
    }
}
