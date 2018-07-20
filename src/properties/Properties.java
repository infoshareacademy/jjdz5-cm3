package properties;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Properties {

    public static Path userDelegationPath;
    public static String userDelegationCountry;
    public final static String fileName = "delegation.txt";
    private final Path propertiesPath = Paths.get(System.getProperty("user.dir"), "src", "properties","properties.json");

    private final String defaultCountry = "Poland";
    private final Path defaultDelegationPath = Paths.get(System.getProperty("user.dir"),"src","delegations",fileName);



    public Path getPropertiesPath() {
        return propertiesPath;
    }

    public String getDefaultCountry() {
        return defaultCountry;
    }

    public Path getDefaultDelegationPath() {
        return defaultDelegationPath;
    }


}
