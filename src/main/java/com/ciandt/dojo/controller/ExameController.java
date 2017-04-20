package com.ciandt.dojo.controller;

import com.ciandt.dojo.models.Exame;
import com.ciandt.dojo.service.ExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exame")
public class ExameController {

    @Autowired
    private ExameService exameService;

    @RequestMapping(method = RequestMethod.GET, path = "/exames")
    public List<Exame> getExames() {
        return exameService.getExames();
    }

}
