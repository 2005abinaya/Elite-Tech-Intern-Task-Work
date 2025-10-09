package Task1;
import java.io.*;
import java.util.*;
public class FileManager {
	    // METHOD 1: READ FILE (STATIC)
	    public static void readFile(String filename) {
	        try {
	            File file = new File(filename);
	            Scanner reader = new Scanner(file);
	            System.out.println("=== READING FILE ===");
	            while (reader.hasNextLine()) {
	                System.out.println(reader.nextLine());
	            }
	            reader.close();
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	    
	    // METHOD 2: WRITE FILE (STATIC)  
	    public static void writeFile(String filename, String content) {
	        try {
	            FileWriter writer = new FileWriter(filename);
	            writer.write(content);
	            writer.close();
	            System.out.println("File written successfully!");
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	    
	    // METHOD 3: MODIFY FILE (STATIC)
	    public static void modifyFile(String filename, String newContent) {
	        try {
	            // Read old content
	            File file = new File(filename);
	            StringBuilder oldContent = new StringBuilder();
	            
	            if (file.exists()) {
	                Scanner reader = new Scanner(file);
	                while (reader.hasNextLine()) {
	                    oldContent.append(reader.nextLine()).append("\n");
	                }
	                reader.close();
	            }
	            
	            // Add new content
	            String modifiedContent = oldContent.toString() + newContent;
	            
	            // Write back
	            FileWriter writer = new FileWriter(filename);
	            writer.write(modifiedContent);
	            writer.close();
	            System.out.println("File modified successfully!");
	            
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	    
	    // MAIN METHOD
	    public static void main(String[] args) {
	        System.out.println("Starting File Manager...");
	        
	        
	        writeFile("sample.txt", "First line\nSecond line");
	        readFile("sample.txt");
	        modifyFile("sample.txt", "\nThird line added!");
	        readFile("sample.txt");
	    }
	}
