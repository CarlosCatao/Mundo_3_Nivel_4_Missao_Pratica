/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastroee.controller;

import cadastroee.model.PessoaJuridica;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author carlo
 */
@Stateless
public class PessoaJuridicaFacade extends AbstractFacade<PessoaJuridica> implements PessoaJuridicaFacadeLocal {

    @PersistenceContext(unitName = "CadastroEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PessoaJuridicaFacade() {
        super(PessoaJuridica.class);
    }
    
}
