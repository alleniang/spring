package sn.supinfo.springbootproject.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
  
@Entity
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String libelle;

    public int nbBureau;

    @OneToMany(mappedBy="departement")
    private Set<Employe> employes;

    // GETTERS
    public Long getId(){
        return this.id;
    }

    public String getLibelle(){
        return this.libelle;
    }

    public int getNbBureau(){
        return this.nbBureau;
    }

    public Set<Employe> getEmployes() {
        return employes;
    }

    // SETTERS
    public void setId(Long id){
        this.id = id; 
    }

    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
 
    public void setNbBureau(int nbBureau){
        this.nbBureau = nbBureau;
    }

    public void setEmployes(Set<Employe> employes) {
        this.employes = employes;
    }
}
