package app;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class History_Object {
    /**
     * HISTORY object props
     */
    String op_user_name;
    double number_a;
    double number_b;
    String op_type;
    double op_result;

    List<JSONObject> total_history = new ArrayList<JSONObject>();

    /**
     * Setter
     * 
     * @param op_user_name
     */

    public void setOp_User(String op_user_name) {
        this.op_user_name = op_user_name;
    }

    /**
     * Setter
     * 
     * @param number_a
     */

    public void setNumber_a(double number_a) {
        this.number_a = number_a;
    }

    /**
     * Setter
     * 
     * @param number_a
     */

    public void setNumber_b(double number_b) {
        this.number_b = number_b;
    }

    /**
     * Setter
     * 
     * @param op_user_name
     */

    public void setOp_type(String op_type) {
        this.op_type = op_type;
    }

    /**
     * Setter
     * 
     * @param op_user_name
     */

    public void setOp_result(double op_result) {
        this.op_result = op_result;
    }

    /**
     * Getter - returns complete hist
     * 
     * @param username
     * @return
     */

    public List<History_Object> get_hist() {
        List<History_Object> hist = new ArrayList<History_Object>();

        return hist;

    }

    /**
     * Getter - returns hist given a user name
     * 
     * @param username
     * @return
     */

    public List<History_Object> get_hist_by_user(String username) {
        List<History_Object> hist = new ArrayList<History_Object>();

        return hist;

    }

    /**
     * Hist Operation Methods
     */

    /**
     * Clears current
     * 
     * @param op_result
     */

    public void clear_current() {
        this.number_a = 0;
        this.number_b = 0;
        this.op_result = 0;
        this.op_type = "";
        this.op_user_name = "";
    }

    /**
     * Adds a new
     * 
     * @param hist_object
     */
    public void add_total_hist(JSONObject hist_object) {
        this.total_history.add(hist_object);
        //this.clear_current();
    }

}
