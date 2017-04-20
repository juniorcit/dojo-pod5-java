package com.ciandt.dojo.utils;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVParserBuilder {

    private String fileName;
    private String filePath;

    public CSVParserBuilder withFileName(final String fileName) {
        this.fileName = fileName;
        return this;
    }

    public CSVParserBuilder withFilePath(final String filePath) {
        this.filePath = filePath;
        return this;
    }

    public CsvParser build() {
        final Path path = Paths.get(this.filePath, this.fileName);

        try {
            Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            return new CsvParser(reader);
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

}
