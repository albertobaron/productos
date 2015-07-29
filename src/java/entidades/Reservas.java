/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alberto
 */
@Entity
@Table(name = "reservas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r"),
    @NamedQuery(name = "Reservas.findByIdReserva", query = "SELECT r FROM Reservas r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "Reservas.findByCantidad", query = "SELECT r FROM Reservas r WHERE r.cantidad = :cantidad"),
    @NamedQuery(name = "Reservas.findByFecha", query = "SELECT r FROM Reservas r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "Reservas.findByNombreComprador", query = "SELECT r FROM Reservas r WHERE r.nombreComprador = :nombreComprador"),
    @NamedQuery(name = "Reservas.findByDniComprador", query = "SELECT r FROM Reservas r WHERE r.dniComprador = :dniComprador"),
    @NamedQuery(name = "Reservas.findByTelefonoComprador", query = "SELECT r FROM Reservas r WHERE r.telefonoComprador = :telefonoComprador"),
    @NamedQuery(name = "Reservas.findByPrecioTotal", query = "SELECT r FROM Reservas r WHERE r.precioTotal = :precioTotal"),
    @NamedQuery(name = "Reservas.findByDireccion", query = "SELECT r FROM Reservas r WHERE r.direccion = :direccion")})
public class Reservas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_reserva")
    private String idReserva;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "nombre_comprador")
    private String nombreComprador;
    @Column(name = "dni_comprador")
    private String dniComprador;
    @Column(name = "telefono_comprador")
    private Integer telefonoComprador;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_total")
    private BigDecimal precioTotal;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Productos idProducto;

    public Reservas() {
    }

    public Reservas(String idReserva) {
        this.idReserva = idReserva;
    }

    public Reservas(String idReserva, String nombreComprador, String direccion) {
        this.idReserva = idReserva;
        this.nombreComprador = nombreComprador;
        this.direccion = direccion;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public String getDniComprador() {
        return dniComprador;
    }

    public void setDniComprador(String dniComprador) {
        this.dniComprador = dniComprador;
    }

    public Integer getTelefonoComprador() {
        return telefonoComprador;
    }

    public void setTelefonoComprador(Integer telefonoComprador) {
        this.telefonoComprador = telefonoComprador;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "productos.Reservas[ idReserva=" + idReserva + " ]";
    }
    
}
