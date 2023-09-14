package com.example.demo;

import java.util.List;

import static com.example.demo.SingularValueOptionParser.values;

class BooleanParser implements OptionsParser<Boolean> {

    @Override
    public Boolean parse(List<String> arguments, Option option) {
        return values(arguments, option).isPresent();
    }
}
