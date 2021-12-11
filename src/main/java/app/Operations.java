package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Operations {

    public List<String> op_types = new ArrayList<>(
            Arrays.asList(new String[] { "resta", "multiplic", "division", "suma" }));

    public double determina_op(String opt, double n_1, double n_2) {
        switch (opt) {
            case "resta":
                return this.resta(n_1, n_2);
            case "multiplic":
                return this.multiplic(n_1, n_2);
            case "division":
                return this.division(n_1, n_2);
            default:
                return this.suma(n_1, n_2);
        }
    }

    /**
     * Suma
     * 
     * @param num_a
     * @param num_b
     * @return
     */

    public double suma(double num_a, double num_b) {
        return num_a + num_b;
    }

    /**
     * Resta
     * 
     * @param num_a
     * @param num_b
     * @return
     */

    public double resta(double num_a, double num_b) {
        return num_a - num_b;
    }

    /**
     * Multiplicación
     * 
     * @param num_a
     * @param num_b
     * @return
     */

    public double multiplic(double num_a, double num_b) {
        return num_a * num_b;
    }

    /**
     * División
     * 
     * @param num_a
     * @param num_b
     * @return
     */

    public double division(double num_a, double num_b) {
        return num_a / num_b;
    }

}
