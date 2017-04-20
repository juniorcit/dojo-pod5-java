package com.ciandt.dojo.repository;

import com.ciandt.dojo.models.Exame;
import com.ciandt.dojo.utils.CSVParserBuilder;
import com.ciandt.dojo.utils.CsvParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class ExameRepositoryImpl implements ExameRepository {

    @Value("${file.name}")
    private String fileName;
    @Value("${file.path}")
    private String filePath;

    @Override
    public List<Exame> list() {

        CsvParser csvParser = new CSVParserBuilder().withFileName(fileName).withFilePath(filePath).build();
        return csvParser.readExames();
    }
}
