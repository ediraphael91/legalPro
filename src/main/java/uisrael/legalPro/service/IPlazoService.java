package uisrael.legalPro.service;

import java.util.List;
import java.util.Optional;

import uisrael.legalPro.model.Plazo;

public interface IPlazoService {
	
	List<Plazo> getAllPlazos();

    Optional<Plazo> getPlazoById(int idPlazo);

    Plazo savePlazo(Plazo plazo);

    void deletePlazo(int idPlazo);

    List<Plazo> getPlazosByCriticidad(String criticidad);

}
