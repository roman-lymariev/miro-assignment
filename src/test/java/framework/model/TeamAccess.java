package framework.model;

import org.codehaus.jackson.annotate.JsonCreator;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TeamAccess {
    PRIVATE("private"),
    VIEW("view"),
    COMMENT("comment"),
    EDIT("edit");

    private final static Map<String, TeamAccess> FORMAT_MAP = Stream
            .of(TeamAccess.values())
            .collect(Collectors.toMap(s -> s.formatted, Function.identity()));

    private final String formatted;

    TeamAccess(final String formatted) {
        this.formatted = formatted;
    }

    @JsonCreator
    public static TeamAccess fromString(final String string) {
        return Optional.ofNullable(FORMAT_MAP.get(string)).orElseGet(() -> TeamAccess.valueOf(string));
    }
}
