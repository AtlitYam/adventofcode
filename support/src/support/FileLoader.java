package support;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FileLoader {
    public static String loadFileAsString(String pathname) {
        StringBuilder output = new StringBuilder();
        try {
            File file = new File(pathname);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                output.append(fileReader.nextLine()).append("\n");
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return output.toString();
    }

    public List<String> loadFileAsList(String filePath) {
        List<String> output = new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                output.add(fileReader.nextLine());
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return output;
    }
}
