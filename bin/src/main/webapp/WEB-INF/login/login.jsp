<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-sm"></div>
			<div class="col-sm">
				<form action="<c:url value='/login' />" method="post">

					<!--|== Inicio - Mensaje error ======================|-->
					<c:if test="${error}">
						<div class="alert alert-warning alert-dismissible fade show"
							role="alert">
							<strong>¡Error!</strong> credenciales inválidas
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
					</c:if>

					<!--|== Fin - Mensaje error =========================|-->
					
					
					<!--| campo email |-->
					<div class="form-group">
						<label for="email">ingrese email</label> 
						<input
							id="email" name="email"
							type="email" 
							class="form-control" aria-describedby="emailHelp" /> 
					</div>
					<!--| campo email #|-->
					
					<!--| campo contrasenia |-->
					<div class="form-group">
						<label for="contrasenia">Password</label> 
						<input
							id="contrasenia" name="contrasenia"
							type="password" 
							class="form-control" />
					</div>
					<!--| campo contrasenia #|-->


					<a href="/admin" class="btn btn-primary btn-user btn-block">
						Login Admin </a> <a href="/usuario"
						class="btn btn-primary btn-user btn-block"> Login Usuario </a>
					<div
						class="form-group d-flex align-items-center justify-content-between mt-4 mb-0">
						<button class="btn btn-primary" type="submit">Ingresar</button>
					</div>

				</form>
				<!--|== Inicio - Enlace al registro ===============|-->
				<div class="card-footer text-center">
					<div class="small"></div>
				</div>
				<!--|== Fin - Enlace al registro ==================|-->
			</div>
			<div class="col-sm"></div>
		</div>
	</div>

	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
		integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
		crossorigin="anonymous">

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

</body>

</html>