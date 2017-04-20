package com.ciandt.dojo.utils;

import com.ciandt.dojo.models.Exame;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvParser implements Closeable {

    private final Reader reader;

    public CsvParser(final Reader readerFromBuffer) {
        reader = readerFromBuffer;
    }

    public List<String> readHeaders() {

        try(BufferedReader bufferedReader = getBufferedReader()){
            return bufferedReader
                    .lines()
                    .findFirst()
                    .map(l -> Arrays.asList(l.split(",")))
                    .get();

        }catch (IOException e){
            throw new UncheckedIOException(e);
        }
    }

    public List<Exame> readExames() {
        try(BufferedReader bufferedReader = getBufferedReader()) {

            return bufferedReader
                    .lines()
                    .skip(1)
                    .map(l -> getExameFromLine(l))
                    .collect(Collectors.toList());

        }catch (IOException e){
            throw  new UncheckedIOException(e);
        }
    }

    private Exame getExameFromLine(String l) {
        String[] fieldValues =  l.split(",");

        Double price = -1.0;
        try {
            price = Double.parseDouble(fieldValues[2]);
        }catch (NumberFormatException e){
            System.out.println("Exame com preço inválido");
        }
        return new Exame(fieldValues[0], fieldValues[1], price);
    }

    private BufferedReader getBufferedReader() {
        return new BufferedReader(reader);
    }

    @Override
    public void close() throws IOException {
        if (reader != null)
            reader.close();
    }
}
