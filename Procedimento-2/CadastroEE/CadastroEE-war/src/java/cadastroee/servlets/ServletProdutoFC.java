/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastroee.servlets;

import cadastroee.controller.ProdutoFacadeLocal;
import cadastroee.model.Produto;

import java.io.IOException;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/ServletProdutoFC"})
public class ServletProdutoFC extends HttpServlet {

    @EJB(beanName = "ProdutoFacade")
    private ProdutoFacadeLocal facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processarRequisicao(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processarRequisicao(request, response);
    }

    private void processarRequisicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String destino;

        switch (acao) {
            case "formIncluir":
            case "formAlterar":
                if ("formAlterar".equals(acao)) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    Produto produto = facade.find(id);
                    request.setAttribute("produto", produto);
                }
                destino = "ProdutoDados.jsp";
                break;

            case "listar":
                List<Produto> produtos = facade.findAll();
                request.setAttribute("produtos", produtos);
                destino = "ProdutoLista.jsp";
                break;

            case "excluir":
                int idExcluir = Integer.parseInt(request.getParameter("id"));
                Produto produtoExcluir = facade.find(idExcluir);
                facade.remove(produtoExcluir);
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
                break;

            case "alterar":
                int idAlterar = Integer.parseInt(request.getParameter("id"));
                Produto produtoAlterar = facade.find(idAlterar);
                produtoAlterar.setDescricao(request.getParameter("nome"));
                produtoAlterar.setQuantidadeEstoque(Integer.parseInt(request.getParameter("quantidade")));
                String precoTextoAlt = request.getParameter("preco").replace(",", ".");
                produtoAlterar.setPrecoUnitarioAtual(Float.parseFloat(precoTextoAlt));
                facade.edit(produtoAlterar);
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
                break;

            case "incluir":
                Produto novoProduto = new Produto();
                novoProduto.setCodProduto(facade.getProximoId());
                novoProduto.setDescricao(request.getParameter("nome"));
                novoProduto.setQuantidadeEstoque(Integer.parseInt(request.getParameter("quantidade")));
                String precoTextoIn = request.getParameter("preco").replace(",", ".");
                novoProduto.setPrecoUnitarioAtual(Float.parseFloat(precoTextoIn));
                facade.create(novoProduto);
                request.setAttribute("produtos", facade.findAll());
                destino = "ProdutoLista.jsp";
                break;

            default:
                destino = "ProdutoLista.jsp";
                request.setAttribute("produtos", facade.findAll());
                break;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(destino);
        dispatcher.forward(request, response);
    }
}
