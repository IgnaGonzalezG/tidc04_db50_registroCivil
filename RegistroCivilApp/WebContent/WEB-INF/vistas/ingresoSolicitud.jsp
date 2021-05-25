<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>

<main class="container mt-10">
	<div class="columns is-centered mb-6">
		<div class="column is-6">


			<c:if test="${errores != null }">
				<div class="columns is-centered mb-6">
					<div class="colum is-6">
						<div class="notification is-info">
							<p>${mensaje}</p>

						</div>
					</div>

				</div>
			</c:if>
			<c:if test="${errores != null}">
				<div class="columns is-centered mb-6">
					<div class="column is-6">
						<div class="notification is-warning">
							<h6>Existen errores en el formulario</h6>
							<ul>
								<c:forEach var="error" items="${errores}">
									<li>${errores}</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</c:if>
			<div class="columns is-centered">
				<div class="column is-6">
					<form method="POST" action="IngresoSolicitudController.do">
						<div class="card"></div>
						<div class="card-header has-background-primary">
							<span class="card-header-title text-is-centered">Ingresar
								Solicitud de Atención</span>
						</div>
						<div class="card-content">
							<div class="field">
								<label class="label" for="rut-txt">Ingrese Rut </label>
								<div class="control">
									<input type="text" class="input" id="rut-txt" name="rut-txt" />
								</div>
							</div>

							<div class="field">
								<label class="label" for="nombre-txt">Ingrese Nombre y
									Apellido </label>
								<div class="control">
									<input type="text" class="input" id="nombre-txt"
										name="nombre-txt"
									/>
								</div>
							</div>
							<div class="field">
								<label class="label" for="tipo-atencion-select">Seleccione
									el tipo de Atención </label>
								<div class="control">
									<div class="select">
										<select name="tipo-atencion-select" id="tipo-atencion-select">
											<option>Solicitud de Cédula de Identidad</option>
											<option>Retiro de Cédula de Identidad</option>
											<option>Solicitud de Certificado de Nacimiento</option>
											<option>Solicitud de Certificado de Defunción</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<div class="card-footer has-text-centered">
							<div class="card-footer-item">
								<button type="submit" class="button is-info">Ingresar
									Solicitud</button>
							</div>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
</main>
</body>
</html>