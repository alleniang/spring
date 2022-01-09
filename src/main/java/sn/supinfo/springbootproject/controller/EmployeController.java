package sn.supinfo.springbootproject.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import groovyjarjarantlr4.v4.parse.ANTLRParser.id_return;
import sn.supinfo.springbootproject.domain.Employe;
import sn.supinfo.springbootproject.services.DepartementServiceImpl;
import sn.supinfo.springbootproject.services.EmployeServiceImpl;

@Controller
public class EmployeController {
      
    @Autowired EmployeServiceImpl employeServiceImpl;
    @Autowired DepartementServiceImpl departementServiceImpl;

    @GetMapping("/employes")
	public String getEmployes(@RequestParam(name = "search", defaultValue = "") String searchKey, Model model) {

        List<Employe> listeEmploye;

        if (searchKey != null && !searchKey.equals("")) {
            System.err.println("\n\n\nemploye search "+searchKey);
            listeEmploye = employeServiceImpl.searchEmployes("%"+searchKey+"%");
        }else {
            listeEmploye = employeServiceImpl.getListEmployes();
        }
        
        model.addAttribute("employes", listeEmploye);
        return "employes";
	}
      
    @GetMapping("/employe/edit/")
	public String editEmploye(Model model, @RequestParam(name = "id", defaultValue="0") Long id) {
        Employe employe = new Employe();
        if(id!=null && id>0){
            employe =  employeServiceImpl.getEmployeById(id);
        }
        model.addAttribute("form", employe);
        model.addAttribute("departements", departementServiceImpl.getListDepartements());
        return "employe_edit";
	} 

    @PostMapping("/employe/edit/")
	public String editEmploye_post(@Valid @ModelAttribute("form") Employe employe,Model model) {	
		try {
			if(employe.getId() != null){
                employeServiceImpl.addEmploye(employe);
				model.addAttribute("successMsg", "Employé modifié !");
            }
            else{
                employeServiceImpl.addEmploye(employe);
				model.addAttribute("successMsg", "Employé enregistré");
            }
		} catch (Exception e) {
			model.addAttribute("errorMsg", "Opération échouée !");
			e.printStackTrace();
		}
		//return "employes";
        return "redirect:/employes";
	}

    @GetMapping("/employe/view/")
	public String viewEmploye(Model model, @RequestParam(name = "id", defaultValue="0") Long id) {
        Employe employe = new Employe();
        if(id!=null && id>0){
            employe =  employeServiceImpl.getEmployeById(id);
        }
        model.addAttribute("form", employe);
        return "employe_view";
	} 

    @GetMapping("/employe/del")
	public String deleteEmploye(@RequestParam("id") Long id) {
		try {
			employeServiceImpl.deleteEmploye(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/employes/";

        
	}
}


