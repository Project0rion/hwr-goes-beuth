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
        if(ctx.getText().equals("w")) {
            cb.addValue("0,");
        }
        else if(ctx.getText().equals("s")) {
            cb.addValue("1,");
        }
    }

    @Override
    public void exitRow(PlaygroundParser.RowContext ctx) {

        cb.addValue("},");
    }

    @Override
    public void enterRow(PlaygroundParser.RowContext ctx) {
        cb.addEmptyLine();
        cb.addValue("{");
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
        cb.incrIndent();
        cb.addLine("public static int[][] GeneratePlayField() {");
        cb.incrIndent();
        cb.addLine("return new int[][] {");
        cb.incrIndent();
    }

    private void finishPLaygroundCode() {
        cb.decrIndent();
        cb.addLine("};");
        cb.decrIndent();
        cb.addLine("}");
        cb.decrIndent();
        cb.addLine("}");
    }
}
