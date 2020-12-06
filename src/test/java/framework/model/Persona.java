package framework.model;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class Persona {
    private String name;
    private String accountId;
    private String login;
    private String password;

    public Persona(String name, String accountId, String login, String password) {
        this.name = name;
        this.accountId = accountId;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        Persona that = (Persona) o;
        return new EqualsBuilder()
                .append(accountId, that.accountId)
                .append(login, that.login)
                .append(password, that.password)
                .isEquals();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", accountId)
                .add("login", login)
                .add("password", password)
                .toString();
    }
}
