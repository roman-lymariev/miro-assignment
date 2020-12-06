package framework.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SharingPolicy {

    @SerializedName("access")
    @Expose
    private Access access;
    @SerializedName("teamAccess")
    @Expose
    private TeamAccess teamAccess;

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
