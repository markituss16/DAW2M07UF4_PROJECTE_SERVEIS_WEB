
package edu.fje.daw2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para moureJugador complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="moureJugador">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipus" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codiPartida" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nomJugador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "moureJugador", propOrder = {
    "tipus",
    "codiPartida",
    "nomJugador"
})
public class MoureJugador {

    protected int tipus;
    protected int codiPartida;
    protected String nomJugador;

    /**
     * Obtiene el valor de la propiedad tipus.
     * 
     */
    public int getTipus() {
        return tipus;
    }

    /**
     * Define el valor de la propiedad tipus.
     * 
     */
    public void setTipus(int value) {
        this.tipus = value;
    }

    /**
     * Obtiene el valor de la propiedad codiPartida.
     * 
     */
    public int getCodiPartida() {
        return codiPartida;
    }

    /**
     * Define el valor de la propiedad codiPartida.
     * 
     */
    public void setCodiPartida(int value) {
        this.codiPartida = value;
    }

    /**
     * Obtiene el valor de la propiedad nomJugador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomJugador() {
        return nomJugador;
    }

    /**
     * Define el valor de la propiedad nomJugador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomJugador(String value) {
        this.nomJugador = value;
    }

}
