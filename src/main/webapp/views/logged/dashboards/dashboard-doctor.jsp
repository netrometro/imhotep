<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<%@include file="../../includes/start.jsp" %>

<div class="container mt-5">
    <h1>Olá ${sessionScope.userlogged.name}</h1>
    <h3>Dashboard Doctor</h3>
</div>

<div class="container py-3">
    <fieldset>
        <legend>Formulário de cadastro de medico</legend>
        <form>
            <label>Livro</label>
            <input type="text"/>

            <label>nome</label>
            <input type="text"/>

            <label>CPF</label>
            <input type="text"/>

            <label>Valor</label>
            <input type="number" step="0.01"/>

            <label>Data de Nascimento</label>
            <input type="date"/>

            <button>Cadastrar</button>
        </form>
    </fieldset>


</div>

<%@include file="../../includes/end.jsp" %>


