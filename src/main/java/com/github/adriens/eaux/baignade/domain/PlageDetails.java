/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.eaux.baignade.domain;

import com.github.adriens.eaux.baignade.sdk.CouleurDrapeau;
import com.github.adriens.eaux.baignade.sdk.SiteCrawler;
import java.net.URL;


/**
 *
 * @author salad74
 */
public class PlageDetails {

    /**
     * @return the videoStreamURL
     */
    public String getVideoStreamURL() {
        return videoStreamURL;
    }

    /**
     * @param videoStreamURL the videoStreamURL to set
     */
    public void setVideoStreamURL(String videoStreamURL) {
        this.videoStreamURL = videoStreamURL;
    }
    
    public void setVideoStreamURL(){
        if(this.nomPlage.equalsIgnoreCase(SiteCrawler.ID_BAIE_DES_CITRONS)){
            this.videoStreamURL = SiteCrawler.URL_STREAM_BAIE_DES_CITRONS;
        }
        else if (this.nomPlage.equalsIgnoreCase(SiteCrawler.ID_ANSE_VATA)){
            this.videoStreamURL = SiteCrawler.URL_STREAM_ANSE_VATA;
        }
        else if (this.nomPlage.equalsIgnoreCase(SiteCrawler.ID_KUENDU_BEACH)){
            this.videoStreamURL = SiteCrawler.URL_STREAM_KUENDU_BEACH;
        }
        
        
    }

    /**
     * @return the plageId
     */
    public int getPlageId() {
        return plageId;
    }

    /**
     * @param plageId the plageId to set
     */
    public void setPlageId(int plageId) {
        this.plageId = plageId;
    }

    private CouleurDrapeau couleurDrapeau;
    private String nomPlage;
    private URL urlIconeDrapeau;
    private int plageId;
    private String videoStreamURL;
    
    
    public PlageDetails(){
        
    }
    
    public PlageDetails(CouleurDrapeau aCouleur, String aNomPlage, URL urlDrapeau, int plageId){
        setCouleurDrapeau(aCouleur);
        setNomPlage(aNomPlage);
        setUrlIconeDrapeau(urlDrapeau);
        setPlageId(plageId);
        setVideoStreamURL();
        
    }
    /**
     * @return the couleurDrapeau
     */
    public CouleurDrapeau getCouleurDrapeau() {
        return couleurDrapeau;
    }
    public String getCouleurDrapeauEnglish() {
        String out = "";
        if(getCouleurDrapeau() == CouleurDrapeau.BLEU){
            return "blue";
        }
        else if(getCouleurDrapeau() == CouleurDrapeau.JAUNE){
            return "yellow";
        }
        else if(getCouleurDrapeau() == CouleurDrapeau.ROUGE){
            return "red";
        }
        else {
            return "Unknown";
        }
    }
    

    /**
     * @param couleurDrapeau the couleurDrapeau to set
     */
    public void setCouleurDrapeau(CouleurDrapeau aCouleurDrapeau) {
        this.couleurDrapeau = aCouleurDrapeau;
    }

    /**
     * @return the nomPlage
     */
    public String getNomPlage() {
        return nomPlage;
    }

    /**
     * @param nomPlage the nomPlage to set
     */
    public void setNomPlage(String nomPlage) {
        this.nomPlage = nomPlage;
    }

    /**
     * @return the urlIconeDrapeau
     */
    public URL getUrlIconeDrapeau() {
        return urlIconeDrapeau;
    }

    /**
     * @param urlIconeDrapeau the urlIconeDrapeau to set
     */
    public void setUrlIconeDrapeau(URL urlIconeDrapeau) {
        this.urlIconeDrapeau = urlIconeDrapeau;
    }
    public String toString(){
        String out;
        out = "Plage id : <" + getPlageId() + "> : " + getNomPlage() + "/" + getCouleurDrapeau() + ":" + getUrlIconeDrapeau();
        return out;
    }
    
    public String getBaignadeMessage(){
        String out = "";
        if(getCouleurDrapeau() == CouleurDrapeau.BLEU){
            return "Enjoy !";
        }
        else if(getCouleurDrapeau() == CouleurDrapeau.JAUNE){
            return "Avoid swim...";
        }
        else if(getCouleurDrapeau() == CouleurDrapeau.ROUGE){
            return "Swim forbidden !";
        }
        else {
            return "Unknown";
        }
        
    }
}
