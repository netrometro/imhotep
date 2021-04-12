<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<title>Cadastro</title>
</head>
<body>

	<%@include file="forms/menu.jsp"%>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <form action="registration" method="POST">
                    <div class="form-group">
                    <label for="inputEmail1">Endereço de email</label>
                    <input name="email" type="email" class="form-control" id="inputEmail1" aria-describedby="emailHelp" placeholder="Seu email">
                    <small id="emailHelp" class="form-text text-muted">Nunca vamos compartilhar seu email, com ninguém.</small>
                    </div>
                    <div class="form-group">
                        <label for="name">Nome Completo</label>
                        <input name="name" type="text" class="form-control" id="name" placeholder="Seu nome completo">
                    </div>
                    <div class="form-group">
                        <label for="cpf">CPF</label>
                        <input name="cpf" type="text" class="form-control" id="cpf" placeholder="Seu CPF">
                    </div>
                    <div class="form-group">
                        <label for="client-type">Tipo de usuário</label>
                        <div class="form-check" id="client-type">
                            <input name="user_type" class="form-check-input" type="radio" name="flexRadioDefault" id="medico" checked>
                            <label class="form-check-label" for="flexRadioDefault1">
                                Médico
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="cpf">CRM</label>
                        <input name="crm" type="text" class="form-control" id="cpf" placeholder="Seu CRM">
                    </div>
                    <div class="form-group">
                        <label for="birthday">Data de Nascimento</label>
                        <input name="birthday" type="date" class="form-control" id="birthday">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Senha</label>
                        <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Senha">
                    </div>
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </form>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>