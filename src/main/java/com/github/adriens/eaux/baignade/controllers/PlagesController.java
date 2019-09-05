/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.eaux.baignade.controllers;

import com.github.adriens.eaux.baignade.domain.Drapeau;
import com.github.adriens.eaux.baignade.domain.PageMetaDatas;
import com.github.adriens.eaux.baignade.domain.PlageDetails;
import com.github.adriens.eaux.baignade.domain.ShieldEndpointResponse;
import com.github.adriens.eaux.baignade.services.PlagesService;
import com.google.common.net.HttpHeaders;
import com.google.common.net.UrlEscapers;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

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
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public String hello() {
        return "Qualité des eaux de baignade tels que fournies sur http://www.noumea.nc/actualites/qualite-des-eaux-de-baignade-0";
    }

    @RequestMapping("/plages")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<PlageDetails> getAllPlages() throws Exception {
        try {
            return plagesService.getPlagesDetails();
        } catch (Exception ex) {
            throw ex;
        }

    }

    @RequestMapping("/plages/{plageId}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public PlageDetails getPlageDetails(
            @PathVariable(value = "plageId") int plageId) throws Exception {
        try {
            return plagesService.getDetailsOfPlage(plageId);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @RequestMapping("/drapeaux")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Drapeau> getDrapeaux() {
        return plagesService.getDrapeaux();
    }

    @RequestMapping("/drapeaux/{drapeauId}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Drapeau getDrapeau(
            @PathVariable(value = "drapeauId") String drapeauId) throws Exception {
        return plagesService.getDrapeau(drapeauId);
    }

    @RequestMapping("/metadatas")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public PageMetaDatas getPageMetaDatas() throws Exception {
        return plagesService.getPageMetaDatas();
    }

    // svg badges
    @RequestMapping(value = "/plages/{plageId}/badge.svg", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Object> redirectToExternalUrl(
            @PathVariable(value = "plageId") int plageId) throws Exception {
        // get datas of the plage with id {id}
        PlageDetails plageDetails = plagesService.getDetailsOfPlage(plageId);
        plageDetails.getNomPlage();
        plageDetails.getBaignadeMessage();
        plageDetails.getCouleurDrapeau().toString().toLowerCase();
        String urlPattern = String.format("https://img.shields.io/badge/%s-%s-%s.svg",
                UrlEscapers.urlPathSegmentEscaper().escape(WordUtils.capitalizeFully(plageDetails.getNomPlage())),
                UrlEscapers.urlPathSegmentEscaper().escape(plageDetails.getBaignadeMessage()),
                UrlEscapers.urlPathSegmentEscaper().escape(plageDetails.getCouleurDrapeauEnglish().toString().toLowerCase()));
        
        URI uri = new URI(urlPattern);
        //URI uri = new URI("https://img.shields.io/badge/Baie%20des%20citrons-Enjoy%20!-blue.svg");
        org.springframework.http.HttpHeaders httpHeaders = new org.springframework.http.HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }
    
    // SHields dedicated endpoint
    @RequestMapping("/plages/{plageId}/shield")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ShieldEndpointResponse getShieldResponse(
            @PathVariable(value = "plageId") int plageId) throws Exception {
        try {
            return plagesService.getShieldResponse(plageId);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
