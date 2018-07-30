
package org.fasta.dati.struct;

import java.io.Serializable;
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
 * <p>Java class for Proposta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Proposta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="portieri" type="{http://dati.fasta.org/struct}Propostaruolo"/>
 *         &lt;element name="difensori" type="{http://dati.fasta.org/struct}Propostaruolo" minOccurs="0"/>
 *         &lt;element name="centrocampisti" type="{http://dati.fasta.org/struct}Propostaruolo" minOccurs="0"/>
 *         &lt;element name="attaccanti" type="{http://dati.fasta.org/struct}Propostaruolo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="squadra" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="riversacrediti" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Proposta", propOrder = {
    "portieri",
    "difensori",
    "centrocampisti",
    "attaccanti"
})
public class Proposta implements Serializable
{

    private final static long serialVersionUID = 10001L;
    @XmlElement(required = true)
    protected Propostaruolo portieri;
    protected Propostaruolo difensori;
    protected Propostaruolo centrocampisti;
    protected Propostaruolo attaccanti;
    @XmlAttribute(name = "squadra")
    protected String squadra;
    @XmlAttribute(name = "riversacrediti")
    protected Boolean riversacrediti;

    /**
     * Default no-arg constructor
     * 
     */
    public Proposta() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public Proposta(final Propostaruolo portieri, final Propostaruolo difensori, final Propostaruolo centrocampisti, final Propostaruolo attaccanti, final String squadra, final Boolean riversacrediti) {
        this.portieri = portieri;
        this.difensori = difensori;
        this.centrocampisti = centrocampisti;
        this.attaccanti = attaccanti;
        this.squadra = squadra;
        this.riversacrediti = riversacrediti;
    }

    /**
     * Gets the value of the portieri property.
     * 
     * @return
     *     possible object is
     *     {@link Propostaruolo }
     *     
     */
    public Propostaruolo getPortieri() {
        return portieri;
    }

    /**
     * Sets the value of the portieri property.
     * 
     * @param value
     *     allowed object is
     *     {@link Propostaruolo }
     *     
     */
    public void setPortieri(Propostaruolo value) {
        this.portieri = value;
    }

    /**
     * Gets the value of the difensori property.
     * 
     * @return
     *     possible object is
     *     {@link Propostaruolo }
     *     
     */
    public Propostaruolo getDifensori() {
        return difensori;
    }

    /**
     * Sets the value of the difensori property.
     * 
     * @param value
     *     allowed object is
     *     {@link Propostaruolo }
     *     
     */
    public void setDifensori(Propostaruolo value) {
        this.difensori = value;
    }

    /**
     * Gets the value of the centrocampisti property.
     * 
     * @return
     *     possible object is
     *     {@link Propostaruolo }
     *     
     */
    public Propostaruolo getCentrocampisti() {
        return centrocampisti;
    }

    /**
     * Sets the value of the centrocampisti property.
     * 
     * @param value
     *     allowed object is
     *     {@link Propostaruolo }
     *     
     */
    public void setCentrocampisti(Propostaruolo value) {
        this.centrocampisti = value;
    }

    /**
     * Gets the value of the attaccanti property.
     * 
     * @return
     *     possible object is
     *     {@link Propostaruolo }
     *     
     */
    public Propostaruolo getAttaccanti() {
        return attaccanti;
    }

    /**
     * Sets the value of the attaccanti property.
     * 
     * @param value
     *     allowed object is
     *     {@link Propostaruolo }
     *     
     */
    public void setAttaccanti(Propostaruolo value) {
        this.attaccanti = value;
    }

    /**
     * Gets the value of the squadra property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSquadra() {
        return squadra;
    }

    /**
     * Sets the value of the squadra property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSquadra(String value) {
        this.squadra = value;
    }

    /**
     * Gets the value of the riversacrediti property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRiversacrediti() {
        return riversacrediti;
    }

    /**
     * Sets the value of the riversacrediti property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRiversacrediti(Boolean value) {
        this.riversacrediti = value;
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
