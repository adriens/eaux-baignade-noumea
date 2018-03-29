/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.eaux.baignade.domain;

import com.github.adriens.eaux.baignade.sdk.SiteCrawler;
import java.util.Date;

/**
 *
 * @author salad74
 */
public class PageMetaDatas {

    private Date lastUpdateDate;
    
    public PageMetaDatas() throws Exception {
        setLastUpdateDate();
    }
            
            /**
     * @return the lastUpdateDate
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * @param lastUpdateDate the lastUpdateDate to set
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    public void setLastUpdateDate() throws Exception {
        setLastUpdateDate(SiteCrawler.getLastUpdateDate());
    }
    
    
}
