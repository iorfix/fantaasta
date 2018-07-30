
package org.fasta.dati.struct;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * <p>Java class for GiocatoreElaborazione complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GiocatoreElaborazione">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="nome" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="squadra" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="quotaorg" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="quotacap" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="quotafinale" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="ordine" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="random" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="posizioneAssegnazione" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GiocatoreElaborazione")
public class GiocatoreElaborazione implements Serializable
{

    private final static long serialVersionUID = 10001L;
    @XmlAttribute(name = "nome", required = true)
    protected String nome;
    @XmlAttribute(name = "squadra", required = true)
    protected String squadra;
    @XmlAttribute(name = "quotaorg", required = true)
    protected int quotaorg;
    @XmlAttribute(name = "quotacap", required = true)
    protected int quotacap;
    @XmlAttribute(name = "quotafinale", required = true)
    protected int quotafinale;
    @XmlAttribute(name = "ordine", required = true)
    protected int ordine;
    @XmlAttribute(name = "random", required = true)
    protected int random;
    @XmlAttribute(name = "posizioneAssegnazione", required = true)
    protected int posizioneAssegnazione;

    /**
     * Default no-arg constructor
     * 
     */
    public GiocatoreElaborazione() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public GiocatoreElaborazione(final String nome, final String squadra, final int quotaorg, final int quotacap, final int quotafinale, final int ordine, final int random, final int posizioneAssegnazione) {
        this.nome = nome;
        this.squadra = squadra;
        this.quotaorg = quotaorg;
        this.quotacap = quotacap;
        this.quotafinale = quotafinale;
        this.ordine = ordine;
        this.random = random;
        this.posizioneAssegnazione = posizioneAssegnazione;
    }

    /**
     * Gets the value of the nome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the value of the nome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
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
     * Gets the value of the quotaorg property.
     * 
     */
    public int getQuotaorg() {
        return quotaorg;
    }

    /**
     * Sets the value of the quotaorg property.
     * 
     */
    public void setQuotaorg(int value) {
        this.quotaorg = value;
    }

    /**
     * Gets the value of the quotacap property.
     * 
     */
    public int getQuotacap() {
        return quotacap;
    }

    /**
     * Sets the value of the quotacap property.
     * 
     */
    public void setQuotacap(int value) {
        this.quotacap = value;
    }

    /**
     * Gets the value of the quotafinale property.
     * 
     */
    public int getQuotafinale() {
        return quotafinale;
    }

    /**
     * Sets the value of the quotafinale property.
     * 
     */
    public void setQuotafinale(int value) {
        this.quotafinale = value;
    }

    /**
     * Gets the value of the ordine property.
     * 
     */
    public int getOrdine() {
        return ordine;
    }

    /**
     * Sets the value of the ordine property.
     * 
     */
    public void setOrdine(int value) {
        this.ordine = value;
    }

    /**
     * Gets the value of the random property.
     * 
     */
    public int getRandom() {
        return random;
    }

    /**
     * Sets the value of the random property.
     * 
     */
    public void setRandom(int value) {
        this.random = value;
    }

    /**
     * Gets the value of the posizioneAssegnazione property.
     * 
     */
    public int getPosizioneAssegnazione() {
        return posizioneAssegnazione;
    }

    /**
     * Sets the value of the posizioneAssegnazione property.
     * 
     */
    public void setPosizioneAssegnazione(int value) {
        this.posizioneAssegnazione = value;
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
