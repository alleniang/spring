package sn.supinfo.springbootproject.repository;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sn.supinfo.springbootproject.domain.Employe;

@Repository
public interface EmployeRepository extends JpaRepository <Employe, Long> {
 
    @Query("select emp from Employe emp WHERE emp.matricule LIKE :x or emp.prenom LIKE :x or emp.nom LIKE :x or emp.email LIKE :x or emp.adresse LIKE :x or emp.telephone LIKE :x")
	List<Employe> searchByPrenom(@Param("x") String search);
}
 