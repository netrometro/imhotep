<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <%@include file="/views/includes/links-css.jsp" %>

    <title>Período de Consultas</title>
</head>
<body>
<%@include file="/views/includes/navbar.jsp" %>
<main>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <form action="consultation-periods.jsp" method="POST">
                    <div class="form-group">
                        <label for="form-input-date">Data</label>
                        <input type="date" class="form-control" id="form-input-date" placeholder="08:00-13:00" name="date"/>
                    </div>
                    <div class="form-group">
                        <label for="form-input-period">Periodo</label>
                        <input type="text" class="form-control" id="form-input-period" placeholder="08:00-13:00" name="period"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Salvar</button>
                </form>
            </div>
        </div>
    </div>
</main>
<%@include file="/views/includes/footer.jsp" %>
<%@include file="/views/includes/scripts-js.jsp" %>
<%@include file="/views/includes/scripts-js.jsp" %>
</body>
</html>