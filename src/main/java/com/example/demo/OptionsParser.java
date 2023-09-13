package com.example.demo;

import java.util.List;

interface OptionsParser {
    Object parse(List<String> arguments, Option option);
}
