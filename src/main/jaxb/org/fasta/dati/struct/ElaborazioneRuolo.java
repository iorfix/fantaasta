
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
 * <p>Java class for ElaborazioneRuolo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ElaborazioneRuolo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="squadra" type="{http://dati.fasta.org/struct}SquadraRuoloElaborazione" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElaborazioneRuolo", propOrder = {
    "squadra"
})
public class ElaborazioneRuolo implements Serializable
{

    private final static long serialVersionUID = 10001L;
    @XmlElement(required = true)
    protected List<SquadraRuoloElaborazione> squadra;

    /**
     * Default no-arg constructor
     * 
     */
    public ElaborazioneRuolo() {
        super();
    }

    /**
     * Fully-initialising value constructor
     * 
     */
    public ElaborazioneRuolo(final List<SquadraRuoloElaborazione> squadra) {
        this.squadra = squadra;
    }

    /**
     * Gets the value of the squadra property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the squadra property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSquadra().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SquadraRuoloElaborazione }
     * 
     * 
     */
    public List<SquadraRuoloElaborazione> getSquadra() {
        if (squadra == null) {
            squadra = new ArrayList<SquadraRuoloElaborazione>();
        }
        return this.squadra;
    }

    /**
     * Sets the value of the squadra property.
     * 
     * @param squadra
     *     allowed object is
     *     {@link SquadraRuoloElaborazione }
     *     
     */
    public void setSquadra(List<SquadraRuoloElaborazione> squadra) {
        this.squadra = squadra;
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
