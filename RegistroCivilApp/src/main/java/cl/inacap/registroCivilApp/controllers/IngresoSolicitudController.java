package cl.inacap.registroCivilApp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.registroCivilModel.dao.SolicitudesDAOLocal;
import cl.inacap.registroCivilModel.dto.Solicitud;




/**
 * Servlet implementation class IngresoSolicitudController
 */
@WebServlet("/IngresoSolicitudController.do")
public class IngresoSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private SolicitudesDAOLocal solicitudesDAO;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IngresoSolicitudController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/vistas/ingresoSolicitud.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<String> errores = new ArrayList<>();
		AtomicInteger numSolicitud = new AtomicInteger();
		numSolicitud.getAndAdd(1);
		
		String rut = request.getParameter("rut-txt").trim();
		if (rut.isEmpty()) {
			errores.add("Debe ingresar un rut válido");
		} else {
			
			boolean rutValido = false;
		    try {
		        rut =  rut.toUpperCase();
		        rut = rut.replace(".", "");
		        rut = rut.replace("-", "");
		        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

		        char dv = rut.charAt(rut.length() - 1);

		        int m = 0, s = 1;
		        for (; rutAux != 0; rutAux /= 10) {
		            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
		        }
		        if (dv == (char) (s != 0 ? s + 47 : 75)) {
		        	rutValido = true;
		        }

		    } catch (java.lang.NumberFormatException e) {
		    } catch (Exception e) {
		    	};
			
		}
		
		
		String nombre = request.getParameter("nombre-txt").trim();
		if (nombre.isEmpty()) {
			errores.add("Debe ingresar nombre y apellido");
		}
		
		String tipoSolicitud = request.getParameter("tipo-atencion-select").trim();
		if (tipoSolicitud.isEmpty()) {
			errores.add("Debe seleccionar el tipo de atención");
		}
		
		if (errores.isEmpty()) {
			request.setAttribute("mensaje", "Solicitud ingresada existosamente");
			
			
			Solicitud solicitud = new Solicitud();
			int aux = numSolicitud.get();;
			solicitud.setRut(rut);
			solicitud.setNombre(nombre);
			solicitud.setTipoSolicitud(tipoSolicitud);
			solicitud.setNumeroSolicitud(aux);
			solicitudesDAO.save(solicitud);
			
			request.getRequestDispatcher("WEB-INF/vistas/atenderSolicitud.jsp").forward(request, response);
			
		} else {
			request.setAttribute("errores", errores);
		}
		
		
		doGet(request, response);
	}

}
