<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de livro</title>
</head>
<body>

	<%@include file="menu.jsp"%>

	<fieldset>
		<legend>Formulário de cadastro de medico</legend>
		<form>
			<label>Livro</label> <input type="text" /> <label>nome</label> <input
				type="text" /> <label>CPF</label> <input type="text" /> <label>Valor</label>
			<input type="number" step="0.01" /> <label>Data de
				Nascimento</label> <input type="date" />
			<button>Cadastrar</button>
		</form>
	</fieldset>
</body>
</html>