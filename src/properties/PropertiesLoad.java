package properties;

import java.nio.file.Files;

public class PropertiesLoad {

    Properties properties = new Properties();

    public void loadProperties () {
        if (Files.notExists(properties.getPropertiesPath())){
            Properties.userDelegationPath = properties.getDefaultDelegationPath();
            Properties.userDelegationCountry = properties.getDefaultCountry();

        }

    }
}
