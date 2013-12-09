/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.services;

import com.mycompany.tapestry_1.data.JasperAssets;
import com.mycompany.tapestry_1.data.JasperReportType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Mauricio
 */

/**
  *Clase para la generacion del reporte.
  */
public class JasperReportGenerator {
    private static final Logger LOG = LoggerFactory.getLogger(JasperReportGenerator.class);
    
   /**
    * name: Nombre del reporte
    * asset: Enum que contiene la URL de la plantilla del reporte ya compilado
    * type: Enum que contiene el tipo de impresora de jasper, asi como el tipo de archivo y extencion del archivo
    * beanCollection: Es la colleccion de objetos que se desplegaran en el reporte y puede ser cualquier POJO, las propiedades del POJO tendran que estar como fields en el reporte de jasper, jasper se encargara de la obtencion de los valores de cada objeto.
    */
    public File generate(
            String name,
            JasperAssets asset, 
            JasperReportType type, 
            Collection<?> beanCollection) {
        // baos se encarga de almacenar el reporte ya impreso en un arreglo de bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        JasperReport report = null;
        JasperPrint jasperPrint = null;
        try {
            report = (JasperReport) JRLoader
                    .loadObject(new URL(asset.getURL()));
            
            jasperPrint = JasperFillManager.fillReport(
                    report, 
                    null, 
                    new JRBeanCollectionDataSource(beanCollection));
            
            JRExporter exporter = type.getExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
            exporter.exportReport();
        } catch (MalformedURLException e) {
            LOG.error("------ [ Error de malformacion ] ------", e);
            LOG.error("------ [ {} ] ------", e.getMessage());
        } catch (JRException e) {
            LOG.error("------ [ Error de JasperReport ] ------", e);
            LOG.error("------ [ {} ] ------", e.getMessage());
        }
        
        //Retornamos un File pues es nuestro wrapper de archivos
        return buildFile(name, baos, type);
    }
    
    private File buildFile(
            String name,
            ByteArrayOutputStream baos, 
            JasperReportType type) {
        
        //File file = new File();
        file.setContent(baos.toByteArray());
        file.setExtension(type.getExtension());
        file.setName(name);
        file.setSize(baos.size());
        file.setTitle(name);
        file.setType(type.getType());
        
        return file;
    }
}
