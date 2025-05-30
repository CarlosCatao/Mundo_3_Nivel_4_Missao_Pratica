<%-- 
    Document   : ProdutoDados.jsp
    Created on : 28 de mai. de 2025, 10:10:55
    Author     : Carlos Altomare Catao
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="cadastroee.model.Produto" %>

<%
    Produto produto = (Produto) request.getAttribute("produto");
    String acao = (produto == null) ? "incluir" : "alterar";

    String nome = (produto != null) ? produto.getDescricao() : "";
    String quantidade = (produto != null) ? String.valueOf(produto.getQuantidadeEstoque()) : "";
    String preco = (produto != null) ? String.format("%.2f", produto.getPrecoUnitarioAtual()).replace('.', ',') : "";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dados do Produto</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body class="container">

    <h1 class="mt-4">Dados do Produto</h1>

    <form action="ServletProdutoFC" method="post" class="form" onsubmit="return confirmarAcao();">

        <input type="hidden" name="acao" value="<%= acao %>">

        <% if (produto != null) { %>
            <input type="hidden" name="id" value="<%= produto.getCodProduto() %>">
        <% } %>

        <div class="mb-3">
            <label class="form-label">Nome:</label>
            <input type="text" name="nome" class="form-control" value="<%= nome %>" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Quantidade:</label>
            <input type="number" name="quantidade" class="form-control" value="<%= quantidade %>" required min="1">
        </div>

        <div class="mb-3">
            <label class="form-label">Preço de Venda:</label>
            <input type="text" name="preco" class="form-control" 
                   value="<%= preco %>" 
                   required pattern="^\d+([,]\d{1,2})?$" 
                   title="Digite um valor decimal com vírgula. Ex: 99,99">
        </div>

        <button type="submit" class="btn btn-primary">
            <%= (acao.equals("incluir") ? "Adicionar Produto" : "Alterar Produto") %>
        </button>
        <a href="ServletProdutoFC" class="btn btn-secondary">Voltar</a>
    </form>

<script>
    function confirmarAcao() {
        const acao = document.querySelector('input[name="acao"]').value;
        const mensagem = (acao === 'incluir') 
            ? "Deseja realmente incluir este produto?"
            : "Deseja realmente alterar este produto?";
        return confirm(mensagem);
    }
</script>

</body>
</html>
