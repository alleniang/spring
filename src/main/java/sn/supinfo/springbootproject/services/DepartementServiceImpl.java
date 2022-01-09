package sn.supinfo.springbootproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.supinfo.springbootproject.domain.Departement;
import sn.supinfo.springbootproject.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements DepartementService{

    @Autowired DepartementRepository departementRepository;
    @Override
    public void addDepartement(Departement departement) {
        // TODO Auto-generated method stub
        this.departementRepository.save(departement);
        
    }

    @Override
    public void updateDepartement(Departement departement) {
        // TODO Auto-generated method stub
        this.departementRepository.save(departement);
    }

    @Override 
    public Departement getDepartementById(Long id) {
        // TODO Auto-generated method stub
        return this.departementRepository.getById(id);
    }

    @Override
    public void deleteDepartement(Long id) {
        // TODO Auto-generated method stub
        this.departementRepository.deleteById(id);
    }

    @Override
    public List<Departement> getListDepartements() {
        // TODO Auto-generated method stub
        return departementRepository.findAll();
    }
    
}
