
package org.fasta.dati.struct;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for SetupRuolo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SetupRuolo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="squadra" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="proposta" type="{http://dati.fasta.org/struct}Propostaruolo"/>
 *         &lt;element name="creditiRiportati" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetupRuolo", propOrder = {
    "squadra",
    "proposta",
    "creditiRiportati"
})
public class SetupRuolo implements Serializable
{

    private final static long serialVersionUID = 10001L;
    @XmlElement(required = true)
    protected String squadra;
    @XmlElement(required = true)
    protected Propostaruolo proposta;
    protected int creditiRiportati;

    /**
     * Default no-arg constructor
     * 
     */
    public SetupRuolo() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public SetupRuolo(final String squadra, final Propostaruolo proposta, final int creditiRiportati) {
        this.squadra = squadra;
        this.proposta = proposta;
        this.creditiRiportati = creditiRiportati;
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
     * Gets the value of the proposta property.
     * 
     * @return
     *     possible object is
     *     {@link Propostaruolo }
     *     
     */
    public Propostaruolo getProposta() {
        return proposta;
    }

    /**
     * Sets the value of the proposta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Propostaruolo }
     *     
     */
    public void setProposta(Propostaruolo value) {
        this.proposta = value;
    }

    /**
     * Gets the value of the creditiRiportati property.
     * 
     */
    public int getCreditiRiportati() {
        return creditiRiportati;
    }

    /**
     * Sets the value of the creditiRiportati property.
     * 
     */
    public void setCreditiRiportati(int value) {
        this.creditiRiportati = value;
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
