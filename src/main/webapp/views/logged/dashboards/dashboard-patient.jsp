<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<%@include file="../../includes/start.jsp" %>

<div class="container mt-5">
    <h1>Olá ${sessionScope.userlogged.name}</h1>
    <h3>Dashboard Patient</h3>
</div>

<%@include file="../../includes/end.jsp" %>

