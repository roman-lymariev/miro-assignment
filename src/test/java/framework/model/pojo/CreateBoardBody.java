package framework.model.pojo;

import org.codehaus.jackson.annotate.JsonProperty;

public class CreateBoardBody {
    @JsonProperty("name")
    private String name;

    @JsonProperty("sharingPolicy")
    private SharingPolicy sharingPolicy;

    public String getName() {
        return name;
    }

    public CreateBoardBody setName(String name) {
        this.name = name;
        return this;
    }

    public SharingPolicy getSharingPolicy() {
        return sharingPolicy;
    }

    public CreateBoardBody setSharingPolicy(SharingPolicy sharingPolicy) {
        this.sharingPolicy = sharingPolicy;
        return this;
    }
}
