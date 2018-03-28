/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.eaux.baignade.controllers;

import com.github.adriens.eaux.baignade.domain.Drapeau;
import com.github.adriens.eaux.baignade.domain.PlageDetails;
import com.github.adriens.eaux.baignade.services.PlagesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author salad74
 */
/**
 *
 * @author salad74
 */
@RestController
public class PlagesController {

    @Autowired
    PlagesService plagesService;

    @RequestMapping("/")
    public String hello() {
        return "Qualité des eaux de baignade tels que fournies sur http://www.noumea.nc/actualites/qualite-des-eaux-de-baignade-0";
    }

    @RequestMapping("/plages")
    public List<PlageDetails> getAllPlages() throws Exception {
        try {
            return plagesService.getPlagesDetails();
        } catch (Exception ex) {
            throw ex;
        }

    }

    @RequestMapping("/plages/{plageId}")
    public PlageDetails getPlageDetails(
            @PathVariable(value = "plageId") int plageId) throws Exception {
        try {
            return plagesService.getDetailsOfPlage(plageId);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping("/drapeaux")
    public List<Drapeau> getDrapeaux() {
        return plagesService.getDrapeaux();
    }
}
