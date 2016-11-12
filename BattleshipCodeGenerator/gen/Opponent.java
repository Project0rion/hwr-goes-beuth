import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class Opponent {
    
    private Queue<PlayFieldCoordinate> targetCoordinates;
    private Random random;
    
    public Opponent() {
        random = new Random();
        
        targetCoordinates = new ArrayDeque<>();
        targetCoordinates.add(PlayFieldCoordinate.parse("A6"));
        targetCoordinates.add(PlayFieldCoordinate.parse("b2"));
        targetCoordinates.add(PlayFieldCoordinate.parse("C3"));
        targetCoordinates.add(PlayFieldCoordinate.parse("D1"));
        targetCoordinates.add(PlayFieldCoordinate.parse("E5"));
        targetCoordinates.add(PlayFieldCoordinate.parse("A4"));
        targetCoordinates.add(PlayFieldCoordinate.parse("A2"));
        targetCoordinates.add(PlayFieldCoordinate.parse("B5"));
        targetCoordinates.add(PlayFieldCoordinate.parse("C1"));
        targetCoordinates.add(PlayFieldCoordinate.parse("D7"));
        targetCoordinates.add(PlayFieldCoordinate.parse("E1"));
        targetCoordinates.add(PlayFieldCoordinate.parse("F4"));
    }
    
    public PlayFieldCoordinate shoot(int[][] targetPlayField) {
        PlayFieldCoordinate targetCoordinate = null;
        
        while (targetCoordinate == null) {
            PlayFieldCoordinate coordinateCandidate = targetCoordinates.poll();
            
            if (coordinateCandidate == null)
                coordinateCandidate = shootRandomly(targetPlayField);
            
            if (coordinateCandidate.getRow() > targetPlayField.length - 1 || coordinateCandidate.getColumn() > targetPlayField[0].length - 1)
                continue;
            
            if (targetPlayField[coordinateCandidate.getRow()][coordinateCandidate.getColumn()] == PlayFieldSymbols.UNKNOWN)
                targetCoordinate = coordinateCandidate;
        }
        
        return targetCoordinate;
    }
    
    private PlayFieldCoordinate shootRandomly(int[][] targetPlayField) {
        PlayFieldCoordinate targetCoordinate = null;
        
        do {
            int randomRow = random.nextInt(targetPlayField.length);
            int randomColumn = random.nextInt(targetPlayField[0].length);
            
            if (targetPlayField[randomRow][randomColumn] == PlayFieldSymbols.UNKNOWN)
                targetCoordinate = new PlayFieldCoordinate(randomColumn, randomRow);
            
        }
        while (targetCoordinate == null);
        
        return targetCoordinate;
    }
}
