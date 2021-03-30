<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">

<title>Lista de consultas disponíveis</title>
</head>
<body>
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

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
		crossorigin="anonymous"></script>


</body>
</html>
