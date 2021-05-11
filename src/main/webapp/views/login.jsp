<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <%@include file="includes/links-css.jsp" %>
</head>
<body class="sign-in-js">
<div class="container-fluid">
    <div class="content first-content">
        <div class="first-column">
            <h2 class="title title-primary">Welcome back</h2>
            <p class="description description-primary">To keep connected with us </p>
            <p class="description description-primary">please login with your personal info</p>
            <button id="signin" class="btn btn-primary">sign in</button>
        </div>
        <div class="second-column">
            <h2 class="title title-second">Create account</h2>
            <form class="form" action="registration" method="POST">
                <label for="name" class="label-input">
                    <i class="fas fa-user"></i>
                    <input name="name" type="text" class="form-control" id="name" placeholder="Seu nome completo">
                </label>
                <label for="cpf" class="label-input">
                    <i class="fas fa-id-card"></i>
                    <input name="cpf" type="text" class="form-control cpf-mask" id="cpf" placeholder="CPF"
                           maxlength="14">
                </label>
                <label for="client-type" class="label-input">Tipo de usuário</label>
                <div class="form-group form-user">
                    <div class="form-check" id="client-type">
                        <input class="form-check-input" type="checkbox" name="check-doctor" id="check-doctor"
                               onclick="ShowHideDiv(this)">
                        <label class="form-check-label">
                            Médico
                        </label>
                    </div>
                    <div class="form-check" id="client-type2">
                        <input class="form-check-input" type="checkbox" name="check-employee" id="check-employee"
                               onclick="ShowHideDiv2(this)">
                        <label class="form-check-label">
                            Funcionário
                        </label>
                    </div>
                </div>
                <div id="crm" style="display: none">
                    <label for="crm" class="label-input">
                        <i class="fas fa-id-card"></i>
                        <input name="crm" type="text" class="form-control cep-mask" placeholder="CRM" maxlength="10">
                    </label>
                    <label for="specialties" class="label-input">
                        <i class="fas fa-id-card"></i>
                        <input name="specialties" type="text" class="form-control" placeholder="Especialidades" />
                    </label>
                </div>
                <label for="birthday" class="label-input">
                    <i class="far fa-calendar-alt" for="birthday"></i>
                    <input name="birthday" type="date" class="form-control" id="birthday"
                           placeholder="Data de nascimento">
                </label>

                <label for="inputEmail1" class="label-input">
                    <i class="far fa-envelope"></i>
                    <input name="email" type="email" class="form-control" id="inputEmail1" aria-describedby="emailHelp"
                           placeholder="Seu email">
                </label>

                <label for="exampleInputPassword1" class="label-input">
                    <i class="fas fa-lock"></i>
                    <input name="password" type="password" class="form-control" id="exampleInputPassword1"
                           placeholder="Senha">
                </label>
                <button class="btn btn-second"> sign up</button>
                <p class="description description-second">Nunca vamos compartilhar seu email, com ninguém.</p>
            </form>
        </div>
    </div>
    <div class="content second-content">
        <div class="first-column">
            <h2 class="title title-primary">hello, friend</h2>
            <p class="description description-primary">Entre your personal details </p>
            <p class="description description-primary">and start journey with us</p>
            <button id="signup" class="btn btn-primary">sign up</button>
        </div>
        <div class="second-column">
            <img alt="logo" src="<%= request.getContextPath()%>/resources/img/logo.png" style="width: 30px">
            <h2 class="title title-second">Sign in</h2>
            <form class="form" method="post" action="login.jsp">
                <label class="label-input">
                    <i class="fas fa-id-card"></i>
                    <input type="text" class="form-control" placeholder="cpf or crm"
                           name="login" value="${param.login}"/>
                </label>
                <label for="exampleInputPassword1" class="label-input">
                    <i class="fas fa-lock"></i>
                    <input name="password" type="password" class="form-control" placeholder="password">
                </label>
                <div class="form-check" id="rememberMe">
                    <input name="user_type" class="form-check-input" type="checkbox" name="flexRadioDefault">
                    <label class="form-check-label">
                        Remember Me
                    </label>
                </div>
                <button type="submit" class="btn btn-second">sign in</button>
            </form>
            </br>
            <a href="#" class="a a-esqueceu"> Esqueceu sua senha?</a>
        </div>
    </div>
</div>
<%@include file="includes/scripts-js.jsp" %>
</body>
</html>
