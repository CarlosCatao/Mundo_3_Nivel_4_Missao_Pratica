/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastroee.servlets;

import cadastroee.model.Produto;
import cadastroee.controller.ProdutoFacadeLocal;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.ejb.EJB;

@WebServlet(name = "ServletProdutoFC", urlPatterns = {"/ServletProdutoFC"})
public class ServletProdutoFC extends HttpServlet {

    @EJB(beanName = "ProdutoFacade")
    private ProdutoFacadeLocal facade;

    // GET usado para listar produtos
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        
         try {
            if ("carregar".equals(acao)) {
                int id = Integer.parseInt(request.getParameter("id"));
                Produto produto = facade.localizar(id);

                if (produto != null) {
                    request.setAttribute("produto", produto);
                    request.getRequestDispatcher("ProdutoDados.jsp").forward(request, response);
                } else {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Produto nao encontrado.");
                }
                return;
            }

            // Listar todos os produtos como padrao
            List<Produto> produtos = facade.findAll();
            request.setAttribute("listaProdutos", produtos);
            request.getRequestDispatcher("ProdutoLista.jsp").forward(request, response);

        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao carregar dados.");
        }   
    }
    
    // POST usado para incluir, alterar e excluir
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        try {
            if ("incluir".equals(acao) || "alterar".equals(acao)) {

                // Recebendo parametros
                String nome = request.getParameter("nome");
                String quantidadeStr = request.getParameter("quantidade");
                String precoStr = request.getParameter("preco").replace(',', '.');
                
                // Validacao
                if (nome == null || nome.trim().isEmpty() ||
                    quantidadeStr == null || quantidadeStr.trim().isEmpty() ||
                    precoStr == null || precoStr.trim().isEmpty()) {
                    throw new IllegalArgumentException("Todos os campos obrigatorios devem ser preenchidos.");
                }

                int quantidade = Integer.parseInt(quantidadeStr);
                float preco = Float.parseFloat(precoStr);

                Produto produto = new Produto();
                produto.setDescricao(nome);
                produto.setQuantidadeEstoque(quantidade);
                produto.setPrecoUnitarioAtual(preco);

                if ("alterar".equals(acao)) {
                    String idStr = request.getParameter("id");
                    int id = Integer.parseInt(idStr);
                    produto.setCodProduto(id);
                    facade.alterar(produto);
                } else {
                    facade.incluir(produto);
                }

            } else if ("excluir".equals(acao)) {
                String idStr = request.getParameter("id");
                int id = Integer.parseInt(idStr);
                facade.excluir(id);
            }

        // Redirecionar para listar apos acao
            response.sendRedirect("ServletProdutoFC");
    
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Formato de numero invalido.");
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro no processamento.");
        }
    }
}
