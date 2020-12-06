package framework.model.pojo;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SharingPolicy {
    @JsonProperty("access")
    private Access access;

    @JsonProperty("teamAccess")
    private TeamAccess teamAccess;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Access getAccess() {
        return access;
    }

    public SharingPolicy setAccess(Access access) {
        this.access = access;
        return this;
    }

    public TeamAccess getTeamAccess() {
        return teamAccess;
    }

    public SharingPolicy setTeamAccess(TeamAccess teamAccess) {
        this.teamAccess = teamAccess;
        return this;
    }
}
