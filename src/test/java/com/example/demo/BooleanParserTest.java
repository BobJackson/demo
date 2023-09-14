package com.example.demo;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class BooleanParserTest {

    // sad path:
    //TODO: -bool -l t / -l t f

    @Test
    void should_not_accept_extra_argument_for_boolean_option() {
        TooManyArgumentsException e = assertThrows(TooManyArgumentsException.class, () -> {
            new BooleanParser().parse(asList("-l", "t"), option("l"));
        });

        assertEquals("l", e.getOption());
    }


    // default value
    //TODO: - bool : false
    @Test
    void should_set_default_value_to_false_if_option_not_present() {
        assertFalse(new BooleanParser().parse(List.of(), option("l")));
    }


    static Option option(String value) {
        return new Option() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return Option.class;
            }

            @Override
            public String value() {
                return value;
            }
        };
    }
}