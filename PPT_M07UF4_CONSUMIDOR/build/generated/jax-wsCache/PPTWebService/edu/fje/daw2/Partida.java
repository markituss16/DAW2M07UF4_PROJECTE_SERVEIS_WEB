
package edu.fje.daw2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para partida complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="partida">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="jug2" type="{http://daw2/}jugador" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "partida", propOrder = {
    "id",
    "jug2"
})
public class Partida {

    protected int id;
    protected Jugador jug2;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad jug2.
     * 
     * @return
     *     possible object is
     *     {@link Jugador }
     *     
     */
    public Jugador getJug2() {
        return jug2;
    }

    /**
     * Define el valor de la propiedad jug2.
     * 
     * @param value
     *     allowed object is
     *     {@link Jugador }
     *     
     */
    public void setJug2(Jugador value) {
        this.jug2 = value;
    }

}
