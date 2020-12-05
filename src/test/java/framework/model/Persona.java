package framework.model;

import com.google.common.base.MoreObjects;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class Persona {

  private String id;
  private String login;
  private String password;

  public Persona(String id, String login, String password) {
    this.id = id;
    this.login = login;
    this.password = password;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public String getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    Persona that = (Persona) o;
    return new EqualsBuilder()
        .append(id, that.id)
        .append(login, that.login)
        .append(password, that.password)
        .isEquals();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("login", login)
        .add("password", password)
        .toString();
  }

}
