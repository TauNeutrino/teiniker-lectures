
package org.se.lab;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mProperty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mProperty">
 *   &lt;complexContent>
 *     &lt;extension base="{}mNamedElement">
 *       &lt;sequence>
 *         &lt;element name="type" type="{}mType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mProperty", propOrder = {
    "type"
})
public class MProperty
    extends MNamedElement
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected MType type;
    @XmlAttribute(name = "id", required = true)
    protected boolean id;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link MType }
     *     
     */
    public MType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link MType }
     *     
     */
    public void setType(MType value) {
        this.type = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public boolean isId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(boolean value) {
        this.id = value;
    }

}
