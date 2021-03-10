import java.io.*;
import java.util.Properties;


public class PublicToPrivateReplacement {
    public static void main(String[] args) throws IOException {
        Properties property = new Properties();
        FileInputStream fileInputStream = new FileInputStream("/Users/Valentina/data/javaio/resources/properties.properties");
        property.load(fileInputStream);

        String sourceFileForReplacement = property.getProperty("sourceFileForReplacement");
        String fileAfterReplacement = property.getProperty("fileAfterReplacement");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFileForReplacement));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileAfterReplacement))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.append(line.replace("public", "private")).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}