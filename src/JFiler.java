import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JFiler {

    /**
     * Function that allows to get number of lines in folders
     * @param path path to folder
     * @return return sum of lines in every file of folder
     */
    int getLinesInFolder(String path) {
        int counter = 0;
        File[] files = getFilesInFolder(path);
        for (int i = 0; i < files.length; i++) counter += countFile(files[i]);

        return counter;
    }

    /**
     * Function that print type (File/Directory) and name of file in folder
     * @param pathToFolder path to folder
     */
    void getFileNamesOfFolder(String pathToFolder) {
        File[] listOfFiles = getFilesInFolder(pathToFolder);

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

    /**
     * Function that return array of files in directory
     * @param path path to folder
     * @return return a array of File's
     */
    File[] getFilesInFolder(String path) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        return listOfFiles;
    }

    /**
     * Function that helps to see a containment of file
     * @param path path to file
     * @return return array of string's that contain each line in file
     */
    String[] readFile(String path) {
        String data;
        String[] output = new String[0];

        try {

            File file = new File(path);
            Scanner myReader = new Scanner(file);
            ArrayList<String> list = new ArrayList<>();

            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                list.add(data);
            }

            output = new String[list.size()];
            for (int i = 0; i < list.size(); i++) output[i] = list.get(i);

            myReader.close();

            return output;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return output;
    }

    /**
     * Function that helps to see a containment of file
     * @param file file in File format
     * @return return array of string's that contain each line in file
     */
    String[] readFile(File file) {
        String data;
        String[] output = new String[0];

        try {

            if (file.isFile()) {
                Scanner myReader = new Scanner(file);
                ArrayList<String> list = new ArrayList<>();

                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                    list.add(data);
                }

                output = new String[list.size()];
                for (int i = 0; i < list.size(); i++) output[i] = list.get(i);

                myReader.close();

                return output;
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return output;
    }

    /**
     * Method that get a containment of file from readFile() method and prints it
     * @param path path to file
     */
    void printFile(String path) {
        try {
            String[] readFileOutPut = readFile(path);
            for (int i = 0; i < readFileOutPut.length;i++) System.out.println(readFileOutPut[i]);
        } catch (Exception e) {
            System.err.println("{JFiler}(printFile): Some error was occurred:\n");
            e.printStackTrace();
        }
    }

    /**
     * Count a number of lines in file
     * @param path path to file
     * @return number of lines in file
     */
    int countFile(String path) {
        int counter = 0;
        try {
            String[] readFileOutPut = readFile(path);
            for (int i = 0; i < readFileOutPut.length;i++) counter++;
        } catch (Exception e) {
            System.err.println("{JFiler}(countFile): Some error was occurred:\n");
            e.printStackTrace();
        }
        return counter;
    }

    /**
     * Count a number of lines in file
     * @param file file in File's format
     * @return number of lines in file
     */
    int countFile(File file) {
        int counter = 0;
        try {
            String[] readFileOutPut = readFile(file);
            for (int i = 0; i < readFileOutPut.length; i++) counter++;
        } catch (Exception e) {
            System.err.println("{JFiler}(countFile): Some error was occurred:\n");
            e.printStackTrace();
        }
        return counter;
    }

}
