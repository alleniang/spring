package sn.supinfo.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sn.supinfo.springbootproject.domain.Departement;

@Repository
public interface DepartementRepository extends JpaRepository <Departement, Long> {
    
}
