package properties;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

public class PropertiesSaveToJson {

    Properties properties = new Properties();

public void saveJson (){


    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder = stringBuilder
            .append("{")
            .append("\"userDelegationCountry\"")
            .append(": ")
            .append("\"")
            .append(Properties.userDelegationCountry)
            .append("\"")
            .append(", ")
            .append("\"userDelegationPath\"")
            .append(": ")
            .append("\"")
            .append(Properties.userDelegationPath.toString().replace("\\","\\\\"))
            .append("\"")
            .append("}");

    try {
        JSONObject jsonObject = new JSONObject(stringBuilder.toString());
        Files.write(properties.getPropertiesPath(),Collections.singletonList(jsonObject.toString()));
    } catch (IOException e) {
        throw new UnsupportedOperationException();
    }catch (org.json.JSONException e){
        throw new UnsupportedOperationException();
    }
}
}
