/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.data;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 *
 * @author Mauricio
 */
public enum JasperReportType {
    PDF(new JRPdfExporter(), "pdf", "application/pdf"), 
    XLS(new JRXlsExporter(), "xls", "application/vnd.ms-excel");
    
    private JRExporter exporter;
    
    private String extension;
    
    private String type;
    /**
     * @param exporter
     * @param extension
     * @param type
     */
    private JasperReportType(
            JRExporter exporter,
            String extension,
            String type) {
        this.exporter = exporter;
        this.extension = extension;
        this.type = type;
    }
    /**
     * @return the exporter
     */
    public JRExporter getExporter() {
        return exporter;
    }
    /**
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
}
