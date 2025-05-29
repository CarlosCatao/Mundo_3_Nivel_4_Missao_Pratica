<%-- 
    Document   : ProdutoLista.jsp
    Created on : 28 de mai. de 2025, 10:10:06
    Author     : Carlos Altomare Catao
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="cadastroee.model.Produto" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Produtos</title>
</head>
<body>
    <h1>Listagem de Produtos</h1>

<!-- Link para inclusão -->
<a href="ServletProdutoFC?acao=formIncluir">Novo Produto</a>

<br><br>

<!-- Tabela de produtos -->
<table border="0" cellpadding="10">
    <tr>
        <th>#</th>
        <th>Nome</th>
        <th>Quantidade</th>
        <th>Preço de Venda</th>
        <th>Opções</th>
    </tr>
    
    <%
        List<Produto> lista = (List<Produto>) request.getAttribute("produtos");
        if (lista != null) {
            for (Produto produto : lista) {
    %>
    <tr>
        <td><%= produto.getCodProduto() %></td>
        <td><%= produto.getDescricao() %></td>
        <td><%= produto.getQuantidadeEstoque() %></td>
        <td><%= produto.getPrecoUnitarioAtual() %></td>
        <td>
                <a href="ServletProdutoFC?acao=formAlterar&id=<%= produto.getCodProduto() %>">Alterar</a> |
                <a href="ServletProdutoFC?acao=excluir&id=<%= produto.getCodProduto() %>"onclick="return confirm('Confirma exclusão?')">Excluir</a>
        </td>
    </tr>
    
    <%
            }
        } else {
    %>
    <tr><td colspan="5">Nenhum produto encontrado.</td></tr>
    <%
        }
    %>
</table>

</body>
</html>
