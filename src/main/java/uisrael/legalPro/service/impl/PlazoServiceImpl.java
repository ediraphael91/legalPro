package uisrael.legalPro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uisrael.legalPro.model.Plazo;
import uisrael.legalPro.repository.IPlazoRepository;
import uisrael.legalPro.service.IPlazoService;

import java.util.List;
import java.util.Optional;

@Service
public class PlazoServiceImpl implements IPlazoService{
	
	@Autowired
    private IPlazoRepository plazoRepository;

    @Override
    public List<Plazo> getAllPlazos() {
        return plazoRepository.findAll();
    }

    @Override
    public Optional<Plazo> getPlazoById(int id) {
        return plazoRepository.findById(id);
    }

    @Override
    public Plazo savePlazo(Plazo plazo) {
        return plazoRepository.save(plazo);
    }

    @Override
    public void deletePlazo(int id) {
        plazoRepository.deleteById(id);
    }

    @Override
    public List<Plazo> getPlazosByCriticidad(String criticidad) {
        return plazoRepository.findAll().stream()
                .filter(plazo -> plazo.getCriticidad().name().equalsIgnoreCase(criticidad))
                .toList();
    }

}
