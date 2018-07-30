
package org.fasta.dati.struct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for Propostaruolo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Propostaruolo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="giocatore" type="{http://dati.fasta.org/struct}PropostaGiocatore" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="crediti" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Propostaruolo", propOrder = {
    "giocatore"
})
public class Propostaruolo implements Serializable
{

    private final static long serialVersionUID = 10001L;
    @XmlElement(required = true)
    protected List<PropostaGiocatore> giocatore;
    @XmlAttribute(name = "crediti")
    protected Integer crediti;

    /**
     * Default no-arg constructor
     * 
     */
    public Propostaruolo() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public Propostaruolo(final List<PropostaGiocatore> giocatore, final Integer crediti) {
        this.giocatore = giocatore;
        this.crediti = crediti;
    }

    /**
     * Gets the value of the giocatore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the giocatore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGiocatore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PropostaGiocatore }
     * 
     * 
     */
    public List<PropostaGiocatore> getGiocatore() {
        if (giocatore == null) {
            giocatore = new ArrayList<PropostaGiocatore>();
        }
        return this.giocatore;
    }

    /**
     * Gets the value of the crediti property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCrediti() {
        return crediti;
    }

    /**
     * Sets the value of the crediti property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCrediti(Integer value) {
        this.crediti = value;
    }

    /**
     * Sets the value of the giocatore property.
     * 
     * @param giocatore
     *     allowed object is
     *     {@link PropostaGiocatore }
     *     
     */
    public void setGiocatore(List<PropostaGiocatore> giocatore) {
        this.giocatore = giocatore;
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
