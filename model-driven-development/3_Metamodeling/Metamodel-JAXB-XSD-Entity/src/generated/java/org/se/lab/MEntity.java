
package org.se.lab;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{}mNamedElement">
 *       &lt;sequence>
 *         &lt;element name="properties" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="property" type="{}mProperty" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mEntity", propOrder = {
    "properties"
})
public class MEntity
    extends MNamedElement
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElementWrapper(name = "properties")
    @XmlElement(name = "property")
    protected List<MProperty> properties;

    public List<MProperty> getProperties() {
        if (properties == null) {
            properties = new ArrayList<MProperty>();
        }
        return properties;
    }

    public void setProperties(List<MProperty> properties) {
        this.properties = properties;
    }

}
