import java.io.*;
import java.util.Properties;


public class PublicToPrivateReplacement {
    public static void main(String[] args) throws IOException {
        Properties property = new Properties();
        FileInputStream fileInputStream = new FileInputStream("/Users/Valentina/data/javaio/resources/mylinks.properties");
        property.load(fileInputStream);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(property.getProperty("sourceFileForReplacement")));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(property.getProperty("fileAfterReplacement")))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.append(line.replace("public", "private")).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}