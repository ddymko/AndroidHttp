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

    static URL url;

    public static String HttpGet(){
        return null;
    }

    public static String HttpPost(){
        return null;
    }

    public static String HttpPut(){
        return null;
    }

    public static String HttpDelete(){
        return null;
    }

    private static String httpSend(){
    return null;
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
    private static String streamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    /**
     * This will take provided params and execute the api call
     *
     * @param url  end point of api
     * @param crud operation to execute
     * @return String
     */
    public static String execute(URL url, String crud) {
        String message = null;
        try {
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
            httpCon.setDoOutput(true);
            httpCon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpCon.setRequestMethod(crud);
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
