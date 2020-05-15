/*
 *                    BioJava development code
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  If you do not have a copy,
 * see:
 *
 *      http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright for this code is held jointly by the individual
 * authors.  These should be listed in @author doc comments.
 *
 * For more information on the BioJava project and its aims,
 * or to join the biojava-l mailing list, visit the home page
 * at:
 *
 *      http://www.biojava.org/
 *
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2013.12.17 at 03:04:15 PM PST
//


package org.biojava.nbio.structure.validation;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Zscore" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="atoms" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="mean" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="mindiff" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="numobs" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="obsval" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="stdev" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "mog-bond-outlier")
public class MogBondOutlier {

	@XmlAttribute(name = "Zscore", required = true)
	protected BigDecimal zscore;
	@XmlAttribute(name = "atoms", required = true)
	@XmlSchemaType(name = "anySimpleType")
	protected String atoms;
	@XmlAttribute(name = "mean", required = true)
	protected BigDecimal mean;
	@XmlAttribute(name = "mindiff", required = true)
	protected BigDecimal mindiff;
	@XmlAttribute(name = "numobs", required = true)
	protected BigInteger numobs;
	@XmlAttribute(name = "obsval", required = true)
	protected BigDecimal obsval;
	@XmlAttribute(name = "stdev", required = true)
	protected BigDecimal stdev;

	/**
	 * Gets the value of the zscore property.
	 *
	 * @return
	 *     possible object is
	 *     {@link BigDecimal }
	 *
	 */
	public BigDecimal getZscore() {
		return zscore;
	}

	/**
	 * Sets the value of the zscore property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link BigDecimal }
	 *
	 */
	public void setZscore(BigDecimal value) {
		this.zscore = value;
	}

	/**
	 * Gets the value of the atoms property.
	 *
	 * @return
	 *     possible object is
	 *     {@link String }
	 *
	 */
	public String getAtoms() {
		return atoms;
	}

	/**
	 * Sets the value of the atoms property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link String }
	 *
	 */
	public void setAtoms(String value) {
		this.atoms = value;
	}

	/**
	 * Gets the value of the mean property.
	 *
	 * @return
	 *     possible object is
	 *     {@link BigDecimal }
	 *
	 */
	public BigDecimal getMean() {
		return mean;
	}

	/**
	 * Sets the value of the mean property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link BigDecimal }
	 *
	 */
	public void setMean(BigDecimal value) {
		this.mean = value;
	}

	/**
	 * Gets the value of the mindiff property.
	 *
	 * @return
	 *     possible object is
	 *     {@link BigDecimal }
	 *
	 */
	public BigDecimal getMindiff() {
		return mindiff;
	}

	/**
	 * Sets the value of the mindiff property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link BigDecimal }
	 *
	 */
	public void setMindiff(BigDecimal value) {
		this.mindiff = value;
	}

	/**
	 * Gets the value of the numobs property.
	 *
	 * @return
	 *     possible object is
	 *     {@link BigInteger }
	 *
	 */
	public BigInteger getNumobs() {
		return numobs;
	}

	/**
	 * Sets the value of the numobs property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link BigInteger }
	 *
	 */
	public void setNumobs(BigInteger value) {
		this.numobs = value;
	}

	/**
	 * Gets the value of the obsval property.
	 *
	 * @return
	 *     possible object is
	 *     {@link BigDecimal }
	 *
	 */
	public BigDecimal getObsval() {
		return obsval;
	}

	/**
	 * Sets the value of the obsval property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link BigDecimal }
	 *
	 */
	public void setObsval(BigDecimal value) {
		this.obsval = value;
	}

	/**
	 * Gets the value of the stdev property.
	 *
	 * @return
	 *     possible object is
	 *     {@link BigDecimal }
	 *
	 */
	public BigDecimal getStdev() {
		return stdev;
	}

	/**
	 * Sets the value of the stdev property.
	 *
	 * @param value
	 *     allowed object is
	 *     {@link BigDecimal }
	 *
	 */
	public void setStdev(BigDecimal value) {
		this.stdev = value;
	}

}