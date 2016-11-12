import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class BattleshipPlayFieldGenerator {

    static BufferedReader br = null;
    static ArrayList<String> textFromFile = new ArrayList<>();

    public static void main(String[] args) {
        readFromFileAndGenerate();
    }

    public static void readFromFileAndGenerate() {
        try {

            String sCurrentLine;

            Path currentRelativePath = Paths.get("BattleshipCodeGenerator\\res\\battlefield.txt");
            String s = currentRelativePath.toAbsolutePath().toString();
            File txtFile = new File(s);
            br = new BufferedReader(new FileReader(txtFile));

            textFromFile.add("");
            textFromFile.add("class PlayFieldGenerator {");
            textFromFile.add("    public static int[][] GeneratePlayField() {");
            textFromFile.add("        return new int[][] {");

            while ((sCurrentLine = br.readLine()) != null) {
                textFromFile.add("            " + generateLine(sCurrentLine));
            }

            textFromFile.add("        };");
            textFromFile.add("    }");
            textFromFile.add("}");

            writeFile();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("PlayFieldGenerator successfully generated");
    }

    private static String generateLine(String lineFromFile) {
        String resultLine = "{";
        String[] separatedLine = lineFromFile.split(" ");

        for (String element : separatedLine) {
            resultLine += element + ", ";
        }

        resultLine += "},";

        return resultLine;
    }

    public static void writeFile() {
        try {
            Path file = Paths.get("BattleshipCodeGenerator\\gen\\PlayFieldGenerator.java");
            Files.write(file, textFromFile, Charset.forName("UTF-8"));

        } catch (IOException ioEx) {
            //was soll passieren :D
        }
    }
}
