package com.example.demo;

class StringOptionParser extends IntOptionParser {

    public StringOptionParser() {
        super(String::valueOf);
    }
}
