import java.util.ArrayList;
import java.util.List;

public class BarCode {
    public final static String BARCODE = "barcode";
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

    public void add(String barcode) {
        if (barcode.length() == 19) {
            this.code_A = barcode;
        } else if (barcode.length() == 3) {
            this.code_B = barcode;
        } else if (barcode.length() == 2) {
            this.code_C = barcode;
        } else if (barcode.length() == 1) {
            this.code_D = barcode;
        } 
        if (this.code_A != null && this.code_B != null && this.code_C != null && this.code_D != null ) {
            this.completed = true;
        }
    }

    String getRemaining() {
        List<String> remaining = new ArrayList<String>();

        if (code_A == null) {
            remaining.add(BARCODE);
        }
        if (code_B == null) {
            remaining.add(ONOMA);
        }
        if (code_C == null) {
            remaining.add(POSTO);
        }
        if (code_D == null) {
            remaining.add(ARXI_TELOS);
        }

        return String.join(", ", remaining);
    }

}
