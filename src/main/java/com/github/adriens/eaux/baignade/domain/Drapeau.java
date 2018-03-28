/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.eaux.baignade.domain;

import com.github.adriens.eaux.baignade.sdk.CouleurDrapeau;
import java.util.HashMap;

/**
 *
 * @author salad74
 */
public class Drapeau {

    public final static String COMMENTAIRE_DRAPEAU_BLEU = "Eau de bonne qualité, baignade autorisée";
    public final static String COMMENTAIRE_DRAPEAU_JAUNE = "Eau de qualité médiocre, baignade déconseillée";
    public final static String COMMENTAIRE_DRAPEAU_ROUGE = "Eau de mauvaise qualité, baignade interdite";
    
    
    private CouleurDrapeau couleurDrapeau;
    private String commentaireDrapeau;
    
    public static final HashMap<CouleurDrapeau, Drapeau> getDrapeaux(){
        HashMap<CouleurDrapeau, Drapeau> out = new HashMap<CouleurDrapeau, Drapeau>();
        out.put(CouleurDrapeau.BLEU, new Drapeau(CouleurDrapeau.BLEU, Drapeau.COMMENTAIRE_DRAPEAU_BLEU));
        out.put(CouleurDrapeau.JAUNE, new Drapeau(CouleurDrapeau.JAUNE, Drapeau.COMMENTAIRE_DRAPEAU_JAUNE));
        out.put(CouleurDrapeau.ROUGE, new Drapeau(CouleurDrapeau.ROUGE, Drapeau.COMMENTAIRE_DRAPEAU_ROUGE));
        return out;
    }
    
    public Drapeau(CouleurDrapeau aCouleur, String commentaireDrapeau){
        setCouleurDrapeau(aCouleur);
        setCommentaireDrapeau(commentaireDrapeau);
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
    public void setCouleurDrapeau(CouleurDrapeau couleurDrapeau) {
        this.couleurDrapeau = couleurDrapeau;
    }

    /**
     * @return the commentaireDrapeau
     */
    public String getCommentaireDrapeau() {
        return commentaireDrapeau;
    }

    /**
     * @param commentaireDrapeau the commentaireDrapeau to set
     */
    public void setCommentaireDrapeau(String commentaireDrapeau) {
        this.commentaireDrapeau = commentaireDrapeau;
    }
    
}
