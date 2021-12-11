package app;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;

import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

import spark.Request;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class ApplicationMain {
    static Logger logger = Logger.getLogger(ApplicationMain.class);
    public static History_Object hist = new History_Object();
    static Operations ops_obj = new Operations();

    public static void main(String[] args) {
        // ==========================================

        BasicConfigurator.configure();

        get("/hist", (req, res) -> {
            res.type("application/json");
            JSONArray f_resp = new JSONArray(hist.total_history);

            return f_resp;
        });

        post("/calcula", (req, res) -> {
            res.type("application/json");
            JSONObject f_resp = new JSONObject();
            List<String> errors = validate_params(req);

            if (errors.size() > 0) {
                JSONArray err_resp = new JSONArray(errors);
                return err_resp;

            } else {
                start_operation(req);
                f_resp.put("Num A", hist.number_a);
                f_resp.put("Num B", hist.number_b);
                f_resp.put("Tipo", hist.op_type);
                f_resp.put("Usuario", hist.op_user_name);
                f_resp.put("Resultado", hist.op_result);
                save_hist(req);

                return f_resp;
            }
        });

    }

    public static List<String> validate_params(Request req) {

        List<String> errors = new ArrayList<>();
        if (req.queryParams("a") == null || req.queryParams("a").length() == 0) {
            errors.add("Invalid request: num a is missing");
        }
        if (req.queryParams("b") == null || req.queryParams("b").length() == 0) {
            errors.add("Invalid request: num b is missing");
        }

        if (req.queryParams("operacion") == null || req.queryParams("operacion").length() == 0) {
            errors.add("Invalid request: *operacion* is missing");
        } else if (!ops_obj.op_types.contains(req.queryParams("operacion"))) {
            errors.add("Invalid operation: *operacion* must be: suma, resta, multiplic o division");
        }

        if (req.queryParams("user") == null || req.queryParams("user").length() == 0) {
            errors.add("Invalid request: *user* is missing");
        }

        return errors;
    }

    public static void start_operation(Request req) {
        hist.setNumber_a(Double.parseDouble(req.queryParams("a")));
        hist.setNumber_b(Double.parseDouble(req.queryParams("b")));
        hist.setOp_type(req.queryParams("operacion"));
        hist.setOp_User(req.queryParams("user"));
        hist.setOp_result(ops_obj.determina_op(hist.op_type, hist.number_a, hist.number_b));
    }

    public static void save_hist(Request req) {
        JSONObject resp_hist = new JSONObject();
        resp_hist.put("Num A", hist.number_a);
        resp_hist.put("Num B", hist.number_b);
        resp_hist.put("Tipo", hist.op_type);
        resp_hist.put("Usuario", hist.op_user_name);
        resp_hist.put("Resultado", hist.op_result);

        hist.add_total_hist(resp_hist);
    }

}