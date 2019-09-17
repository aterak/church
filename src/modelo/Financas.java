/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EMPRESA
 */
@Entity
@Table(name = "finacas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finacas.findAll", query = "SELECT f FROM Finacas f"),
    @NamedQuery(name = "Finacas.findById", query = "SELECT f FROM Finacas f WHERE f.id = :id"),
    @NamedQuery(name = "Finacas.findByNome", query = "SELECT f FROM Finacas f WHERE f.nome = :nome"),
    @NamedQuery(name = "Finacas.findByData", query = "SELECT f FROM Finacas f WHERE f.data = :data"),
    @NamedQuery(name = "Finacas.findByValor", query = "SELECT f FROM Finacas f WHERE f.valor = :valor"),
    @NamedQuery(name = "Finacas.findByDescricao", query = "SELECT f FROM Finacas f WHERE f.descricao = :descricao")})
public class Financas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;

    public Financas() {
    }

    public Financas(Integer id) {
        this.id = id;
    }

    public Financas(Integer id, String nome, Date data, double valor, String descricao) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof Financas)) {
            return false;
        }
        Financas other = (Financas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Finacas[ id=" + id + " ]";
    }
    
}
