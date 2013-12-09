/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.services.Response;
import com.mycompany.tapestry_1.services.File;

/**
 *
 * @author Mauricio
 */

/**
  * Genera StreamResponse de tapestry. Se puede utilizar para abrir una nueva pagina o descarga con liga en la misma pagina.
  * Se utiliza para la obtencion de Reportes en Jasper u obtencion de archivos almacenados en DB.
  */
public final class StreamResponseFactory {
    /**
     * Se le pasa un File que contiene la informacion del archivo para generar un streamResponse
     */
    public StreamResponse getResponse(final File file) {
        
        return new StreamResponse() {
            @Override
            public void prepareResponse(Response response) {
                response.setHeader("Content-Disposition", file.toString());
            }
            @Override
            public InputStream getStream() throws IOException {
                return new ByteArrayInputStream(file.getContent());
            }
            @Override
            public String getContentType() {
                return file.getType();
            }
        };
        
    }
}
