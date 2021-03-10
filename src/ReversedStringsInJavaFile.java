import java.io.*;
import java.util.Properties;

public class ReversedStringsInJavaFile {
    public static void main(String[] args) throws IOException {
        Properties property = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("/Users/Valentina/data/javaio/resources/properties.properties")) {
            property.load(fileInputStream);
        }

        final String sourceFileForReverse = property.getProperty("sourceFileForReplacement");
        final String fileAfterReverse = property.getProperty("fileAfterReverse");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFileForReverse));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileAfterReverse))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.append(new StringBuilder(line).reverse()).append(System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
