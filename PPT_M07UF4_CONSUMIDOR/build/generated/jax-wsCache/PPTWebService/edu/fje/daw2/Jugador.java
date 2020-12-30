
package edu.fje.daw2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jugador complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jugador">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="puntuacio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="tipusMoviment" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jugador", propOrder = {
    "nom",
    "puntuacio",
    "tipusMoviment"
})
public class Jugador {

    protected String nom;
    protected int puntuacio;
    protected int tipusMoviment;

    /**
     * Obtiene el valor de la propiedad nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Define el valor de la propiedad nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Obtiene el valor de la propiedad puntuacio.
     * 
     */
    public int getPuntuacio() {
        return puntuacio;
    }

    /**
     * Define el valor de la propiedad puntuacio.
     * 
     */
    public void setPuntuacio(int value) {
        this.puntuacio = value;
    }

    /**
     * Obtiene el valor de la propiedad tipusMoviment.
     * 
     */
    public int getTipusMoviment() {
        return tipusMoviment;
    }

    /**
     * Define el valor de la propiedad tipusMoviment.
     * 
     */
    public void setTipusMoviment(int value) {
        this.tipusMoviment = value;
    }

}
