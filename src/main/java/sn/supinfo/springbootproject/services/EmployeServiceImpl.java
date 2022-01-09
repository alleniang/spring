package sn.supinfo.springbootproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.supinfo.springbootproject.domain.Employe;
import sn.supinfo.springbootproject.repository.EmployeRepository;


@Service
public class EmployeServiceImpl implements EmployeService{

    @Autowired EmployeRepository employeRepository;
    @Override
    public void addEmploye(Employe employe) {
        // TODO Auto-generated method stub
        employeRepository.save(employe);
    }

    @Override
    public void updateEmploye(Employe employe) {
        // TODO Auto-generated method stub
        employeRepository.save(employe);
    }

    @Override
    public Employe getEmployeById(Long id) {
        // TODO Auto-generated method stub
        return employeRepository.getById(id);
    }

    @Override
    public void deleteEmploye(Long id) {
        // TODO Auto-generated method stub
        employeRepository.deleteById(id);
    }

    @Override
    public List<Employe> getListEmployes() {
        // TODO Auto-generated method stub
        return employeRepository.findAll();
    }

    @Override
    public List<Employe> searchEmployes(String search_str) {
        // TODO Auto-generated method stub
        return employeRepository.searchByPrenom(search_str);
    }
    
    
}
 