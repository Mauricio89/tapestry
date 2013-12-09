/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestry_1.mixins;

import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.ClientElement;
import org.apache.tapestry5.annotations.AfterRender;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectContainer;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.json.JSONObject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 *
 * @author Mauricio
 */

@Import(library = "Confirm.js")
public class Confirm {
    @Parameter(name = "message", value = "Esta seguro?", defaultPrefix = BindingConstants.LITERAL)
    private String message;

    @Inject
    private JavaScriptSupport javaScriptSupport;

    @InjectContainer
    private ClientElement clientElement;

    @AfterRender
    public void afterRender() {

        // Tell the Tapestry.Initializer to do the initializing of a Confirm, which it will do when the DOM has been
        // fully loaded.

        JSONObject spec = new JSONObject();
        spec.put("elementId", clientElement.getClientId());
        spec.put("message", message);
        javaScriptSupport.addInitializerCall("confirm", spec);
    }
}
