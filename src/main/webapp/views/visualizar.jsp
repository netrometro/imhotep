<%@include file="./includes/start.jsp" %>

<h1>Médicos Disponíveis</h1>
<h3>Hoje é Terça dia 01/04/2012</h3>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <table class="table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Médico</th>
                    <th>Especialização</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>Daniel Rodrigues</td>
                    <td>Cardilogista</td>
                    <td>Disponível</td>
                </tr>
                <tr class="table-active">
                    <td>1</td>
                    <td>Ananda Domingues</td>
                    <td>Pediatra</td>
                    <td>Disponível</td>
                </tr>
                <tr class="table-success">
                    <td>2</td>
                    <td>Abraham Oliwer</td>
                    <td>Geral</td>
                    <td>Disponível</td>
                </tr>
                <tr class="table-warning">
                    <td>3</td>
                    <td>Deborah Nunes</td>
                    <td>Odontologia</td>
                    <td>Disponível</td>
                </tr>
                <tr class="table-danger">
                    <td>4</td>
                    <td>Rodrigo Rodrigrues</td>
                    <td>Neurologista</td>
                    <td>Disponível</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="./includes/end.jsp" %>