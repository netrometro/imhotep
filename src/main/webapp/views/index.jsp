<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Início</title>
    <%@include file="includes/links-css.jsp" %>
</head>
<body>
<%@include file="includes/navbar.jsp" %>
    <main>
            <div class="home-infos">
                <div class="home-info-info">
                    <h3>Imhotep</h3>
                    <p>Encontre médicos e agende consultas em poucos cliques!</p>
                </div>
                <div class="home-info-img">
                    <img src="<%= request.getContextPath()%>/resources/img/doctor1.svg" alt="">
                </div>
            </div>
            <div class="home-info-txt">
                <h2>
                    Está cansado de burocracia? Atendimneto ruim? Preços abusivos?
                </h2>
                <p>Então vem pra Imhotep!</p>
            </div>
            <div class="home-infos">
                <div class="home-info-img">
                    <img src="<%= request.getContextPath()%>/resources/img/doctor3.svg" alt="">
                </div>
                <div class="home-info-info">
                    <h3>Vaiedades de especialidades</h3>
                    <p>Encontre médicos das mais variadas especialidades possíveis</p>
                </div>
            </div>
            <div class="home-info-txt">
                <h2>
                    Está gostando?
                </h2>
                <p>Então recomende para seus amigos!</p>
            </div>
            <div class="home-infos">
                <div class="home-info-info">
                    <h3>Melhor preço</h3>
                    <p>Aqui há um imensa quantidade de opções, sendo assim a concorrencia que dita o preço por aqui!</p>
                </div>
                <div class="home-info-img">
                    <img src="<%= request.getContextPath()%>/resources/img/doctor2.svg" alt="">
                </div>
            </div>
    </main>
<%@include file="includes/footer.jsp" %>
<%@include file="includes/scripts-js.jsp" %>
<%@include file="includes/scripts-js.jsp" %>
</body>
</html>
