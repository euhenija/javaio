import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PublicToPrivateReplacement {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/Valentina/data/javaio/src/MainTask.java"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/Valentina/data/javaio/resources/replaced.java"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.append(line.replace("public", "private")).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}