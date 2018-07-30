
package org.fasta.dati.struct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for SquadraRuoloElaborazione complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SquadraRuoloElaborazione">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="squadra" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="papabile" type="{http://dati.fasta.org/struct}GiocatoreElaborazione" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="assegnato" type="{http://dati.fasta.org/struct}GiocatoreElaborazione" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="crediti" type="{http://dati.fasta.org/struct}CreditiRuolo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SquadraRuoloElaborazione", propOrder = {
    "squadra",
    "papabile",
    "assegnato",
    "crediti"
})
public class SquadraRuoloElaborazione implements Serializable
{

    private final static long serialVersionUID = 10001L;
    @XmlElement(required = true)
    protected String squadra;
    protected List<GiocatoreElaborazione> papabile;
    protected List<GiocatoreElaborazione> assegnato;
    @XmlElement(required = true)
    protected CreditiRuolo crediti;

    /**
     * Default no-arg constructor
     * 
     */
    public SquadraRuoloElaborazione() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public SquadraRuoloElaborazione(final String squadra, final List<GiocatoreElaborazione> papabile, final List<GiocatoreElaborazione> assegnato, final CreditiRuolo crediti) {
        this.squadra = squadra;
        this.papabile = papabile;
        this.assegnato = assegnato;
        this.crediti = crediti;
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
     * Gets the value of the papabile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the papabile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPapabile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GiocatoreElaborazione }
     * 
     * 
     */
    public List<GiocatoreElaborazione> getPapabile() {
        if (papabile == null) {
            papabile = new ArrayList<GiocatoreElaborazione>();
        }
        return this.papabile;
    }

    /**
     * Gets the value of the assegnato property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assegnato property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssegnato().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GiocatoreElaborazione }
     * 
     * 
     */
    public List<GiocatoreElaborazione> getAssegnato() {
        if (assegnato == null) {
            assegnato = new ArrayList<GiocatoreElaborazione>();
        }
        return this.assegnato;
    }

    /**
     * Gets the value of the crediti property.
     * 
     * @return
     *     possible object is
     *     {@link CreditiRuolo }
     *     
     */
    public CreditiRuolo getCrediti() {
        return crediti;
    }

    /**
     * Sets the value of the crediti property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditiRuolo }
     *     
     */
    public void setCrediti(CreditiRuolo value) {
        this.crediti = value;
    }

    /**
     * Sets the value of the papabile property.
     * 
     * @param papabile
     *     allowed object is
     *     {@link GiocatoreElaborazione }
     *     
     */
    public void setPapabile(List<GiocatoreElaborazione> papabile) {
        this.papabile = papabile;
    }

    /**
     * Sets the value of the assegnato property.
     * 
     * @param assegnato
     *     allowed object is
     *     {@link GiocatoreElaborazione }
     *     
     */
    public void setAssegnato(List<GiocatoreElaborazione> assegnato) {
        this.assegnato = assegnato;
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
