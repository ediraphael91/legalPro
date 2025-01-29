package uisrael.legalPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uisrael.legalPro.model.Caso;

public interface ICasoRepository extends JpaRepository<Caso, Integer> {

}
