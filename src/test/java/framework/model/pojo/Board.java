package framework.model.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Board {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sharingPolicy")
    @Expose
    private SharingPolicy sharingPolicy;

    public String getName() {
        return name;
    }

    public Board setName(String name) {
        this.name = name;
        return this;
    }

    public SharingPolicy getSharingPolicy() {
        return sharingPolicy;
    }

    public Board setSharingPolicy(SharingPolicy sharingPolicy) {
        this.sharingPolicy = sharingPolicy;
        return this;
    }
}
