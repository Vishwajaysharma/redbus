package redbus.seleniumprop;



import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.File;

public class WriteProperties {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.setProperty("134", "gfyg");

        // Correct file path
        String filepath = System.getProperty("user.dir") + "\\redbus\\test\\resourse\\data.properties";

        // Ensure directory exists
        File file = new File(filepath);
        file.getParentFile().mkdirs();  // Create parent directories if needed

        // Write properties to the file
        FileOutputStream fileOut = new FileOutputStream(filepath);
        props.store(fileOut, "Simple properties file");
        fileOut.close();  // Close the file

        System.out.println("Properties file created successfully at: " + filepath);
    }
}
