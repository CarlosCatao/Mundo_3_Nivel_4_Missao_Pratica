<%-- 
    Document   : ProdutoLista.jsp
    Created on : 28 de mai. de 2025, 10:10:06
    Author     : Carlos Altomare Catao
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="cadastroee.model.Produto" %>
<%@ page import="java.text.DecimalFormat" %>

<%
    List<Produto> produtos = (List<Produto>) request.getAttribute("listaProdutos");
%>

<%
    DecimalFormat df = new DecimalFormat("#0.00");
%>

<!DOCTYPE html>
<html>
<head>
    
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
    
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Bootstrap JavaScript Bundle (com Popper) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    
</head>
<body class="container">
    
    <h1 class="mt-4">Listagem de Produtos</h1>

    <a href="ProdutoDados.jsp" class="btn btn-primary m-2">Novo Produto</a>

    <table class="table table-striped">
        <thead class="table-dark">
            <tr>
                <th>#</th>
                <th>Nome</th>
                <th>Quantidade</th>
                <th>Preço de Venda</th>
                <th>Opções</th>
            </tr>
        </thead>
        <tbody>

         <%
                if (produtos != null) {
                    for (Produto p : produtos) {
            %>
            <tr>
                <td><%= p.getCodProduto() %></td>
                <td><%= p.getDescricao() %></td>
                <td><%= p.getQuantidadeEstoque() %></td>
                <td>R$ <%= df.format(p.getPrecoUnitarioAtual()) %></td>
                <td>
                    
                    <!-- Botao Alterar -->
                    <a href="ServletProdutoFC?acao=carregar&id=<%= p.getCodProduto() %>" class="btn btn-primary btn-sm">Alterar</a>
                    
                    <!-- Botao Excluir com confirmacao -->
                    <form action="ServletProdutoFC" method="post" style="display:inline;" onsubmit="return confirm('Deseja realmente excluir este produto?');">
                        <input type="hidden" name="acao" value="excluir">
                        <input type="hidden" name="id" value="<%= p.getCodProduto() %>">
                        <button type="submit" class="btn btn-danger btn-sm">Excluir</button>
                    </form>
                
                </td>
            </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>   
    
</body>
</html>
