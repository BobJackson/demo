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
        if (values.isEmpty()) throw new InsufficientArgumentsException(option.value());
        if (values.size() > 1) throw new TooManyArgumentsException(option.value());
        String value = values.get(0);
        return valueParser.apply(value);
    }

    private static List<String> getValues(List<String> arguments, int index) {
        return arguments.subList(index + 1, IntStream.range(index + 1, arguments.size())
                .filter(it -> arguments.get(it).startsWith("-"))
                .findFirst().orElse(arguments.size()));
    }

}
