import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class TaskWithRandomNumbers {
    public static void main(String[] args) {

        Path randomNumbersFilePath = Paths.get("/Users/Valentina/data/javaio/resources/random.txt");
        Path outputPathForSortedNumbers = Paths.get("/Users/Valentina/data/javaio/resources/sortedRandom.txt");

        Random random = new Random();
        List<String> randomNumberList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            randomNumberList.add(String.valueOf(random.nextInt(1000)));
        }
        try {
            Files.write(randomNumbersFilePath, randomNumberList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {List<String> listOfNumbers = Files.readAllLines(randomNumbersFilePath);
            listOfNumbers.sort(Comparator.comparing(Integer::valueOf));
            Files.write(outputPathForSortedNumbers, listOfNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}