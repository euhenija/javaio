import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Properties;


public class TaskWithRandomNumbers {
    public static void main(String[] args) {

        Properties property = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("/Users/Valentina/data/javaio/resources/properties.properties")) {
            property.load(fileInputStream);

            String fileWithRandomNumbers = property.getProperty("fileWithRandomNumbers");
            String fileWithSortedRandomNumbers = property.getProperty("fileWithSortedRandomNumbers");

            Path randomNumbersFilePath = Paths.get(fileWithRandomNumbers);
            Path outputPathForSortedNumbers = Paths.get(fileWithSortedRandomNumbers);

            Random random = new Random();
            List<String> randomNumberList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                randomNumberList.add(String.valueOf(random.nextInt(1000)));
            }

            Files.write(randomNumbersFilePath, randomNumberList);

            List<String> listOfNumbers = Files.readAllLines(randomNumbersFilePath);
            listOfNumbers.sort(Comparator.comparing(Integer::valueOf));
            Files.write(outputPathForSortedNumbers, listOfNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

