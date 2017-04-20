package com.ciandt.dojo.utils;

import com.ciandt.dojo.models.Exame;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvParser implements Closeable {

    private final Reader reader;

    public CsvParser(final Reader readerFromBufer) {
        reader = readerFromBufer;
    }

    public List<String> readHeaders() {

        try {
            BufferedReader bufferedReader = getBufferedReader();
            return Arrays.asList(bufferedReader.readLine().split(","));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public List<Exame> readExames() {
        try {
            BufferedReader bufferedReader = getBufferedReader();
            bufferedReader.readLine();

            List<Exame> exames = new ArrayList<Exame>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                exames.add(getExameFromLine(line));
            }
            return  exames;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private Exame getExameFromLine(String line) {
        String[] fieldValues =  line.split(",");

        Double price = -1.0;
        try {
            price = Double.parseDouble(fieldValues[2]);
        }catch (NumberFormatException e){
            System.out.println("Exame com preço inválido");
        }
        return  new Exame(fieldValues[0], fieldValues[1], price);
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
