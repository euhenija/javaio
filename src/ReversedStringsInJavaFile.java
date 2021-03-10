import java.io.*;
import java.util.Properties;

public class ReversedStringsInJavaFile {
    public static void main(String[] args) throws IOException {
        Properties property = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("/Users/Valentina/data/javaio/resources/mylinks.properties")) {
            property.load(fileInputStream);
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(property.getProperty("sourceFileForReplacement")));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(property.getProperty("fileAfterReverse")))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.append(new StringBuilder(line).reverse()).append(System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
