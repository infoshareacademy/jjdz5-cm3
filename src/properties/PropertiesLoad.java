package properties;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PropertiesLoad {

    private Properties properties = new Properties();
    private PropertiesReadJson propertiesReadJson = new PropertiesReadJson();

    public void loadProperties() {

        if (Files.notExists(properties.getDefaultDelegationPath())){
            try {
                Files.createDirectories(properties.getDefaultDataPath());
                Files.createFile(properties.getDefaultDelegationPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if (Files.notExists(properties.getPropertiesPath())) {
            Properties.userDelegationPath = properties.getDefaultDelegationPath();
            Properties.userDelegationCountry = properties.getDefaultCountry();

        } else {
            String jsonString = propertiesReadJson.readJson();
            try {
                JSONObject jsonObject = new JSONObject(jsonString);
                Properties.userDelegationCountry = jsonObject.getString("userDelegationCountry");
                Properties.userDelegationPath = Paths.get(jsonObject.getString("userDelegationPath"));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
