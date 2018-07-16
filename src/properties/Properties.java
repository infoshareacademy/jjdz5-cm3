package properties;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Properties {


    private final Path startPath = Paths.get(System.getProperty("user.dir"), "src", "Properties","properties.txt");
    private Path userPath;
    private final String defaultCountry = "Poland";
    private String userDefaultCountry;



}
