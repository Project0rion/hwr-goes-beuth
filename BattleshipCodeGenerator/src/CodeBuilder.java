import java.util.ArrayList;

/**
 * Created by Project0rion on 12.11.2016.
 */
public class CodeBuilder {

    private ArrayList<String> code = new ArrayList<>();
    private int indentLevel;

    public void incrIndent() {
        indentLevel++;
    }

    public void decrIndent() {
        indentLevel--;
    }

    public void addLine(String line) {
        String indentation = "";
        for (int i = 0; i < indentLevel; i++)
            indentation += "    ";

        code.add(indentation + line);
    }

    public void addEmptyLine() {
        addLine("");
    }

    public ArrayList<String> getCodeLines() {
        return code;
    }
}
