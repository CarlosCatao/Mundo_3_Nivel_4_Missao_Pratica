/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastroee.controller;

import cadastroee.model.Pessoa;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author carlo
 */
@Local
public interface PessoaFacadeLocal {

    void create(Pessoa pessoa);

    void edit(Pessoa pessoa);

    void remove(Pessoa pessoa);

    Pessoa find(Object id);

    List<Pessoa> findAll();

    List<Pessoa> findRange(int[] range);

    int count();
    
}
