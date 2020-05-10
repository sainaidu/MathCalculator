package cordova.plugin.mathcalculator;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class MathCalculator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }else if(action.equals("add")){
            this.add(args, callbackContext);
            return true;
        }else if(action.equals("subtract")){
            this.subtract(args, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        System.out.println("String message : " + message);
        if (message != null && message.length() > 0) {
            callbackContext.success("Hello " + message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void add(JSONArray args, CallbackContext callbackContext) {
        System.out.println("JSONArray args : " + args.toString());
        if (args != null) {
            try{
                int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));
                callbackContext.success(""+ (p1+p2));
            }catch(Exception exception){
                callbackContext.error("Expected arguments didn't passed accurately");
            }
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void subtract(JSONArray args, CallbackContext callbackContext) {
        System.out.println("JSONArray args : " + args.toString());
        if (args != null) {
            try{
                int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));
                callbackContext.success(""+ (p1-p2));
            }catch(Exception exception){
                callbackContext.error("Expected arguments didn't passed accurately");
            }
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
