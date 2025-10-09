package Task1;

public class modifyFile {
	public static void modifyFile(String filename, String newContent) {
	    try {
	        // 1. Existing content read pannu
	        File file = new File(filename);
	        StringBuilder oldContent = new StringBuilder();
	        
	        if (file.exists()) {
	            Scanner reader = new Scanner(file);
	            while (reader.hasNextLine()) {
	                oldContent.append(reader.nextLine()).append("\n");
	            }
	            reader.close();
	        }
	        
	        // 2. New content add pannu
	        String modifiedContent = oldContent.toString() + newContent + "\n";
	        
	        // 3. Modified content write pannu
	        FileWriter writer = new FileWriter(filename);
	        writer.write(modifiedContent);
	        writer.close();
	        
	        System.out.println("✅ File modified successfully: " + filename);
	        
	    } catch (Exception e) {
	        System.out.println("❌ Error modifying file: " + e.getMessage());
	    }
	}
	

}
