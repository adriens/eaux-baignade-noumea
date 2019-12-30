/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.eaux.baignade.sdk;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import com.github.adriens.eaux.baignade.domain.PageMetaDatas;
import com.github.adriens.eaux.baignade.domain.PlageDetails;
import com.github.adriens.eaux.baignade.domain.ShieldEndpointResponse;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author salad74
 */
public class SiteCrawler {

    public static final String URL_ROOT = "http://www.noumea.nc";
    public static final String URL_BAIGNADE = URL_ROOT + "/actualites/qualite-des-eaux-de-baignade-0";

    public static final String ID_POINTE_MAGNIN = "PLAGE DE LA POINTE MAGNIN";
    public static final String ID_PROMENADE_PIERRE_VERNIER = "PLAGE DE LA PROMENADE PIERRE VERNIER";
    public static final String ID_ANSE_VATA = "PLAGE DE L'ANSE VATA";
    public static final String ID_MAGENTA = "PLAGE DE MAGENTA";
    public static final String ID_KUENDU_BEACH = "PLAGE DU KUENDU BEACH";
    public static final String ID_BAIE_DES_CITRONS = "PLAGE DE LA BAIE DES CITRONS";
    
    public static final String URL_STREAM_ANSE_VATA = "https://youtu.be/Fzo8jORoQMo";
    public static final String URL_STREAM_BAIE_DES_CITRONS = "https://youtu.be/2u4CwVllO_w";
    
    public static final String PATH_IMG_DRAPEAU_BLEU = "/sites/default/files/drapeau-bleu.png";
    public static final String PATH_IMG_DRAPEAU_JAUNE = "/sites/default/files/drapeau-jaune.png";
    public static final String PATH_IMG_DRAPEAU_ROUGE = "/sites/default/files/drapeau-rouge.png";

    public static final String URL_IMG_DRAPEAU_BLEU = URL_ROOT + PATH_IMG_DRAPEAU_BLEU;
    public static final String URL_IMG_DRAPEAU_JAUNE = URL_ROOT + PATH_IMG_DRAPEAU_JAUNE;
    public static final String URL_IMG_DRAPEAU_ROUGE = URL_ROOT + PATH_IMG_DRAPEAU_ROUGE;

    final static Logger logger = LoggerFactory.getLogger(SiteCrawler.class);

    // Pure htmlunit WebClient mthode
    private static WebClient buildWebClient() {
        // Disable verbose logs
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setDownloadImages(false);
        return webClient;
    }

    public static final CouleurDrapeau extractCouleurDrapeau(String text) throws Exception {
        if (text.contains(SiteCrawler.PATH_IMG_DRAPEAU_BLEU)) {
            return CouleurDrapeau.BLEU;
        } else if (text.contains(SiteCrawler.PATH_IMG_DRAPEAU_JAUNE)) {
            return CouleurDrapeau.JAUNE;
        } else if (text.contains(SiteCrawler.PATH_IMG_DRAPEAU_ROUGE)) {
            return CouleurDrapeau.ROUGE;
        } else {
            throw new Exception("Not able to fetch plage status from input text : <" + text + ">");
        }
    }

    public static final URL getURLForColor(CouleurDrapeau color) throws Exception {
        if (color == CouleurDrapeau.BLEU) {
            return new URL(URL_IMG_DRAPEAU_BLEU);
        } else if (color == CouleurDrapeau.JAUNE) {
            return new URL(URL_IMG_DRAPEAU_JAUNE);
        } else if (color == CouleurDrapeau.ROUGE) {
            return new URL(URL_IMG_DRAPEAU_ROUGE);
        } else {
            throw new Exception("Not able to return URL for unknow color : " + color);
        }
    }

    public static final HashMap<Integer, PlageDetails> getPlagesStatus() throws Exception {
        HashMap<Integer, PlageDetails> out = new HashMap<Integer, PlageDetails>();
        WebClient webClient = buildWebClient();
        HtmlPage htmlPage = webClient.getPage(URL_BAIGNADE);

        //pas d'id sur la table sur le site internet ;-(
        final HtmlTable plagesTable = htmlPage.getFirstByXPath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[1]/table");
        int i = 0;
        for (final HtmlTableRow row : plagesTable.getBodies().get(0).getRows()) {
            logger.debug("Found row");
            String nomPlage = row.getCell(0).asText();
            logger.debug("Nom de la plage : <" + nomPlage + ">");
            String tmp = row.getCell(1).getChildNodes().get(0).getAttributes().item(1) + "";
            //String tmp = ((HTMLElement)(row.getCell(1)).getFirstByXPath(".//td/img")).toString() + "";//.get(0).getElementsByTagName("img").get(0).getAttribute("src") + "";
            logger.debug("Qualite : <" + tmp + ">");
            //System.out.println("Qualite : <" + SiteCrawler.extractCouleurDrapeau(tmp) + ">");
            CouleurDrapeau couleur;
            String url;
            couleur = SiteCrawler.extractCouleurDrapeau(tmp);
            PlageDetails lStatus = new PlageDetails(couleur, nomPlage, SiteCrawler.getURLForColor(couleur), i);
            out.put(i, lStatus);
            logger.debug("Key : <" + i + ">");
            logger.debug(lStatus.toString());
            i++;
        }

        return out;
    }
    
    public static final Date getLastUpdateDate() throws Exception {
        WebClient webClient = buildWebClient();
        HtmlPage htmlPage = webClient.getPage(URL_BAIGNADE);
        HtmlAnchor lastUpdateDate = htmlPage.getFirstByXPath("/html/body/div[1]/div[3]/div/div[2]/div/div/div[1]/h5[2]/a");
        return extractDateFromLastUpdateText(lastUpdateDate.asText());
    }
    
    public static final Date extractDateFromLastUpdateText(String text) throws ParseException {
        Date out;
        String tmp = text;
        tmp = tmp.replace("QUALITÉ DES EAUX DE BAIGNADE : ", "");
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        out = formatter.parse(tmp);
        return out;
    }
    public static final PlageDetails getDetailsOfPlage(int i) throws Exception {
        return getPlagesStatus().get(i);
    }
    
public static final List<PlageDetails> getPlagesDetails() throws Exception {
        List<PlageDetails> out = new ArrayList<PlageDetails>();
        Iterator it = getPlagesStatus().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Integer key = (Integer) pair.getKey();
            PlageDetails value = (PlageDetails) pair.getValue();
            //System.out.println(pair.getKey() + " = " + );
            out.add(value);
        }
        return out;
    }

    public static final PageMetaDatas getPageMetaDatas() throws Exception {
        return new PageMetaDatas();
    }

    public static final HashMap<Integer, String> getPlages() throws Exception {
        HashMap<Integer, String> out = new HashMap<Integer, String>();
        Iterator it = getPlagesStatus().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Integer key = (Integer) pair.getKey();
            PlageDetails value = (PlageDetails) pair.getValue();
            //System.out.println(pair.getKey() + " = " + );
            out.put(key, value.getNomPlage());
        }
        return out;
    }

    public static final ShieldEndpointResponse getShieldResponse(int plageId) throws Exception{
        return new ShieldEndpointResponse(SiteCrawler.getDetailsOfPlage(plageId));
    }
    public static void main(String[] args) {
        try {
            SiteCrawler.getPlagesStatus();
            
                    //System.out.println(SiteCrawler.getLastUpdateDate());
                    
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
