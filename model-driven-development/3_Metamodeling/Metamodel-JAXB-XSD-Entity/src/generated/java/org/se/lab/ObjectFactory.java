
package org.se.lab;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.se.lab package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Entity_QNAME = new QName("", "entity");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.se.lab
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MEntity }
     * 
     */
    public MEntity createMEntity() {
        return new MEntity();
    }

    /**
     * Create an instance of {@link MProperty }
     * 
     */
    public MProperty createMProperty() {
        return new MProperty();
    }

    /**
     * Create an instance of {@link MType }
     * 
     */
    public MType createMType() {
        return new MType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "entity")
    public JAXBElement<MEntity> createEntity(MEntity value) {
        return new JAXBElement<MEntity>(_Entity_QNAME, MEntity.class, null, value);
    }

}
