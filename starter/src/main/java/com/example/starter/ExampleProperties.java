import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("example")
public class ExampleProperties {
    private String exampleProperty;

    public String getExampleProperty() {
        return exampleProperty;
    }

    public void setExampleProperty(String exampleProperty) {
        this.exampleProperty = exampleProperty;
    }
}
