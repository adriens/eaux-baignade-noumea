/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.eaux.baignade.services;

import com.github.adriens.eaux.baignade.domain.Drapeau;
import com.github.adriens.eaux.baignade.domain.PageMetaDatas;
import com.github.adriens.eaux.baignade.domain.PlageDetails;
import com.github.adriens.eaux.baignade.sdk.CouleurDrapeau;
import com.github.adriens.eaux.baignade.sdk.SiteCrawler;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author salad74
 */
@Service
public class PlagesService {
    private final Logger log = LoggerFactory.getLogger(PlagesService.class);
    
    public List<PlageDetails> getPlagesDetails() throws Exception {
        return SiteCrawler.getPlagesDetails();
    }
    
    public PlageDetails getDetailsOfPlage(int i) throws Exception {
        return SiteCrawler.getDetailsOfPlage(i);
    }
    
    public List<Drapeau> getDrapeaux(){
        return Drapeau.getDrapeaux().values().stream().collect(Collectors.toList());
    }
    
    public Drapeau getDrapeau(CouleurDrapeau aCouleur){
        return Drapeau.getDrapeaux().get(aCouleur);
    }
    public Drapeau getDrapeau(String aCouleur){
        return Drapeau.getDrapeaux().get(CouleurDrapeau.valueOf(aCouleur.toUpperCase()));
    }
    
    public PageMetaDatas getPageMetaDatas() throws Exception {
        return SiteCrawler.getPageMetaDatas();
    }
}
