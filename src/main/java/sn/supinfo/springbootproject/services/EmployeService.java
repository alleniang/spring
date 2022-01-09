package sn.supinfo.springbootproject.services;
import java.util.List;
import sn.supinfo.springbootproject.domain.Employe;


public interface EmployeService {
    void addEmploye(Employe employe);  
    void updateEmploye(Employe employe); 
    Employe getEmployeById(Long id);   
    void deleteEmploye(Long id);   
    List<Employe> getListEmployes(); 
    List<Employe> searchEmployes(String search_str);     
}
 