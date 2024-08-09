import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class DirectoryComparator {

    public static void main(String[] args) {
        String dirPath1 = "D:\\FileComparision\\file2"; // Replace with the path to your first directory
        String dirPath2 = "D:\\FileComparision"; // Replace with the path to your second directory
        try {
            compareDirectories(dirPath1, dirPath2);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static void compareDirectories(String dirPath1, String dirPath2) throws IOException {
        File dir1 = new File(dirPath1);
        File dir2 = new File(dirPath2);

        // Map to hold files from the first directory
        Map<String, File> filesInDir1 = new HashMap<>();
        Stream.of(dir1.listFiles())
             .filter(File::isFile)
             .forEach(file -> filesInDir1.put(file.getName(), file));

        // Compare files in the second directory
        Stream.of(dir2.listFiles())
             .filter(File::isFile)
             .forEach(file -> {
                 String fileName = file.getName();
                 File correspondingFile = filesInDir1.get(fileName);
                 if (correspondingFile != null) {
                     System.err.println("Comparing files: " + fileName);
                     try {
                         boolean areFilesEqual = compareFiles(correspondingFile, file);
                         if (areFilesEqual) {
                             System.out.println(" - The files are identical.");
                         } else {
                             System.out.println(" - The files differ.");
                         }
                     } catch (IOException e) {
                         System.err.println("Error comparing files: " + e.getMessage());
                     }
                 } else {
                     System.out.println("File " + fileName + " exists only in " + dirPath2);
                 }
             });

        // Check for files that exist only in the first directory
        filesInDir1.keySet().stream()
                    .filter(fileName -> !new File(dirPath2, fileName).exists())
                    .forEach(fileName -> System.out.println("File " + fileName + " exists only in " + dirPath1));
    }

    public static boolean compareFiles(File file1, File file2) throws IOException {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
            String line1;
            String line2;
            int lineNumber = 1;
            boolean areEqual = true;
            while ((line1 = reader1.readLine()) != null) {
                line1 = line1.trim(); // Trim whitespace
                // Skip empty lines and import statements
                if (line1.isEmpty() || line1.startsWith("import")) {
                    lineNumber++;
                    continue;
                }

                line2 = reader2.readLine();
                if (line2 == null) {
                    areEqual = false;
                    System.out.println("Difference at line " + lineNumber + ":");
                    System.out.println("File 1: " + line1);
                    System.out.println("File 2: No corresponding line");
                    break;
                }

                //line2 = line2.trim(); // Trim whitespace
                // Skip empty lines and import statements
                if (line2.isEmpty() || line2.startsWith("import")) {
                    lineNumber++;
                    continue;
                }

                if (!line1.equals(line2)) {
                    areEqual = false;
                    System.out.println("Difference at line " + lineNumber + ":");
                    System.out.println("File 1: " + line1);
                    System.out.println("File 2: " + line2);
                }
                lineNumber++;
            }

            // Check if the second file has remaining non-empty lines
            while ((line2 = reader2.readLine()) != null) {
                line2 = line2.trim(); // Trim whitespace
                if (!line2.isEmpty() && !line2.startsWith("import")) {
                    areEqual = false;
                    System.out.println("Difference at line " + lineNumber + ":");
                    System.out.println("File 1: No corresponding line");
                    System.out.println("File 2: " + line2);
                }
                lineNumber++;
            }

            return areEqual;
        }
    }
}