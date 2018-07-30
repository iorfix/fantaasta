
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
 * <p>Java class for CreditiRuolo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreditiRuolo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="creditiIniziali" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="creditiRiportati" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="creditiResidui" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditiRuolo")
public class CreditiRuolo implements Serializable
{

    private final static long serialVersionUID = 10001L;
    @XmlAttribute(name = "creditiIniziali", required = true)
    protected int creditiIniziali;
    @XmlAttribute(name = "creditiRiportati", required = true)
    protected int creditiRiportati;
    @XmlAttribute(name = "creditiResidui", required = true)
    protected int creditiResidui;

    /**
     * Default no-arg constructor
     * 
     */
    public CreditiRuolo() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public CreditiRuolo(final int creditiIniziali, final int creditiRiportati, final int creditiResidui) {
        this.creditiIniziali = creditiIniziali;
        this.creditiRiportati = creditiRiportati;
        this.creditiResidui = creditiResidui;
    }

    /**
     * Gets the value of the creditiIniziali property.
     * 
     */
    public int getCreditiIniziali() {
        return creditiIniziali;
    }

    /**
     * Sets the value of the creditiIniziali property.
     * 
     */
    public void setCreditiIniziali(int value) {
        this.creditiIniziali = value;
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

    /**
     * Gets the value of the creditiResidui property.
     * 
     */
    public int getCreditiResidui() {
        return creditiResidui;
    }

    /**
     * Sets the value of the creditiResidui property.
     * 
     */
    public void setCreditiResidui(int value) {
        this.creditiResidui = value;
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
