package InternshipTask;
import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileHandler {

	    // Write new file (overwrites if exists)
	    public static void writeToFile(String path, String content) throws IOException {
	        Files.write(Paths.get(path), content.getBytes(StandardCharsets.UTF_8));
	        System.out.println("Wrote to file: " + path);
	    }

	    // Append text to file (creates if not exists)
	    public static void appendToFile(String path, String content) throws IOException {
	        Files.write(Paths.get(path), content.getBytes(StandardCharsets.UTF_8),
	                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
	        System.out.println("Appended to file: " + path);
	    }

	    // Read and print file contents
	    public static void readFile(String path) throws IOException {
	        System.out.println("Reading file: " + path);
	        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
	        for (String line : lines) {
	            System.out.println(line);
	        }
	    }

	    // Replace target with replacement in the file
	    public static void replaceInFile(String path, String target, String replacement) throws IOException {
	        Path p = Paths.get(path);
	        String content = new String(Files.readAllBytes(p), StandardCharsets.UTF_8);
	        content = content.replace(target, replacement);
	        Files.write(p, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);
	        System.out.println("Replaced \"" + target + "\" with \"" + replacement + "\" in " + path);
	    }

	    // Demo main to show usage
	    public static void main(String[] args) {
	        String filename = "sample.txt"; // will be created in project working dir

	        try {
	            // 1) Write initial content
	            writeToFile(filename, "Hello Abi!\nThis is the initial file content.\n");

	            // 2) Read file
	            readFile(filename);

	            // 3) Append more text
	            appendToFile(filename, "Appending a new line.\nAnother appended line.\n");

	            // 4) Read after append
	            System.out.println("\nAfter appending:");
	            readFile(filename);

	            // 5) Replace text (modify)
	            replaceInFile(filename, "initial", "UPDATED");

	            // 6) Read after modification
	            System.out.println("\nAfter modification:");
	            readFile(filename);

	        } catch (IOException e) {
	            System.err.println("File operation error: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
}
