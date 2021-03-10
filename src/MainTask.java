import java.io.*;

public class MainTask {
    public static void main(String[] args) {

        try (FileWriter structureFile = new FileWriter(args[1]);
             BufferedReader structureFileReader = new BufferedReader(new FileReader(args[1]));
             BufferedReader fileForFoldersCounting = new BufferedReader(new FileReader(args[1]));
             BufferedReader fileForFileLengthSum = new BufferedReader(new FileReader(args[1]))) {
            structureFile.write(new File(args[0]).getName() + "\n");

            writeDirectoryStructureToFile(args[0], structureFile);

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

    public static void writeDirectoryStructureToFile(String directoryPath, FileWriter structureFile) throws IOException {
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
}
