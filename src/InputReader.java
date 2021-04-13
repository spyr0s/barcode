import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class InputReader {
    String barcode;
    String finalBarcode;
    String device_name;    
    String filePath;
    String info;
    File file;
    BarCode barcodeObject;


    public InputReader(String barcode, String device_name) {
        this.barcode = barcode;
        this.device_name = device_name;
        Gson gson = new Gson();

        File jarFile = new File(App.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String filename = this.device_name + ".json";
        String direcotryPath =  jarFile.getParentFile() + "/devices/";
        this.file = new File(direcotryPath, filename);
        this.filePath = this.file.getAbsolutePath();
        File directory = new File(direcotryPath);
        if (! directory.exists()){
            directory.mkdir();
        }

        if (!file.exists()) {
            barcodeObject = new BarCode();
        } else {
            String contents = this.readFile();
            barcodeObject = gson.fromJson(contents, BarCode.class);
        }

        barcodeObject.add(barcode);
        if (barcodeObject.completed) {
            this.finalBarcode = barcodeObject.toString();
            this.deleteFile();
        } else {
            this.info = barcodeObject.getRemaining();
            this.writeToFile(gson.toJson(barcodeObject));
        }
    }

    private boolean writeToFile(String contents){
        try{
            // Append the current part in the saved code 
            FileWriter writer = new FileWriter(this.file);
            writer.write(contents);
            writer.close();
            return true;
        } catch(IOException e) {
            System.err.println(e.getMessage());
            return false;
        }

    }

    private String readFile(){
        String code = "";
        try{
            // read and return the current savedcode
            File file = new File(this.filePath);
            FileReader fr = new FileReader(file);
            int content;
            while ((content = fr.read()) != -1) {
                code +=(char) content;
            }
            fr.close();
            return code;
        } catch(IOException e) {
            System.err.println(e.getMessage());
            return "";
        }

    }

    private boolean deleteFile() {
        // Delete the file
        File myObj = new File(this.filePath); 
        if (myObj.delete()) { 
            return true;
        }
        System.err.println("Could not delete file");
        return false;
    }
    
}