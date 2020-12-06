package framework.model.pojo;

import org.codehaus.jackson.annotate.JsonProperty;

public class CurrentUserConnection {

    @JsonProperty("type")
    private String type;

    @JsonProperty("user")
    private MiniUser user;

    @JsonProperty("role")
    private String role;

    @JsonProperty("id")
    private String id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MiniUser getUser() {
        return user;
    }

    public void setUser(MiniUser user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}