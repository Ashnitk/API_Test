import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.JSONObject;

public class GetAPIResponse {

    /**
     * @param urlString
     * @return JSON as a string from API call
     * @throws Exception
     */
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);
            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public JSONObject getJSONObject() throws Exception{
        String API_URL = "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false";
        JSONObject json = new JSONObject(readUrl(API_URL)); //Creating a JSON object from the API call
        return json;
    }
}