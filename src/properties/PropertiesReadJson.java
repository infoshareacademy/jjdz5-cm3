package properties;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.util.List;

public class PropertiesReadJson {

    private Properties properties = new Properties();


    public String readJson() {

        try {
            List<String> linesJson = Files.readAllLines(properties.getPropertiesPath());
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : linesJson) {
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
