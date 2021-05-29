# JFiler


## Usage:

**First of all you need to create an instance of JFiler class**
```java
  JFiler filer = new JFiler();
```
Next step is pretty simple, just use the methods of instance

## Methods

Here is a description for all methods:

#### getNumbersOfRowsInFolder(String path):

This method allows you to get the number of rows in a whole folder
```java
int getNumbersOfRowsInFolder(String path) {
    return getFilesInFolder(path).length;
}
```

#### getFilesInfoInFolder(String pathToFolder):
A method that determines the type of an entity (file or folder) and outputs its name along with the type

```java
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
```

#### getFilesInFolder(String path):
Outputs a list of files from the specified directory
```java
File[] getFilesInFolder(String path) {
    return new File(path).listFiles();
}
```

#### readFile(String path):
Reads a file and returns it in String[] format
Can accept String or File
```java
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
```

#### printFile(String path):
Outputs the contents of a file to the console
```java
void printFile(String path) {
        try {
            String[] readFileOutPut = readFile(path);
            for (int i = 0; i < readFileOutPut.length;i++) System.out.println(readFileOutPut[i]);
        } catch (Exception e) {
            e.printStackTrace();
        }
}
```

#### countFile(String path):
Reads the number of lines in the file and returns it
Can accept String or File
```java
int countFile(String path) {
    return readFile(path).length;
}
```
