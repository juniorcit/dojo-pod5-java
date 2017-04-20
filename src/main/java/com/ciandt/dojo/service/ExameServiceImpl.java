package com.ciandt.dojo.service;

import com.ciandt.dojo.models.Exame;
import com.ciandt.dojo.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameServiceImpl implements ExameService {

    @Autowired
    private ExameRepository exameRepository;

    @Override
    public List<Exame> getExames() {
        return exameRepository.list();
    }

}
