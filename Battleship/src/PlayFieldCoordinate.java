import java.text.ParseException;

/**
 * Created by Project0rion on 29.10.2016.
 */
public class PlayFieldCoordinate {

    private int column;
    private int row;

    public PlayFieldCoordinate(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public static PlayFieldCoordinate parse(String source) {
        int parsedColumn = parseChar(source.charAt(0));
        int parsedRow = parseChar(source.charAt(source.length() - 1));

        if (parsedColumn <= 0 || parsedRow <= 0)
            throw new IllegalArgumentException("column and row must be grater than zero");
        else
            return new PlayFieldCoordinate(parsedColumn - 1, parsedRow - 1);
    }

    private static int parseChar(char input) {
        int result = 0;

        try {
            result = Integer.parseInt(String.valueOf(input));
        } catch (NumberFormatException e) {

            int inputAscii = (int)input;

            if (Character.isLowerCase(input)) {
                if(inputAscii <= 122 & inputAscii >= 97)
                    result = inputAscii - 96;
            } else {
                if(inputAscii <= 90 & inputAscii >= 65)
                    result = inputAscii - 64;
            }
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PlayFieldCoordinate))
            return false;

        return column == ((PlayFieldCoordinate)obj).column && row == ((PlayFieldCoordinate)obj).row;
    }

    @Override
    public String toString() {
        return String.valueOf((char)(column + 65)) + (row + 1);
    }
}
