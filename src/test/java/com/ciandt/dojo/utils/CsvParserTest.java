package com.ciandt.dojo.utils;

import com.ciandt.dojo.models.Exame;
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
        parser = new CSVParserBuilder().withFilePath("src/main/resources").withFileName("exams.csv").build();
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

    @Test
    public void testReadExames() {
        List<Exame> listExames = parser.readExames();
        Assert.assertThat(listExames, Matchers.notNullValue());
        Assert.assertThat(listExames.size(), Matchers.greaterThan(10));
    }
}