package framework.utils;

import framework.model.Persona;

public class TestData {

  private static final String LOGIN_URL = "login.url";

  private static final String PERSONA = "persona.";
  private static final String LOGIN = ".login";
  private static final String PASSWORD = ".password";

  private static final String CUSTOM_TIMEOUT = "custom.timeout";

  //application URL
  public static String getLoginUrl() {
    return get(LOGIN_URL);
  }

  //Personae
  public static Persona getPersonaById(String personaId) {
    if (getPersonaLogin(personaId).isEmpty()) {
      throw new RuntimeException(
          String.format("Persona with id '%s' does not exist in testdata.properties or empty", personaId));
    }
    return new Persona(
        personaId,
        getPersonaLogin(personaId),
        getPersonaPassword(personaId)
    );
  }

  public static String getPersonaLogin(String personaId) {
    return get(
        PERSONA
            .concat(personaId.toLowerCase())
            .concat(LOGIN)
    );
  }

  public static String getPersonaPassword(String personaId) {
    return get(
        PERSONA
            .concat(personaId.toLowerCase())
            .concat(PASSWORD)
    );
  }

  public static int getCustomTimeout() {
    return Integer.parseInt(get(CUSTOM_TIMEOUT));
  }

  // --- Reusable ----
  private static String get(String varKey) {
    return Variables.getVariable(varKey);
  }

}
