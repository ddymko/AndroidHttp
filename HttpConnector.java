import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;


/**
 * Created by Dymko on 11/1/15.
 */
public class HttpConnector {

    /**
     * This just adds a layer between execution
     * @param url Endpoint for api
     * @param crud Crud operation that needs to be executed
     * @return String
     */
    public static String HttpGet(URL url, String crud){

        return execute(url, crud, null);
    }
    /**
     * This just adds a layer between execution
     * @param url Endpoint for api
     * @param crud Crud operation that needs to be executedyeah
     * @param query the http body request
     * @return String
     */
    public static String HttpPost(URL url, String crud, String query){

        return execute(url, crud, query);
    }
    /**
     * This just adds a layer between execution
     * @param url Endpoint for api
     * @param crud Crud operation that needs to be executed
     * @param query the http body request
     * @return String
     */
    public static String HttpPut(URL url, String crud, String query){
        return execute(url, crud, query);
    }

    /**
     * This just adds a layer between execution
     * @param url Endpoint for api
     * @param crud Crud operation that needs to be executed
     * @return String
     */
    public static String HttpDelete(URL url, String crud){
        return execute(url, crud, null);
    }

    private static String urlBuilder(){
        return null;
    }

    /**
     * This will convert the provided input stream into a string
     * @param is stream provided from prior http call
     * @return string
     * @throws IOException
     */
    private static String streamToString (InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    /**
     * This will execute the actual http call
     * @param url Endpoint for the api
     * @param crud Crud operation that needs to be executed
     * @param query the http body request
     * @return String
     */
    public static String execute (URL url,String crud, String query) {

        String message = null;
        try {
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpCon.setRequestMethod(crud);

            if (crud.equals("POST") || crud.equals("PUT")) {
                OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
                out.write(query);
                out.close();
            }

            httpCon.getResponseCode();
            message = streamToString(httpCon.getInputStream());
        } catch (IOException e) {
            Log.e("url-error", String.valueOf(e.getMessage()));
        }
       return message;
    }

    private static String returnData(){
        return null;
    }
}
