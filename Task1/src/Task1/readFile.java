package Task1;

public class readFile {
	public static void readFile(String filename) {
    try {
        // 1. File object create pannu
        File file = new File(filename);
        
        // 2. File exist pannutha nu check pannu
        if (!file.exists()) {
            System.out.println("File not found: " + filename);
            return;
        }
        
        // 3. File read pannu
        Scanner reader = new Scanner(file);
        System.out.println("=== READING FILE: " + filename + " ===");
        
        // 4. Line-by-line read pannu
        int lineNumber = 1;
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            System.out.println(lineNumber + ": " + line);
            lineNumber++;
        }
        
        reader.close();
        System.out.println("=== END OF FILE ===\n");
        
    } catch (Exception e) {
        System.out.println("Error reading file: " + e.getMessage());
    }
}
}
