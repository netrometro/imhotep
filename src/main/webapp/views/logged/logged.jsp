<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IMenu</title>
</head>
<body>
	<h1>Menu do Sistema</h1>
	<p>Olá ${sessionScope.usuarioLogado.nome}</p>
	<ul>
		<li><a href="${pageContext.request.contextPath}/logout.jsp">Sair</a>">Sair</a>
		</li>
	</ul>
</body>
</html>
