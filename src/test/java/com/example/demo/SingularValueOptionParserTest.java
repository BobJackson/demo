package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.function.Function;

import static com.example.demo.BooleanParserTest.option;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class SingularValueOptionParserTest {

    @Test
        // sad path
    void should_not_accept_extra_argument_for_singular_valued_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> {
            new SingularValueOptionParser<>(0, Integer::parseInt).parse(asList("-p", "8080", "8081"), option("p"));
        });

        assertEquals("p", e.getOption());
    }

    @ParameterizedTest // sad path
    @ValueSource(strings = {"-p -l", "-p"})
    void should_not_accept_insufficient_argument_for_singular_valued_option(String arguments) {
        InsufficientArgumentsException e = assertThrows(InsufficientArgumentsException.class, () -> {
            new SingularValueOptionParser<>(0, Integer::parseInt).parse(asList(arguments.split(" ")), option("p"));
        });

        assertEquals("p", e.getOption());
    }

    @Test
        // default value
    void should_set_default_value_for_singular_valued_option() {
        Function<String, Object> whatever = (it) -> null;
        Object defaultValue = new Object();
        assertEquals(defaultValue, new SingularValueOptionParser<>(defaultValue, whatever).parse(List.of(), option("p")));
    }

    @Test
        // happy path
    void should_parse_value_if_flag_present() {
        Object parsed = new Object();
        Function<String, Object> parse = (it) -> parsed;
        Object whatever = new Object();
        assertSame(parsed, new SingularValueOptionParser<>(whatever, parse).parse(List.of("-p", "8080"), option("p")));
    }
}