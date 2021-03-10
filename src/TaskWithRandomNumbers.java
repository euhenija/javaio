import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Properties;


public class TaskWithRandomNumbers {
    public static void main(String[] args) {

        Properties property = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("/Users/Valentina/data/javaio/resources/mylinks.properties")) {
            property.load(fileInputStream);

            Path randomNumbersFilePath = Paths.get(property.getProperty("fileWithRandomNumbers"));
            Path outputPathForSortedNumbers = Paths.get(property.getProperty("fileWithSortedRandomNumbers"));
            try (FileWriter structureFile = new FileWriter(property.getProperty("fileWithRandomNumbers"))) {
                Random random = new Random();
                for (int i = 0; i < 10; i++) {
                    structureFile.write(random.nextInt(1000) + "\n");
                }
            }

            List<String> listOfNumbers = Files.readAllLines(randomNumbersFilePath);
            listOfNumbers.sort(Comparator.comparing(Integer::valueOf));
            Files.write(outputPathForSortedNumbers, listOfNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

