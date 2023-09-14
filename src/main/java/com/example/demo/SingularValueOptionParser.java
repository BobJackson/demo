package com.example.demo;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

class SingularValueOptionParser<T> implements OptionsParser<T> {

    Function<String, T> valueParser;
    T defaultValue;

    public SingularValueOptionParser(T defaultValue, Function<String, T> valueParser) {
        this.valueParser = valueParser;
        this.defaultValue = defaultValue;
    }

    @Override
    public T parse(List<String> arguments, Option option) {
        int index = arguments.indexOf("-" + option.value());
        if (index == -1) return defaultValue;
        List<String> values = getValues(arguments, index);
        if (values.size() < 1) throw new InsufficientArgumentsException(option.value());
        if (values.size() > 1) throw new TooManyArgumentsException(option.value());
        return valueParser.apply(arguments.get(index + 1));
    }

    private static List<String> getValues(List<String> arguments, int index) {
        int followingFlag = IntStream.range(index + 1, arguments.size())
                .filter(it -> arguments.get(it).startsWith("-"))
                .findFirst().orElse(arguments.size());
        return arguments.subList(index + 1, followingFlag);
    }

}
