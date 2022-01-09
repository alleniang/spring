package sn.supinfo.springbootproject.services;

import java.util.List;
import sn.supinfo.springbootproject.domain.Departement;


public interface DepartementService {
    void addDepartement(Departement departement);  
    void updateDepartement(Departement departement); 
    Departement getDepartementById(Long id);   
    void deleteDepartement(Long id);  
    List<Departement> getListDepartements();    
}
