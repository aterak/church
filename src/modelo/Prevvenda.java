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
@Table(name = "prevvenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findById", query = "SELECT v FROM Venda v WHERE v.id = :id"),
    @NamedQuery(name = "Venda.findByDataVenda", query = "SELECT v FROM Venda v WHERE v.dataVenda = :dataVenda"),
    @NamedQuery(name = "Venda.findByNotaFiscal", query = "SELECT v FROM Venda v WHERE v.notaFiscal = :notaFiscal"),
    @NamedQuery(name = "Venda.findByPrevCliente", query = "SELECT v FROM Venda v WHERE v.prevCliente = :prevCliente"),
    @NamedQuery(name = "Venda.findByPrevProduto", query = "SELECT v FROM Venda v WHERE v.prevProduto = :prevProduto"),
    @NamedQuery(name = "Venda.findByPrevVendedor", query = "SELECT v FROM Venda v WHERE v.prevVendedor = :prevVendedor"),
    @NamedQuery(name = "Venda.findByQuantidade", query = "SELECT v FROM Venda v WHERE v.quantidade = :quantidade"),
    @NamedQuery(name = "Venda.findByTotalPrev", query = "SELECT v FROM Venda v WHERE v.totalPrev = :totalPrev"),
    @NamedQuery(name = "Venda.findByTroco", query = "SELECT v FROM Venda v WHERE v.troco = :troco"),
    @NamedQuery(name = "Venda.findByValorPago", query = "SELECT v FROM Venda v WHERE v.valorPago = :valorPago"),
    @NamedQuery(name = "Venda.findByValorTotal", query = "SELECT v FROM Venda v WHERE v.valorTotal = :valorTotal"),
    @NamedQuery(name = "Venda.findByValorvendaProdutoprevV", query = "SELECT v FROM Venda v WHERE v.valorvendaProdutoprevV = :valorvendaProdutoprevV")})
public class Prevvenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data_venda")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVenda;
    @Column(name = "nota_fiscal")
    private Integer notaFiscal;
    @Column(name = "prevCliente")
    private String prevCliente;
    @Column(name = "prevProduto")
    private String prevProduto;
    @Column(name = "prevVendedor")
    private String prevVendedor;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalPrev")
    private Double totalPrev;
    @Column(name = "troco")
    private Double troco;
    @Column(name = "valor_pago")
    private Double valorPago;
    @Column(name = "valor_total")
    private Double valorTotal;
    @Column(name = "valor_venda_Produto_prevV")
    private Double valorvendaProdutoprevV;

    public Prevvenda() {
    }

    public Prevvenda(Integer id) {
        this.id = id;
    }

    public Prevvenda(Integer id, Date dataVenda) {
        this.id = id;
        this.dataVenda = dataVenda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Integer getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(Integer notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public String getPrevCliente() {
        return prevCliente;
    }

    public void setPrevCliente(String prevCliente) {
        this.prevCliente = prevCliente;
    }

    public String getPrevProduto() {
        return prevProduto;
    }

    public void setPrevProduto(String prevProduto) {
        this.prevProduto = prevProduto;
    }

    public String getPrevVendedor() {
        return prevVendedor;
    }

    public void setPrevVendedor(String prevVendedor) {
        this.prevVendedor = prevVendedor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotalPrev() {
        return totalPrev;
    }

    public void setTotalPrev(Double totalPrev) {
        this.totalPrev = totalPrev;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) {
        this.troco = troco;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorvendaProdutoprevV() {
        return valorvendaProdutoprevV;
    }

    public void setValorvendaProdutoprevV(Double valorvendaProdutoprevV) {
        this.valorvendaProdutoprevV = valorvendaProdutoprevV;
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
        if (!(object instanceof Prevvenda)) {
            return false;
        }
        Prevvenda other = (Prevvenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Venda[ id=" + id + " ]";
    }
    
}
