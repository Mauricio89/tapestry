/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.data;

/**
 *
 * @author Mauricio
 */
public enum JasperAssets {
    RECEIPT_TOOLS_STOCK("toolsStock.jasper"),
    TICKET_EXPORTER("carrera.jasper");
    //TODOS los demas ...
    private final String name;
    
    private SimaAssets(String name) {
        this.name = name;
    }
    
    public String getURL() {
        //return "http://host/" + name;
        return "http://localhost:8080/" + name;
    }
}
