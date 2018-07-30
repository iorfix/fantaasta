
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
 * <p>Java class for CreditiResiduiRuolo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditiResiduiRuolo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="squadra" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="crediti" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditiResiduiRuolo")
public class CreditiResiduiRuolo implements Serializable
{

    private final static long serialVersionUID = 10001L;
    @XmlAttribute(name = "squadra", required = true)
    protected String squadra;
    @XmlAttribute(name = "crediti", required = true)
    protected int crediti;

    /**
     * Default no-arg constructor
     * 
     */
    public CreditiResiduiRuolo() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public CreditiResiduiRuolo(final String squadra, final int crediti) {
        this.squadra = squadra;
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
     * Gets the value of the crediti property.
     * 
     */
    public int getCrediti() {
        return crediti;
    }

    /**
     * Sets the value of the crediti property.
     * 
     */
    public void setCrediti(int value) {
        this.crediti = value;
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
