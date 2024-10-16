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
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "roleName",
    "principalNameOrGroupName"
})
@XmlRootElement(name = "security-role-mapping")
public class SecurityRoleMapping
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "role-name", required = true)
    protected String roleName;
    @XmlElements({
        @XmlElement(name = "principal-name", required = true, type = PrincipalName.class),
        @XmlElement(name = "group-name", required = true, type = GroupName.class)
    })
    protected List<Serializable> principalNameOrGroupName;

    /**
     * Gets the value of the roleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the value of the roleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoleName(String value) {
        this.roleName = value;
    }

    /**
     * Gets the value of the principalNameOrGroupName property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the principalNameOrGroupName property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPrincipalNameOrGroupName().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link PrincipalName }
     * {@link GroupName }
     * 
     * 
     */
    public List<Serializable> getPrincipalNameOrGroupName() {
        if (principalNameOrGroupName == null) {
            principalNameOrGroupName = new ArrayList<Serializable>();
        }
        return this.principalNameOrGroupName;
    }

}
