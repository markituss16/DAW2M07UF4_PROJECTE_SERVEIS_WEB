
package edu.fje.daw2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para acabarJoc complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="acabarJoc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codiPartida" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "acabarJoc", propOrder = {
    "codiPartida"
})
public class AcabarJoc {

    protected int codiPartida;

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

}
