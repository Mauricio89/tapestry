/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import entidades.Usuario;
import java.io.Serializable;


/**
 *
 * @author Mauricio
 */

@SuppressWarnings("serial")
public class Visit implements Serializable{
    private Integer myUserId = null;
    private String myCuenta = null;
    //private PageStyle pageStyle = null;
//    private String dateInputPattern = null;
//    private String dateViewPattern = null;
//    private String dateListPattern = null;
    
    public Visit(Usuario user) {
        myUserId = user.getIdusuario();
        cacheUsefulStuff(user);
    }

    public void noteChanges(Usuario user) {
        if (user == null) {
            throw new IllegalArgumentException();
        }
        else if (user.getIdusuario().equals(myUserId)) {
            cacheUsefulStuff(user);
        }
    }

    private void cacheUsefulStuff(Usuario user) {
        myCuenta = user.getCuenta();
        //pageStyle = user.getPageStyle();
//        dateInputPattern = user.getDateInputPattern();
//        dateViewPattern = user.getDateViewPattern();
//        dateListPattern = user.getDateListPattern();
    }

    public Integer getMyUserId() {
        return myUserId;
    }

    public String getCuenta() {
        return myCuenta;
    }

//    public PageStyle getPageStyle() {
//        return pageStyle;
//    }
//
//    public String getDateInputPattern() {
//        return dateInputPattern;
//    }
//
//    public String getDateViewPattern() {
//        return dateViewPattern;
//    }
//
//    public String getDateListPattern() {
//        return dateListPattern;
//    }
}
