package com.example.demo;

import java.util.List;

class IntOptionParser implements OptionsParser {
    @Override
    public Object parse(List<String> arguments, Option option) {
        int index = arguments.indexOf("-" + option.value());
        return Integer.parseInt(arguments.get(index + 1));
    }

}
