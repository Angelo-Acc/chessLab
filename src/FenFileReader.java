import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FenFileReader {
    public String[] readFenFile(String path) {
        List<String> fens = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String currentLine = reader.readLine();
            while(currentLine != null) {
                fens.add(currentLine);
                System.out.println(currentLine);
                currentLine = reader.readLine();
            }

            reader.close();
        } catch (Exception e) {
                System.out.println(e);
        } finally {
            System.out.println("Finished reading a file.");
        }

        return fens.toArray(new String[0]);
    }
    public static void main(String[] args) {
        System.out.println("fen file reader main run...");

        FenFileReader fenFileReader = new FenFileReader();
        String[] fenArray = fenFileReader.readFenFile("resources/chess_positions.fen");

        for(int i = 0; i < fenArray.length; i++) {
            System.out.println("fenArray: " + fenArray[i]);
        }
    }
}