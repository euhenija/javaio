import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

private class MainTask {
    private static void main(String[] args) {
        final String DIRECTORY_PATH = args[0];
        final String STRUCTURE_FILE_PATH = args[1];
        try (FileWriter structureFile = new FileWriter(STRUCTURE_FILE_PATH)) {
            structureFile.write(new File(DIRECTORY_PATH).getName() + "\n");

            writeDirectoryStructureToFile(DIRECTORY_PATH, structureFile);

            try ( BufferedReader structureFileReader = new BufferedReader(new FileReader("/Users/Valentina/data/javaio/resources/structure.txt"));
                  BufferedReader fileForFoldersCounting = new BufferedReader(new FileReader("/Users/Valentina/data/javaio/resources/structure.txt"));
                  BufferedReader fileForFileLengthSum = new BufferedReader(new FileReader("/Users/Valentina/data/javaio/resources/structure1.txt"))) {
//            Path path = Paths.get("/Users/Valentina/data/javaio/resources/structure1.txt");
//            long lines = Files.lines(path).count();
                long quantityOfFilesInDirectory = structureFileReader.lines().filter(p -> p.contains("|    ")).count();
                long quantityOfFoldersInDirectory = fileForFoldersCounting.lines().filter(p -> p.contains("|----")).count();
                long sumOfAllFileNameSymbols = fileForFileLengthSum.lines().filter(p -> p.contains("|    ")).mapToInt(String::length).sum();

                System.out.println("Quantity of folders in directory: " + quantityOfFoldersInDirectory);
                System.out.println("Quantity of files in directory: " + quantityOfFilesInDirectory);
//            System.out.println("Average quantity of files in folder: " + quantityOfFilesInDirectory / quantityOfFoldersInDirectory);
//            System.out.println("Average length of file name is: " + sumOfAllFileNameSymbols / quantityOfFilesInDirectory);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeDirectoryStructureToFile(String directoryPath, FileWriter structureFile) throws IOException {
        File[] listOfFoldersAndFilesInDirectory = new File(directoryPath).listFiles();

        for (File elementOfDirectory : listOfFoldersAndFilesInDirectory) {
            if (elementOfDirectory.isDirectory() && !elementOfDirectory.isHidden()) {
                structureFile.write("|----" + elementOfDirectory.getName() + "\n");
                String path = elementOfDirectory.getPath();
                writeDirectoryStructureToFile(path, structureFile);
            } else if (elementOfDirectory.isFile() && !elementOfDirectory.isHidden()) {
                structureFile.write("|    " + elementOfDirectory.getName() + "\n");
            }
        }
    }

    private static void countDifferentDirectoryElements(String filePath) {
        try (BufferedReader structureFileReader = new BufferedReader(new FileReader(filePath));
             BufferedReader fileForFoldersCounting = new BufferedReader(new FileReader(filePath));
             BufferedReader fileForFileLengthSum = new BufferedReader(new FileReader(filePath))) {

            long quantityOfFilesInDirectory = structureFileReader.lines().filter(p -> p.contains("|    ")).count();
            long quantityOfFoldersInDirectory = fileForFoldersCounting.lines().filter(p -> p.contains("|----")).count();
            long sumOfAllFileNameSymbols = fileForFileLengthSum.lines().filter(p -> p.contains("|    ")).mapToInt(String::length).sum();

            System.out.println("Quantity of folders in directory: " + quantityOfFoldersInDirectory);
            System.out.println("Quantity of files in directory: " + quantityOfFilesInDirectory);
            System.out.println("Average quantity of files in folder: " + quantityOfFilesInDirectory / quantityOfFoldersInDirectory);
            System.out.println("Average length of file name is: " + sumOfAllFileNameSymbols / quantityOfFilesInDirectory);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
