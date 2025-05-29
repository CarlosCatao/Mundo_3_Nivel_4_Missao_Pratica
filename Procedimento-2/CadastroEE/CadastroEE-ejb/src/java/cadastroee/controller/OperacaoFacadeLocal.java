/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastroee.controller;

import cadastroee.model.Operacao;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author carlo
 */
@Local
public interface OperacaoFacadeLocal {

    void create(Operacao operacao);

    void edit(Operacao operacao);

    void remove(Operacao operacao);

    Operacao find(Object id);

    List<Operacao> findAll();

    List<Operacao> findRange(int[] range);

    int count();
    
}
