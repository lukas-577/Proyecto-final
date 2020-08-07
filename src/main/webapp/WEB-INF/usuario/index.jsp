<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mantenedor de usuarios</title>
<!-- bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<!-- bootstrap # -->

<!-- css - data table -->
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/dt/dt-1.10.21/datatables.min.css" />
<!-- css - data table # -->

</head>
<body>

	<div class="container">
		<div class="row my-5">
			<div class="col-2"></div>
			<div class="col-8">
				<!-- Formulario -->
				<div>

					<c:if test="${not empty mensaje}">
						<div class="alert alert-warning alert-dismissible fade show"
							role="alert">
							<strong>Información</strong> ${mensaje}
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>


					<h2>Sube tu Imagen</h2>
					<form id="formulario" action="<c:url value='/usuario'/>" method="post"
						enctype="multipart/form-data">
						
						<div class="form-group">
							<label for="marca">Nombre</label> <input id="nombre" name="nombre"
								type="text" class="form-control" />
						</div>

						<div class="form-group">
							<label for="modelo">Correo</label> <input id="email"
								name="email" type="email" class="form-control" />
						</div>

						<div class="form-group">
							<label for="anio">Contraseña</label> <input id="contrasenia" name="contrasenia"
								type="password" class="form-control" required="required" />
						</div>

						<div class="form-group">
							<label for="precio">Imágen</label> <input id="imagen"
								name="imagen" type="file" class="form-control" />
						</div>

						<button id="boton" type="submit" class="btn btn-primary">Guardar</button>
					</form>
				</div>

				<!-- Formulario # -->

			</div>
			<div class="col-2"></div>
		</div>
	</div>

	<!-- bootstrap -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<!-- bootstrap # -->

	<!-- javascript - data table -->
	<script type="text/javascript"
		src="https://cdn.datatables.net/v/dt/dt-1.10.21/datatables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#tablaAutos').DataTable();
		});
	</script>
	<!-- javascript - # data table -->
	
	

</body>
</html>