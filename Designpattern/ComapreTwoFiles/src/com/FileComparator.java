package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileComparator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path for the first directory: ");
        String dir1Path = scanner.nextLine();

        System.out.print("Enter the path for the second directory: ");
        String dir2Path = scanner.nextLine();

        // Map to store processed file contents
        Map<String, String> dir1Files = new HashMap<>();
        Map<String, String> dir2Files = new HashMap<>();

        // Process files in the first directory
        processDirectory(dir1Path, dir1Files);
        // Process files in the second directory
        processDirectory(dir2Path, dir2Files);

        // Compare files with the same name
        compareFiles(dir1Files, dir2Files);
    }

    private static void processDirectory(String dirPath, Map<String, String> fileContents) {
        File directory = new File(dirPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Invalid directory: " + dirPath);
            return;
        }

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                try {
                    String content = processFile(file);
                    fileContents.put(file.getName(), content);
                } catch (IOException e) {
                    System.err.println("Error processing file: " + file.getName() + " - " + e.getMessage());
                }
            }
        }
    }

    private static String processFile(File file) throws IOException {
        StringBuilder combinedLine = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Remove leading and trailing whitespace

                // Skip lines starting with "package" or "import"
                if (line.isEmpty() || line.startsWith("package") || line.startsWith("import")) {
                    continue;
                }

                // Append non-package/import lines to the combined line
                combinedLine.append(line).append(" ");
            }
        }
        return combinedLine.toString().trim(); // Return the combined line as a single string
    }

    private static void compareFiles(Map<String, String> dir1Files, Map<String, String> dir2Files) {
        for (String fileName : dir1Files.keySet()) {
            if (dir2Files.containsKey(fileName)) {
                String content1 = dir1Files.get(fileName);
                String content2 = dir2Files.get(fileName);

                if (content1.equals(content2)) {
                    System.out.println("File " + fileName + " is the same in both directories.");
                } else {
                    System.out.println("File " + fileName + " is different in both directories.");
                }
            } else {
                System.out.println("File " + fileName + " is only in the first directory.");
            }
        }

        // Check for files that are only in the second directory
        for (String fileName : dir2Files.keySet()) {
            if (!dir1Files.containsKey(fileName)) {
                System.out.println("File " + fileName + " is only in the second directory.");
            }
        }
    }
}