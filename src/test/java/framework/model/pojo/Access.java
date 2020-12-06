package framework.model.pojo;

import org.codehaus.jackson.annotate.JsonCreator;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Access {
    PRIVATE("private"),
    VIEW("view"),
    COMMENT("comment");

    private static Map<String, Access> FORMAT_MAP = Stream
            .of(Access.values())
            .collect(Collectors.toMap(s -> s.formatted, Function.identity()));

    private final String formatted;

    Access(String formatted) {
        this.formatted = formatted;
    }

    @JsonCreator
    public static Access fromString(String string) {
        return Optional.ofNullable(FORMAT_MAP.get(string)).orElseGet(() -> Access.valueOf(string));
    }
}
