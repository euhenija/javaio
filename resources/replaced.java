import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

private class MainTask {
    private static void main(String[] args) {

        try (FileWriter structureFile = new FileWriter(args[1])) {
            structureFile.write(new File(args[0]).getName() + "\n");
            File[] listOfFoldersAndFilesInDirectory = new File(args[0]).listFiles();

            assert listOfFoldersAndFilesInDirectory != null;
            for (File elementOfDirectory : listOfFoldersAndFilesInDirectory) {
                structureFile.write("|----" + elementOfDirectory.getName() + "\n");
                File content = new File(elementOfDirectory.getPath());
                File[] listOfFolderElements = content.listFiles();
                assert listOfFolderElements != null;
                for (File folderElement : listOfFolderElements) {
                    structureFile.write("|    " + folderElement.getName() + "\n");
                }
                structureFile.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void inspectDirectory(String directoryPath, FileWriter structureFile) throws IOException {
//        File[] listOfFoldersAndFilesInDirectory = new File(directoryPath).listFiles();
//        for (File elementOfDirectory : listOfFoldersAndFilesInDirectory){
//            if (elementOfDirectory.isDirectory()){
//                structureFile.write("|----" + elementOfDirectory.getName() + "\n");
//                elementOfDirectory.in
//            }
//        }
//    }
}
