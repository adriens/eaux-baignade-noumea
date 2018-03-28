/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.eaux.baignade.services;

import com.github.adriens.eaux.baignade.domain.PlageDetails;
import com.github.adriens.eaux.baignade.domain.PlageDetails;
import com.github.adriens.eaux.baignade.sdk.SiteCrawler;
import static com.github.adriens.eaux.baignade.sdk.SiteCrawler.getPlagesStatus;
import java.util.HashMap;
import java.util.List;
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
}
