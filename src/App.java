public class App {
    String  barcode;
    String device_name;
    public static void main(String[] args) throws Exception {
        // Read the barcode and the device name
        InputReader in = new InputReader(args[0].trim(), args[1].trim());
        // If we don't have the final barcode do not send anything
       if (in.finalBarcode != null) {
           // If barcode is complete send it
           System.out.println(in.finalBarcode);
       } else {
            // Send the info to see in what step we are  
            if (in.info != null){
                System.out.println(in.info);
            }
       }
    }
}
