<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>

<main class="container mt-6">
	<div class="columns is-centered">
		<div class="column is-8">
			<table class="table is-hovered is-bordered">
				<thead class=has-background-info>
					<tr>
						<th>Rut Cliente</th>
						<th>Nombre Cliente</th>
						<th>Tipo de Atención</th>
						<th>Numero de Solicitud</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="solicitudes" items="${solicitudes}">
					<tr>
						<td>${solicitudes.rut}</td>
						<td>${solicitudes.nombre}</td>
						<td>${solicitudes.tipoSolicitud}</td>
						<td>${solicitudes.numeroSolicitud}</td>
					</tr>
					</c:forEach>
				</tbody>


			</table>
		</div>
	</div>
</main>