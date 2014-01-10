/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.pages;

import com.mycompany.tapestry_1.services.CarreraDAO;
import entidades.Carrera;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Mauricio
 */
public class PruebaImprimir {
private List<Carrera> listacarrera;
    @Inject
    private CarreraDAO daocarrera;
      
      
//    public List<Carrera> getListacarrera() {        
//        try
//        {
//          listacarrera=daocarrera.listarTodos();
//        }
//        catch(Exception ex)
//        {
//        
//        }
//        return listacarrera;
//    }
     JasperPrint jasperPrint;  
    public void init() throws JRException, ClassNotFoundException, SQLException { 
        JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(listacarrera);  
        String  reportPath=  FacesContext.getCurrentInstance().getExternalContext().getRealPath("carrera.jasper");
        jasperPrint=JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);  
    }                 
   public void getPDF(){
       try
       {
        listacarrera=daocarrera.listarTodos();
        JRBeanCollectionDataSource beanCollectionDataSource=new JRBeanCollectionDataSource(listacarrera);  
        String  reportPath=  FacesContext.getCurrentInstance().getExternalContext().getRealPath("carrera.jasper");
        jasperPrint=JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);   
       HttpServletResponse httpServletResponse=(HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();  
       httpServletResponse.addHeader("Content-disposition", "attachment; filename=carreras.pdf");  
       ServletOutputStream servletOutputStream=httpServletResponse.getOutputStream();  
       JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);  
       FacesContext.getCurrentInstance().responseComplete();  
       }
       catch(Exception ex)
       {
           System.out.println(ex.getMessage());
       }         
   }  
  
}
