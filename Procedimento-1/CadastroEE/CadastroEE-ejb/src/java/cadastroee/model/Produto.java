/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastroee.model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author carlo
 */
@Entity
@Table(name = "Produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByCodProduto", query = "SELECT p FROM Produto p WHERE p.codProduto = :codProduto"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByQuantidadeEstoque", query = "SELECT p FROM Produto p WHERE p.quantidadeEstoque = :quantidadeEstoque"),
    @NamedQuery(name = "Produto.findByPrecoUnitarioAtual", query = "SELECT p FROM Produto p WHERE p.precoUnitarioAtual = :precoUnitarioAtual")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_produto")
    private Integer codProduto;
    @Size(max = 30)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "quantidade_estoque")
    private Integer quantidadeEstoque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco_unitario_atual")
    private Float precoUnitarioAtual;
    @ManyToMany(mappedBy = "produtoCollection")
    private Collection<Pessoa> pessoaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codProduto")
    private Collection<Operacao> operacaoCollection;

    public Produto() {
    }

    public Produto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public Integer getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(Integer codProduto) {
        this.codProduto = codProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Float getPrecoUnitarioAtual() {
        return precoUnitarioAtual;
    }

    public void setPrecoUnitarioAtual(Float precoUnitarioAtual) {
        this.precoUnitarioAtual = precoUnitarioAtual;
    }

    @XmlTransient
    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    @XmlTransient
    public Collection<Operacao> getOperacaoCollection() {
        return operacaoCollection;
    }

    public void setOperacaoCollection(Collection<Operacao> operacaoCollection) {
        this.operacaoCollection = operacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProduto != null ? codProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codProduto == null && other.codProduto != null) || (this.codProduto != null && !this.codProduto.equals(other.codProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroee.model.Produto[ codProduto=" + codProduto + " ]";
    }
    
}
