/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.components;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

/**
 *
 * @author Mauricio
 */

@Import(stylesheet = "context:Recursos/Css/estilos.css")
public class Plantilla1 {
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String titulo;
}
