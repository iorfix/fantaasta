
package org.fasta.dati.struct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="proposta" type="{http://dati.fasta.org/struct}Proposta" maxOccurs="10"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "proposta"
})
@XmlRootElement(name = "proposte")
public class Proposte implements Serializable
{

    private final static long serialVersionUID = 10001L;
    @XmlElement(required = true)
    protected List<Proposta> proposta;

    /**
     * Default no-arg constructor
     * 
     */
    public Proposte() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public Proposte(final List<Proposta> proposta) {
        this.proposta = proposta;
    }

    /**
     * Gets the value of the proposta property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the proposta property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProposta().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Proposta }
     * 
     * 
     */
    public List<Proposta> getProposta() {
        if (proposta == null) {
            proposta = new ArrayList<Proposta>();
        }
        return this.proposta;
    }

    /**
     * Sets the value of the proposta property.
     * 
     * @param proposta
     *     allowed object is
     *     {@link Proposta }
     *     
     */
    public void setProposta(List<Proposta> proposta) {
        this.proposta = proposta;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}
