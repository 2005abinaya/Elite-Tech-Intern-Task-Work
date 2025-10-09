package Task1;

public class writeFile {
	public static void writeFile(String filename, String content) {
	    try {
	        // 1. FileWriter object create pannu
	        FileWriter writer = new FileWriter(filename);
	        
	        // 2. Content write pannu
	        writer.write(content);
	        writer.close();
	        
	        System.out.println("✅ Successfully wrote to: " + filename);
	        
	    } catch (Exception e) {
	        System.out.println("❌ Error writing file: " + e.getMessage());
	    }
	}

}
