package com.ciandt.dojo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvParser {

    private final BufferedReader bufferedReader;

    public CsvParser(final Reader readerFromBufer) {
        bufferedReader = new BufferedReader(readerFromBufer);
    }

    public List<String> readHeaders() {

        try {
            return Arrays.asList(bufferedReader.readLine().split(","));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
