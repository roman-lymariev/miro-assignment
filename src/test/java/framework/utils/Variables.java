package framework.utils;

import java.util.Iterator;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import net.serenitybdd.core.Serenity;

public class Variables {

    private static String TESTDATA_PROPS = "testdata.properties";

    /**
     * Clears the variables and loads the global and environment variables.
     */
    public static void reset() {
        load(TESTDATA_PROPS);
    }

    private static void load(final String filename) {
        Configuration config;

        try {
            config = new PropertiesConfiguration(filename);
        } catch (final ConfigurationException e) {
            throw new RuntimeException("Error loading configuration: " + filename, e);
        }

        final Iterator<String> keyIterator = config.getKeys();
        while (keyIterator.hasNext()) {
            final String key = keyIterator.next();
            final String value = config.getString(key);
            setVariable(key, value);
        }
    }

    static String getVariable(final String key) {
        final String value = Serenity.sessionVariableCalled(key);
        return value == null ? "" : value;
    }

    static void setVariable(final String key, final String value) {
        Serenity.setSessionVariable(key).to(value);
    }
}
