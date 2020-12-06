package framework.model.pojo;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Board {
    @JsonProperty("type")
    private String type;

    @JsonProperty("viewLink")
    private String viewLink;

    @JsonProperty("description")
    private String description;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("picture")
    private Object picture;

    @JsonProperty("sharingPolicy")
    private SharingPolicy sharingPolicy;

    @JsonProperty("team")
    private Team team;

    @JsonProperty("currentUserConnection")
    private CurrentUserConnection currentUserConnection;

    @JsonProperty("createdBy")
    private MiniUser createdBy;

    @JsonProperty("modifiedAt")
    private String modifiedAt;

    @JsonProperty("modifiedBy")
    private MiniUser modifiedBy;

    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;

    @JsonProperty("owner")
    private MiniUser owner;

    public String getType() {
        return type;
    }

    public String getViewLink() {
        return viewLink;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public Object getPicture() {
        return picture;
    }

    public SharingPolicy getSharingPolicy() {
        return sharingPolicy;
    }

    public Team getTeam() {
        return team;
    }

    public CurrentUserConnection getCurrentUserConnection() {
        return currentUserConnection;
    }

    public MiniUser getCreatedBy() {
        return createdBy;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public MiniUser getModifiedBy() {
        return modifiedBy;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public MiniUser getOwner() {
        return owner;
    }
}
