package framework.model.pojo;

import org.codehaus.jackson.annotate.JsonProperty;

public class MiniUser {
    @JsonProperty("type")
    private String type;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
