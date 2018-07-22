package properties;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;

public class PropertiesSaveToJson {

    Properties properties = new Properties();

    public void saveJson() {

        try {
            JSONObject jsonObject = new JSONObject(properties.toString());
            Files.write(properties.getPropertiesPath(), Collections.singletonList(jsonObject.toString()));
        } catch (IOException e) {
            throw new UnsupportedOperationException();
        } catch (org.json.JSONException e) {
            throw new UnsupportedOperationException();
        }
    }
}
