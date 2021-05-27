import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JFiler {

    // getLine by line index
    // getKeyword by key input
    // add main();

    public static void getFileNamesOfFolder(String pathToFolder) {
        File[] listOfFiles = getFilesInFolder(pathToFolder);

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

    public static File[] getFilesInFolder(String path) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        return listOfFiles;
    }

    public static void main(String[] args) {
    /*    try { //  
            System.out.println(args[0]);
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type path to your file");
            System.exit(0);
        }
        printFile("test.txt");

     */
        getFileNamesOfFolder(args[0]);
     //   System.out.println(getLine());
    }

    public static String getLine(String path, int index) {
        String[] output = readFile(path);
        return output[index];
    }

    public static String[] readFile(String path) {
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

    public static void printFile(String path) {
        try {
            String[] readFileOutPut = readFile(path);
            for (int i = 0; i < readFileOutPut.length;i++) System.out.println(readFileOutPut[i]);
        } catch (Exception e) {
            System.err.println("{JFiler}(printFile): Some error was occurred:\n");
            e.printStackTrace();
        }
    }

    public static int countFile(String path) {
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

}
