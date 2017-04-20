package com.ciandt.dojo.utils;

import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CsvParserTest {

    private CsvParser parser = createCsvParser();

    @Test
    public void testIfCsvIsLoaded() {

    }

    private CsvParser createCsvParser() {
        final Path path = Paths.get("src/main/resources", "exams.csv");

        try {
            Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            return new CsvParser(reader);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }


}