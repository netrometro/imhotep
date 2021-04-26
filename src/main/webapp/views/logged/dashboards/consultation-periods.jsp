<%@include file="/views/includes/start.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<title>Período de Consultas</title>
</head>
<body>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-6">
                <form action="consultation-periods.jsp" method="POST">
                    <div class="form-group">
                        <label for="form-input-sunday">Domingo</label>
                        <input type="text" class="form-control" id="form-input-sunday" placeholder="08:00-13:00" name="sunday"/>
                    </div>
                    <div class="form-group">
                        <label for="form-input-monday">Segunda</label>
                        <input type="text" class="form-control" id="form-input-monday" placeholder="08:00-12:00;13:00-18:00" name="monday"/>
                    </div>
                    <div class="form-group">
                        <label for="form-input-tuesday">Terça-Feira</label>
                        <input type="text" class="form-control" id="form-input-tuesday" placeholder="08:00-12:00;13:00-18:00" name="tuesday"/>
                    </div>
                    <div class="form-group">
                        <label for="form-input-wednesday">Quarta-Feira</label>
                        <input type="text" class="form-control" id="form-input-wednesday" placeholder="08:00-12:00;13:00-18:00" name="wednesday"/>
                    </div>
                    <div class="form-group">
                        <label for="form-input-thursday">Quinta-Feira</label>
                        <input type="text" class="form-control" id="form-input-thursday" placeholder="08:00-12:00;13:00-18:00" name="thursday"/>
                    </div>
                    <div class="form-group">
                        <label for="form-input-friday">Sexta-Feira</label>
                        <input type="text" class="form-control" id="form-input-friday" placeholder="08:00-12:00;13:00-18:00" name="friday"/>
                    </div>
                    <div class="form-group">
                        <label for="form-input-saturday">Sábado</label>
                        <input type="text" class="form-control" id="form-input-saturday" placeholder="08:00-12:00;13:00-18:00" name="saturday"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Salvar</button>
                </form>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>