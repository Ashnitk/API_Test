import org.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.parseBoolean;

public class TestAPI {
    @Test
    @DisplayName("Test to verify getting the API name response is correct")
    public void testName() throws Exception {
        GetAPIResponse GetAPIResponse = new GetAPIResponse();
        String expectedValue = "Carbon credits";
        String actualValue = GetAPIResponse.getJSONObject().get("Name").toString();
        Assertions.assertEquals(expectedValue,actualValue);
    }

    @Test
    @DisplayName("Test to verify CanRelist from API is set to true")
    public void testCanRelistValue() throws Exception {
        GetAPIResponse GetAPIResponse = new GetAPIResponse();
        boolean expectedValue = true;
        boolean actualValue = parseBoolean(GetAPIResponse.getJSONObject().get("CanRelist").toString());
        Assertions.assertEquals(expectedValue,actualValue);
    }

    @Test
    @DisplayName("Test to verify Promotions Gallery Exists and Description")
    public void testPromotionsElements() throws Exception {
        GetAPIResponse GetAPIResponse = new GetAPIResponse();
        JSONArray promotionsArray = GetAPIResponse.getJSONObject().getJSONArray("Promotions");
        String expectedValue = "2x larger image";
        String actualValue = null;
        boolean galleryPromotionsExists = false;
        //iterating over array to check Gallery exists then store its Description
        for(int i=0; i < promotionsArray.length(); i++) {
            if(promotionsArray.getJSONObject(i).get("Name").toString().equals("Gallery")) {
                galleryPromotionsExists = true;
                actualValue = promotionsArray.getJSONObject(i).get("Description").toString();
            }
        }
        Assertions.assertEquals(true,galleryPromotionsExists); // Tests to check if Gallery exists in JSON
        Assertions.assertEquals(expectedValue,actualValue);
    }
}