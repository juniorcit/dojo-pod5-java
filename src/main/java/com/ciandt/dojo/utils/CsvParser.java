package com.ciandt.dojo.utils;

import com.ciandt.dojo.models.Exame;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvParser implements Closeable {

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

    public List<Exame> readExames() {
        try {
            bufferedReader.reset();
            bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] columns
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void close() throws IOException {
        if (bufferedReader != null)
            bufferedReader.close();
    }
}
