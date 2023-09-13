package com.example.demo;

import java.util.List;
import java.util.function.Function;

class SingularValueOptionParser<T> implements OptionsParser {

    Function<String, T> valueParser;

    public SingularValueOptionParser(Function<String, T> valueParser) {
        this.valueParser = valueParser;
    }

    @Override
    public T parse(List<String> arguments, Option option) {
        int index = arguments.indexOf("-" + option.value());
        String value = arguments.get(index + 1);
        return valueParser.apply(value);
    }

}
