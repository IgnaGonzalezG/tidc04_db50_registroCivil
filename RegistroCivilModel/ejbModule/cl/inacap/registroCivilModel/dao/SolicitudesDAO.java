package cl.inacap.registroCivilModel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.registroCivilModel.dto.Solicitud;

/**
 * Session Bean implementation class SolicitudesDAO
 */
@Stateless
@LocalBean
public class SolicitudesDAO implements SolicitudesDAOLocal {
	
	private static List<Solicitud> solicitudes = new ArrayList<>();

	@Override
	public void save(Solicitud solicitud) {
		solicitudes.add(solicitud);
		
		
	}

	@Override
	public List<Solicitud> getAll() {
		return solicitudes;
	}

	@Override
	public void delete(Solicitud solicitud) {
		solicitudes.remove(solicitud);
		
	}

	@Override
	public List<Solicitud> filterByName(String tipoSolicitud) {
		return solicitudes.stream().filter(s->s.getTipoSolicitud().contains(tipoSolicitud)).collect(Collectors.toList());
	}

}
