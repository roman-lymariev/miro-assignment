package framework.model.pojo;

public enum TeamAccess {
    PRIVATE("private"),
    VIEW("view"),
    COMMENT("comment"),
    EDIT("edit");

    private String accessLevel;

    TeamAccess(String accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getAccessLevel() {
        return accessLevel;
    }
}
