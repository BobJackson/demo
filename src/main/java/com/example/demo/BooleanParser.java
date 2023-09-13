package com.example.demo;

import java.util.List;

class BooleanParser implements OptionsParser {
    @Override
    public Object parse(List<String> arguments, Option option) {
        return arguments.contains("-" + option.value());
    }
}
