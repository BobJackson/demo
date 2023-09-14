package com.example.demo;

import java.util.List;

interface OptionsParser<T> {
    T parse(List<String> arguments, Option option);
}
