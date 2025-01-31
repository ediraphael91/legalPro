package uisrael.legalPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uisrael.legalPro.model.Plazo;

@Repository
public interface IPlazoRepository extends JpaRepository<Plazo, Integer> {

}
