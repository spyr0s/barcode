public class BarCode {
    public final static String BARCODE = "bacode";
    public final static String ONOMA = "onoma";
    public final static String POSTO = "posto";
    public final static String ARXI_TELOS = "arxi_telos";

    String code_A;
    String code_B;
    String code_C;
    String code_D;
    boolean completed = false;


    @Override
    public String toString() {
        return this.code_A + ";" + this.code_B +";" + this.code_C +";"+this.code_D; 
    }

    public String add(String barcode) {
        String type;
        if (barcode.length() == 19) {
            this.code_A = barcode;
            type = BARCODE;
        } else if (barcode.length() == 3) {
            this.code_B = barcode;
            type = ONOMA;
        } else if (barcode.length() == 2) {
            this.code_C = barcode;
            type = POSTO;
        } else if (barcode.length() == 1) {
            this.code_D = barcode;
            type = ARXI_TELOS;
        } else {
            type = "";
        }
        if (this.code_A != null && this.code_B != null && this.code_C != null && this.code_D != null ) {
            this.completed = true;
        }
        return type;
    }

}
