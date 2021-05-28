import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

public class JFiler {

    /**
     * A method that allows you to get the number of rows in a folder
     * @param path path to folder
     * @return Returns the number of rows in the folder
     */
    int getNumbersOfRowsInFolder(String path) {
        return getFilesInFolder(path).length;
    }

    /**
     * A method that determines the type of an entity (file or folder)
     * and outputs its name along with the type
     * @param pathToFolder path to folder
     */
    void getFilesInfoInFolder(String pathToFolder) {
        File[] listOfFiles = getFilesInFolder(pathToFolder);
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
                continue;
            }

            if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

    /**
     * A method that outputs a list of files from the specified directory
     * @param path path to folder
     * @return return a array of File's
     */
    File[] getFilesInFolder(String path) {
        return new File(path).listFiles();
    }

    /**
     * A method that reads a file and returns it in String[] format
     * @param path path to file
     * @return return String[] that contain each line in file
     */
    String[] readFile(String path) {
        ArrayList<String> list = new ArrayList<>();
        String[] output = null;
        Scanner reader;
        File file;

        try {
            file = new File(path);
            reader = new Scanner(file);
            while (reader.hasNextLine()) {
                list.add(reader.nextLine());
            }
            output = new String[list.size()];
            for (int i = 0; i < list.size(); i++) output[i] = list.get(i);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception");
        }
        return output;
    }

    /**
     * A method that reads a file and returns it in String[] format
     * @param file
     * @return return String[] that contain each line in file
     */
    String[] readFile(File file) {
        ArrayList<String> list = new ArrayList<>();
        String[] output = null;
        Scanner reader = null;
        try {
            if (file.isFile()) {
                reader = new Scanner(file);
                while (reader.hasNextLine()) {
                    list.add(reader.nextLine());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found exception");
        }
        output = new String[list.size()];
        for (int i = 0; i < list.size(); i++) output[i] = list.get(i);
        reader.close();
        return output;
    }

    /**
     * A method that outputs the contents of a file to the console
     * @param path path to file
     */
    void printFile(String path) {
        try {
            String[] readFileOutPut = readFile(path);
            for (int i = 0; i < readFileOutPut.length;i++) System.out.println(readFileOutPut[i]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads the number of lines in the file and returns it
     * @param path path to file
     * @return number of lines in file
     */
    int countFile(String path) {
        return readFile(path).length;
    }

    /**
     * Reads the number of lines in the file and returns it
     * @param file path to file
     * @return number of lines in file
     */
    int countFile(File file) {
        return readFile(file).length;
    }

}
