package sn.supinfo.springbootproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sn.supinfo.springbootproject.domain.Departement;
import sn.supinfo.springbootproject.services.DepartementServiceImpl;

@Controller 
public class DepartementController {
     
    @Autowired DepartementServiceImpl departementServiceImpl;

    @GetMapping("/")
	public String index() {
        return "index";    
	}

    @GetMapping("/departements")
	public String getDepartements(@RequestParam(name = "fragment", defaultValue = "") String fragment, Model model) {
        model.addAttribute("liste_departements", departementServiceImpl.getListDepartements()); 
        if(fragment!=null && !fragment.equals("")) {
            return "departements :: "+fragment;
        }
        else { 
            return "departements";
        }  
	}

       
    //@RequestMapping(path = {"/edit", "/edit/{id}"})
    @GetMapping("/departement/edit/")
	public String editDepartement(Model model, @RequestParam(name = "id", defaultValue="0") Long id) {
        Departement departement = new Departement();
        if (id != null && id>0) {
            departement = departementServiceImpl.getDepartementById(id);
        } 
        model.addAttribute("form", departement);
        return "departement_edit";
	}
      
    @PostMapping("/departement/edit/")
	public String editDepartement_post(@Valid @ModelAttribute("form") Departement departement, Model model) {	
		try {
			if(departement.getId() != null){
                departementServiceImpl.addDepartement(departement);
				model.addAttribute("successMsg", "Paramétre modifié !");
            }
            else{
                departementServiceImpl.updateDepartement(departement);
				model.addAttribute("successMsg", "Paramétre enregistré");
            }
		} catch (Exception e) {
			model.addAttribute("errorMsg", "Opération échouée !");
			e.printStackTrace();
		}
		//return "departements";
        return "redirect:/departements";
	}


    @GetMapping("/departement/view/")
	public String viewDepartement(Model model, @RequestParam(name = "id", defaultValue="0") Long id) {
        Departement departement = new Departement();
        if (id != null && id>0) {
            departement = departementServiceImpl.getDepartementById(id);
        } 
        model.addAttribute("form", departement);
        return "departement_view";   
	}

    @GetMapping("/departement/del")
	public String deleteDepartement(@RequestParam("id") Long id) {
		try {
			departementServiceImpl.deleteDepartement(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/departements/";
	}

}


