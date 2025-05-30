/*
 * Desenvolvedor Full Stack
 * Carlos Altomare Catao
 * matricula: 20240346.0912
 * EAD - Polo Santa Luiza - Vitoria - ES
 */

package cadastroee.servlets;

import cadastroee.controller.ProdutoFacadeLocal;
import cadastroee.model.Produto;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ServletProduto", urlPatterns = {"/ServletProduto"})
public class ServletProduto extends HttpServlet {

    @EJB
    ProdutoFacadeLocal facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Configura o tipo de conteudo da resposta
        response.setContentType("text/html;charset=UTF-8");

        // Recuperar a lista de produtos usando o facade
        List<Produto> produtos = facade.findAll();

        // Escrever a resposta como uma lista HTML
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de Produtos</title>");
            out.println("<style>");
            out.println("table { border-collapse: collapse; width: 80%; margin: auto; }");
            out.println("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
            out.println("th { background-color: #f2f2f2; }");
            out.println("body { font-family: Arial, sans-serif; padding: 20px; }");
            out.println("h1 { text-align: center; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Produtos</h1>");

            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Codigo</th>");
            out.println("<th>Descricao</th>");
            out.println("<th>Quantidade em Estoque</th>");
            out.println("<th>Preço Unitario Atual</th>");
            out.println("</tr>");

            for (Produto p : produtos) {
                out.println("<tr>");
                out.println("<td>" + p.getCodProduto() + "</td>");
                out.println("<td>" + p.getDescricao() + "</td>");
                out.println("<td>" + p.getQuantidadeEstoque() + "</td>");
                out.println("<td>R$ " + String.format("%.2f", p.getPrecoUnitarioAtual()) + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
