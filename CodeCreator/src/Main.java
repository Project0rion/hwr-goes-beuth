import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Main {

    static BufferedReader br = null;
    static ArrayList<String> textFromFile = new ArrayList<String>();

    public static void main(String[] args) {
        readFromFile();
    }

    public static void readFromFile() {
        try {

            String sCurrentLine;

            Path currentRelativePath = Paths.get("battlefield.txt");
            String s = currentRelativePath.toAbsolutePath().toString();
            File txtFile = new File(s);
            br = new BufferedReader(new FileReader(txtFile));



            textFromFile.add("");
            textFromFile.add("class PlayFieldGenerator {");
            textFromFile.add("   public static int[][] GeneratePlayField() {");
            textFromFile.add("       return new int[][] {");


            while ((sCurrentLine = br.readLine()) != null) {
                textFromFile.add(sCurrentLine);
            }

            textFromFile.add("      }");
            textFromFile.add("   }");
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
    }

    public static void writeFile() {
        try {
            Path file = Paths.get("PlayFieldGenerator.java");
            Files.write(file, textFromFile, Charset.forName("UTF-8"));

        } catch (IOException ioEx) {
            //was soll passieren :D
        }
    }
}
