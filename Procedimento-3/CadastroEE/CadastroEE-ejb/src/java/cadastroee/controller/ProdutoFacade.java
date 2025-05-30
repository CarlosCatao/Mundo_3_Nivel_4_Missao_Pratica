/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastroee.controller;

import cadastroee.model.Produto;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ProdutoFacade extends AbstractFacade<Produto> implements ProdutoFacadeLocal {


    @PersistenceContext(unitName = "CadastroEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutoFacade() {
        super(Produto.class);
    }

    @Override
    public int getProximoId() {
    Integer maxId = (Integer) em.createQuery("SELECT MAX(p.codProduto) FROM Produto p").getSingleResult();
    return (maxId != null ? maxId + 1 : 1);
    }
   
    // Metodos com nomes em portugues
    
    @Override
    public void incluir(Produto produto) {
        produto.setCodProduto(getProximoId());
        create(produto);
    }

    @Override
    public void alterar(Produto produto) {
        edit(produto);
    }

    @Override
    public void excluir(int id) {
        Produto produto = find(id);
        if (produto != null) {
            remove(produto);
        }
    }

    @Override
    public Produto localizar(int id) {
        return find(id);
    }
}
