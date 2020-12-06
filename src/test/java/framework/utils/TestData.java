package framework.utils;

import framework.model.Persona;

import static java.lang.String.format;

public class TestData {

    private static final String LOGIN_URI = "login.uri";
    private static final String API_URI = "api.uri";
    public static final String AUTH_TOKEN = "api.auth.token";

    private static final String LOGIN_TEMPLATE = "persona.%s.login";
    private static final String PASSWORD_TEMPLATE = "persona.%s.password";
    private static final String ACCOUNT_ID_TEMPLATE = "persona.%s.id";

    private static final String CUSTOM_TIMEOUT = "custom.timeout";

    //Paths
    public static String getLoginUri() {
        return get(LOGIN_URI);
    }

    public static String getBaseApiUri() {
        return get(API_URI);
    }

    public static String getAuthorizationToken() {
        return "Bearer ".concat(get(AUTH_TOKEN));
    }

    //Personae
    public static Persona getPersonaByName(String personaName) {
        personaName = personaName.toLowerCase();
        if (getPersonaLogin(personaName).isEmpty()) {
            throw new RuntimeException(
                    format("Persona with name '%s' does not exist in testdata.properties", personaName));
        }
        return new Persona(
                personaName,
                getPersonaAccountId(personaName),
                getPersonaLogin(personaName),
                getPersonaPassword(personaName)
        );
    }

    private static String getPersonaAccountId(final String personaName) {
        return get(format(ACCOUNT_ID_TEMPLATE, personaName));
    }

    private static String getPersonaLogin(final String personaName) {
        return get(format(LOGIN_TEMPLATE, personaName));
    }

    private static String getPersonaPassword(final String personaName) {
        return get(format(PASSWORD_TEMPLATE, personaName));
    }

    public static int getCustomTimeout() {
        return Integer.parseInt(get(CUSTOM_TIMEOUT));
    }

    // --- Reusable ----
    private static String get(final String varKey) {
        return Variables.getVariable(varKey);
    }

}
