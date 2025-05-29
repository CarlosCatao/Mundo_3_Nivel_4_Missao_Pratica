<%-- 
    Document   : ProdutoDados.jsp
    Created on : 28 de mai. de 2025, 10:10:55
    Author     : Carlos Altomare Catao
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="cadastroee.model.Produto" %>
<%@ page import="java.text.DecimalFormat" %>

<%
    Produto produto = (Produto) request.getAttribute("produto");
    String acao = (produto == null) ? "incluir" : "alterar";
    
    String precoFormatado = "";
    if (produto != null) {
        DecimalFormat df = new DecimalFormat("0.00");
        precoFormatado = df.format(produto.getPrecoUnitarioAtual());
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dados do Produto</title>
</head>

<body>
    <h1>Dados do Produto</h1>

    <form action="ServletProdutoFC" method="post">
        
        <!-- acao (incluir ou alterar) -->
        <input type="hidden" name="acao" value="<%= acao %>">

        <!-- solicita o cod_produto, somente se for alteracao -->
        <% if (produto != null) { %>
            <input type="hidden" name="id" value="<%= produto.getCodProduto() %>">
        <% } %>
        
        <!-- campos de entrada -->
        Nome (*):
        <input type="text" name="nome" value="<%= (produto != null ? produto.getDescricao() : "") %>" required> &nbsp;

        Quantidade (*):
        <input type="number" name="quantidade" value="<%= (produto != null ? produto.getQuantidadeEstoque() : "") %>" required min="1"> &nbsp;

        Preço de Venda (*):
        <input type="text" name="preco"
               value="<%= (produto != null ? precoFormatado : "") %>"
                required
                pattern="^\d+(\.\d{1,2})?$"
                title="Digite um valor decimal com ponto. Ex: 99.99"> &nbsp;
        
        <br><br>
        
        <input type="submit" value="<%= (acao.equals("incluir") ? "Adicionar Produto" : "Alterar Produto") %>">
    </form>
    
    <p>* Campos obrigatorios</p>
        
</body>
</html>

