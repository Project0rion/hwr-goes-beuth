import java.util.ArrayList;

/**
 * Created by Project0rion on 12.11.2016.
 */
public class OpponentListenerImpl extends OpponentBaseListener {

    private CodeBuilder cb;

    @Override
    public void enterInstructions(OpponentParser.InstructionsContext ctx) {
        System.out.println("Opponent instructions entered");
        initOpponentCode();
    }

    @Override
    public void enterShootSentence(OpponentParser.ShootSentenceContext ctx) {
        System.out.println("parsed ShootSentence: " + ctx.SHOOT() + " " + ctx.coordinate().COLUMN() + ctx.coordinate().ROW());
        cb.addLine("targetCoordinates.add(PlayFieldCoordinate.parse(\"" + ctx.coordinate().COLUMN() + ctx.coordinate().ROW() + "\"));");
    }

    @Override
    public void exitInstructions(OpponentParser.InstructionsContext ctx) {
        System.out.println("parsing completed");
        finishOpponentCode();
    }

    public ArrayList<String> getOpponentCodeAsList() {
        return cb.getCodeLines();
    }

    private void initOpponentCode() {
        cb = new CodeBuilder();
        cb.addLine("import java.util.ArrayDeque;");
        cb.addLine("import java.util.Queue;");
        cb.addLine("import java.util.Random;");
        cb.addEmptyLine();
        cb.addLine("public class Opponent {");
        cb.incrIndent();
        cb.addEmptyLine();
        cb.addLine("private Queue<PlayFieldCoordinate> targetCoordinates;");
        cb.addLine("private Random random;");
        cb.addEmptyLine();
        cb.addLine("public Opponent() {");
        cb.incrIndent();
        cb.addLine("random = new Random();");
        cb.addEmptyLine();
        cb.addLine("targetCoordinates = new ArrayDeque<>();");
    }

    private void finishOpponentCode() {
        cb.decrIndent();
        cb.addLine("}");
        cb.addEmptyLine();
        cb.addLine("public PlayFieldCoordinate shoot(int[][] targetPlayField) {");
        cb.incrIndent();
        cb.addLine("PlayFieldCoordinate targetCoordinate = null;");
        cb.addEmptyLine();
        cb.addLine("while (targetCoordinate == null) {");
        cb.incrIndent();
        cb.addLine("PlayFieldCoordinate coordinateCandidate = targetCoordinates.poll();");
        cb.addEmptyLine();
        cb.addLine("if (coordinateCandidate == null)");
        cb.incrIndent();
        cb.addLine("coordinateCandidate = shootRandomly(targetPlayField);");
        cb.decrIndent();
        cb.addEmptyLine();
        cb.addLine("if (coordinateCandidate.getRow() > targetPlayField.length - 1 || coordinateCandidate.getColumn() > targetPlayField[0].length - 1)");
        cb.incrIndent();
        cb.addLine("continue;");
        cb.decrIndent();
        cb.addEmptyLine();
        cb.addLine("if (targetPlayField[coordinateCandidate.getRow()][coordinateCandidate.getColumn()] == PlayFieldSymbols.UNKNOWN)");
        cb.incrIndent();
        cb.addLine("targetCoordinate = coordinateCandidate;");
        cb.decrIndent();
        cb.decrIndent();
        cb.addLine("}");
        cb.addEmptyLine();
        cb.addLine("return targetCoordinate;");
        cb.decrIndent();
        cb.addLine("}");
        cb.addEmptyLine();
        cb.addLine("private PlayFieldCoordinate shootRandomly(int[][] targetPlayField) {");
        cb.incrIndent();
        cb.addLine("PlayFieldCoordinate targetCoordinate = null;");
        cb.addEmptyLine();
        cb.addLine("do {");
        cb.incrIndent();
        cb.addLine("int randomRow = random.nextInt(targetPlayField.length);");
        cb.addLine("int randomColumn = random.nextInt(targetPlayField[0].length);");
        cb.addEmptyLine();
        cb.addLine("if (targetPlayField[randomRow][randomColumn] == PlayFieldSymbols.UNKNOWN)");
        cb.incrIndent();
        cb.addLine("targetCoordinate = new PlayFieldCoordinate(randomColumn, randomRow);");
        cb.decrIndent();
        cb.addEmptyLine();
        cb.decrIndent();
        cb.addLine("}");
        cb.addLine("while (targetCoordinate == null);");
        cb.addEmptyLine();
        cb.addLine("return targetCoordinate;");
        cb.decrIndent();
        cb.addLine("}");
        cb.decrIndent();
        cb.addLine("}");
    }
}
