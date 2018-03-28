/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.eaux.baignade.domain;

import com.github.adriens.eaux.baignade.sdk.CouleurDrapeau;
import java.net.URL;


/**
 *
 * @author salad74
 */
public class PlageDetails {

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
    
    
    public PlageDetails(){
        
    }
    
    public PlageDetails(CouleurDrapeau aCouleur, String aNomPlage, URL urlDrapeau, int plageId){
        setCouleurDrapeau(aCouleur);
        setNomPlage(aNomPlage);
        setUrlIconeDrapeau(urlDrapeau);
        setPlageId(plageId);
        
    }
    /**
     * @return the couleurDrapeau
     */
    public CouleurDrapeau getCouleurDrapeau() {
        return couleurDrapeau;
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
}
