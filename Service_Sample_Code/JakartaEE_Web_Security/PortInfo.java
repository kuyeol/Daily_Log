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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serviceEndpointInterface",
    "wsdlPort",
    "stubProperty",
    "callProperty",
    "messageSecurityBinding"
})
@XmlRootElement(name = "port-info")
public class PortInfo
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "service-endpoint-interface")
    protected String serviceEndpointInterface;
    @XmlElement(name = "wsdl-port")
    protected WsdlPort wsdlPort;
    @XmlElement(name = "stub-property")
    protected List<StubProperty> stubProperty;
    @XmlElement(name = "call-property")
    protected List<CallProperty> callProperty;
    @XmlElement(name = "message-security-binding")
    protected MessageSecurityBinding messageSecurityBinding;

    /**
     * Gets the value of the serviceEndpointInterface property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceEndpointInterface() {
        return serviceEndpointInterface;
    }

    /**
     * Sets the value of the serviceEndpointInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceEndpointInterface(String value) {
        this.serviceEndpointInterface = value;
    }

    /**
     * Gets the value of the wsdlPort property.
     * 
     * @return
     *     possible object is
     *     {@link WsdlPort }
     *     
     */
    public WsdlPort getWsdlPort() {
        return wsdlPort;
    }

    /**
     * Sets the value of the wsdlPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsdlPort }
     *     
     */
    public void setWsdlPort(WsdlPort value) {
        this.wsdlPort = value;
    }

    /**
     * Gets the value of the stubProperty property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the stubProperty property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getStubProperty().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link StubProperty }
     * 
     * 
     */
    public List<StubProperty> getStubProperty() {
        if (stubProperty == null) {
            stubProperty = new ArrayList<StubProperty>();
        }
        return this.stubProperty;
    }

    /**
     * Gets the value of the callProperty property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the callProperty property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCallProperty().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link CallProperty }
     * 
     * 
     */
    public List<CallProperty> getCallProperty() {
        if (callProperty == null) {
            callProperty = new ArrayList<CallProperty>();
        }
        return this.callProperty;
    }

    /**
     * Gets the value of the messageSecurityBinding property.
     * 
     * @return
     *     possible object is
     *     {@link MessageSecurityBinding }
     *     
     */
    public MessageSecurityBinding getMessageSecurityBinding() {
        return messageSecurityBinding;
    }

    /**
     * Sets the value of the messageSecurityBinding property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageSecurityBinding }
     *     
     */
    public void setMessageSecurityBinding(MessageSecurityBinding value) {
        this.messageSecurityBinding = value;
    }

}
