import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

private class MainTask {
    private static void main(String[] args) {

        try (FileWriter structureFile = new FileWriter("/Users/Valentina/data/javaio/resources/structure.txt", true)) {
            structureFile.write(new File(args[0]).getName() + "\n");
            File[] listOfFoldersAndFilesInDirectory = new File(args[0]).listFiles();

            for (File elementOfDirectory : listOfFoldersAndFilesInDirectory) {
                if (elementOfDirectory.isDirectory()) {
                    structureFile.write("|----" + elementOfDirectory.getName() + "\n");
                    File content = new File(elementOfDirectory.getPath());
                    File[] listOfFolderElements = content.listFiles();
                    for (File folderElement : listOfFolderElements) {
                        structureFile.write("|    " + folderElement.getName() + "\n");
                    }
                } else {
                    structureFile.write("|    " + elementOfDirectory.getName() + "\n");
                }
                structureFile.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
