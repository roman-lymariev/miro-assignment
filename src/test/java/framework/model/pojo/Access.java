package framework.model.pojo;

public enum Access {
    PRIVATE("private"),
    VIEW("view"),
    COMMENT("comment");

    private String accessLevel;

    Access(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }
}
