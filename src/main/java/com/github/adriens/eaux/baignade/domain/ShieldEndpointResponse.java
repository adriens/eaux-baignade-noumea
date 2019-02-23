/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.eaux.baignade.domain;

import org.apache.commons.text.WordUtils;

/**
 *
 * @author salad74
 */
public class ShieldEndpointResponse {

    private int schemaVersion = 1;
    private String label;
    private String messsage;
    private String color;
    
    public ShieldEndpointResponse(){}
    
    public ShieldEndpointResponse(String label, String message, String color){
        setLabel(label);
        setMesssage(messsage);
        setColor(color);
    }
    public ShieldEndpointResponse(PlageDetails plage){
        setLabel(WordUtils.capitalizeFully(plage.getNomPlage()));
        setMesssage(plage.getBaignadeMessage());
        setColor(plage.getCouleurDrapeauEnglish());
    }
    /**
     * @return the schemaVersion
     */
    public int getSchemaVersion() {
        return schemaVersion;
    }

    /**
     * @param schemaVersion the schemaVersion to set
     */
    public void setSchemaVersion(int schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the messsage
     */
    public String getMesssage() {
        return messsage;
    }

    /**
     * @param messsage the messsage to set
     */
    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }
    
    
}
