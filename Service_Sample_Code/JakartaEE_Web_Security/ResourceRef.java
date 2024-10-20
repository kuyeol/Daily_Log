//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.29 at 09:57:40 PM UTC 
//


package com.sun.ts.lib.implementation.sun.javaee.runtime.web;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resRefName",
    "jndiName",
    "defaultResourcePrincipal"
})
@XmlRootElement(name = "resource-ref")
public class ResourceRef
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "res-ref-name", required = true)
    protected String resRefName;
    @XmlElement(name = "jndi-name", required = true)
    protected String jndiName;
    @XmlElement(name = "default-resource-principal")
    protected DefaultResourcePrincipal defaultResourcePrincipal;

    /**
     * Gets the value of the resRefName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResRefName() {
        return resRefName;
    }

    /**
     * Sets the value of the resRefName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResRefName(String value) {
        this.resRefName = value;
    }

    /**
     * Gets the value of the jndiName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJndiName() {
        return jndiName;
    }

    /**
     * Sets the value of the jndiName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJndiName(String value) {
        this.jndiName = value;
    }

    /**
     * Gets the value of the defaultResourcePrincipal property.
     * 
     * @return
     *     possible object is
     *     {@link DefaultResourcePrincipal }
     *     
     */
    public DefaultResourcePrincipal getDefaultResourcePrincipal() {
        return defaultResourcePrincipal;
    }

    /**
     * Sets the value of the defaultResourcePrincipal property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultResourcePrincipal }
     *     
     */
    public void setDefaultResourcePrincipal(DefaultResourcePrincipal value) {
        this.defaultResourcePrincipal = value;
    }

}
