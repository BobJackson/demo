package com.example.demo;

import java.util.List;

class IntOptionParser implements OptionsParser {
    @Override
    public Object parse(List<String> arguments, Option option) {
        int index = arguments.indexOf("-" + option.value());
        String value = arguments.get(index + 1);
        return parseValue(value);
    }

    protected  Object parseValue(String value) {
        return Integer.parseInt(value);
    }

}
