//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.29 at 09:57:40 PM UTC 
//


package com.sun.ts.lib.implementation.sun.javaee.runtime.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cacheHelper",
    "defaultHelper",
    "property",
    "cacheMapping"
})
@XmlRootElement(name = "cache")
public class Cache
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlAttribute(name = "max-entries")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String maxEntries;
    @XmlAttribute(name = "timeout-in-seconds")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String timeoutInSeconds;
    @XmlAttribute(name = "enabled")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String enabled;
    @XmlElement(name = "cache-helper")
    protected List<CacheHelper> cacheHelper;
    @XmlElement(name = "default-helper")
    protected DefaultHelper defaultHelper;
    protected List<Property> property;
    @XmlElement(name = "cache-mapping")
    protected List<CacheMapping> cacheMapping;

    /**
     * Gets the value of the maxEntries property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaxEntries() {
        if (maxEntries == null) {
            return "4096";
        } else {
            return maxEntries;
        }
    }

    /**
     * Sets the value of the maxEntries property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaxEntries(String value) {
        this.maxEntries = value;
    }

    /**
     * Gets the value of the timeoutInSeconds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeoutInSeconds() {
        if (timeoutInSeconds == null) {
            return "30";
        } else {
            return timeoutInSeconds;
        }
    }

    /**
     * Sets the value of the timeoutInSeconds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeoutInSeconds(String value) {
        this.timeoutInSeconds = value;
    }

    /**
     * Gets the value of the enabled property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnabled() {
        if (enabled == null) {
            return "true";
        } else {
            return enabled;
        }
    }

    /**
     * Sets the value of the enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnabled(String value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the cacheHelper property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the cacheHelper property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCacheHelper().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link CacheHelper }
     * 
     * 
     */
    public List<CacheHelper> getCacheHelper() {
        if (cacheHelper == null) {
            cacheHelper = new ArrayList<CacheHelper>();
        }
        return this.cacheHelper;
    }

    /**
     * Gets the value of the defaultHelper property.
     * 
     * @return
     *     possible object is
     *     {@link DefaultHelper }
     *     
     */
    public DefaultHelper getDefaultHelper() {
        return defaultHelper;
    }

    /**
     * Sets the value of the defaultHelper property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultHelper }
     *     
     */
    public void setDefaultHelper(DefaultHelper value) {
        this.defaultHelper = value;
    }

    /**
     * Gets the value of the property property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the property property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getProperty().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link Property }
     * 
     * 
     */
    public List<Property> getProperty() {
        if (property == null) {
            property = new ArrayList<Property>();
        }
        return this.property;
    }

    /**
     * Gets the value of the cacheMapping property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the cacheMapping property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCacheMapping().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link CacheMapping }
     * 
     * 
     */
    public List<CacheMapping> getCacheMapping() {
        if (cacheMapping == null) {
            cacheMapping = new ArrayList<CacheMapping>();
        }
        return this.cacheMapping;
    }

}
