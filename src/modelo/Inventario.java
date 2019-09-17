/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EMPRESA
 */
@Entity
@Table(name = "inventario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findById", query = "SELECT i FROM Inventario i WHERE i.id = :id"),
    @NamedQuery(name = "Inventario.findByFornecedor", query = "SELECT i FROM Inventario i WHERE i.fornecedor = :fornecedor"),
    @NamedQuery(name = "Inventario.findByNome", query = "SELECT i FROM Inventario i WHERE i.nome = :nome"),
    @NamedQuery(name = "Inventario.findByQuant", query = "SELECT i FROM Inventario i WHERE i.quant = :quant"),
    @NamedQuery(name = "Inventario.findByValor", query = "SELECT i FROM Inventario i WHERE i.valor = :valor")})
public class Inventario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fornecedor")
    private String fornecedor;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "quant")
    private int quant;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;

    public Inventario() {
    }

    public Inventario(Integer id) {
        this.id = id;
    }

    public Inventario(Integer id, String fornecedor, String nome, int quant, double valor) {
        this.id = id;
        this.fornecedor = fornecedor;
        this.nome = nome;
        this.quant = quant;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Inventario[ id=" + id + " ]";
    }
    
}
