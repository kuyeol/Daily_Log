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
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "constraint-field-value")
public class ConstraintFieldValue
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "match-expr")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String matchExpr;
    @XmlAttribute(name = "cache-on-match")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cacheOnMatch;
    @XmlAttribute(name = "cache-on-match-failure")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cacheOnMatchFailure;
    @XmlValue
    protected String value;

    /**
     * Gets the value of the matchExpr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatchExpr() {
        if (matchExpr == null) {
            return "equals";
        } else {
            return matchExpr;
        }
    }

    /**
     * Sets the value of the matchExpr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatchExpr(String value) {
        this.matchExpr = value;
    }

    /**
     * Gets the value of the cacheOnMatch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCacheOnMatch() {
        if (cacheOnMatch == null) {
            return "true";
        } else {
            return cacheOnMatch;
        }
    }

    /**
     * Sets the value of the cacheOnMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCacheOnMatch(String value) {
        this.cacheOnMatch = value;
    }

    /**
     * Gets the value of the cacheOnMatchFailure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCacheOnMatchFailure() {
        if (cacheOnMatchFailure == null) {
            return "false";
        } else {
            return cacheOnMatchFailure;
        }
    }

    /**
     * Sets the value of the cacheOnMatchFailure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCacheOnMatchFailure(String value) {
        this.cacheOnMatchFailure = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getvalue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setvalue(String value) {
        this.value = value;
    }

}
