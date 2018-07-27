package properties;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Properties {

    public final static String FILE_NAME = "delegation.txt";
    public static Path userDelegationPath;
    public static String userDelegationCountry;

    private final Path propertiesPath = Paths.get(System.getProperty("user.dir"), "src", "properties", "properties.json");
    private final String defaultCountry = "Poland";
    private final Path defaultDelegationPath = Paths.get(System.getProperty("user.dir"), "paths", "data", FILE_NAME);
    private final Path defaultDataPath = Paths.get(System.getProperty("user.dir"), "paths", "data");


    public Path getPropertiesPath() {
        return propertiesPath;
    }

    public String getDefaultCountry() {
        return defaultCountry;
    }

    public Path getDefaultDelegationPath() {
        return defaultDelegationPath;
    }

    public Path getDefaultDataPath() {
        return defaultDataPath;
    }

    @Override
    public String toString() {
        return "{ \"userDelegationCountry\": \"" + Properties.userDelegationCountry + "\",\"userDelegationPath\": \""
                + Properties.userDelegationPath.toString().replace("\\", "\\\\") + "\"}";
    }
}
