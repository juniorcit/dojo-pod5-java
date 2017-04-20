package com.ciandt.dojo.utils;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class CsvParserTest {

    private CsvParser parser;

    @Before
    public void setup() {

        parser = createCsvParser();

    }

    @Test
    public void testIfCsvIsLoaded() {

        Assert.assertNotNull(parser);

    }

    @Test
    public void testReadHeader() {

        List<String> listHeader = parser.readHeaders();

        Assert.assertThat(listHeader, Matchers.contains("name", "code", "price"));
        Assert.assertThat(listHeader, Matchers.hasSize(3));

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