package models;

import org.codehaus.jackson.map.ObjectMapper;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@XmlRootElement
public class Step {

    public String id;
    public String title;
    public String body;

    public Step() {}

    public static Step fromFile(String id) throws IOException {
        final InputStream stepStream = ClassLoader.getSystemResourceAsStream("steps" + System.getProperty("file.separator") + id + ".json");
        return new ObjectMapper().readValue(stepStream, Step.class);
    }

    public static List<Step> fromAllFiles() throws URISyntaxException, IOException {
        final List<Step> steps = new ArrayList<Step>();
        final ObjectMapper mapper = new ObjectMapper();
        final File stepsDir = new File(ClassLoader.getSystemResource("steps").toURI());

        for (String stepFileStr : stepsDir.list()) {
            final File stepFile = new File(stepsDir + System.getProperty("file.separator") + stepFileStr);
            steps.add(mapper.readValue(stepFile, Step.class));
        }

        return Collections.unmodifiableList(steps);
    }
}
