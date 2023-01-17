package com.WOFS.controller;

import com.WOFS.entity.Petition;
import com.WOFS.service.IPetitionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Juan Carlos
 */

@Controller
public class PetitionController {
    
    @Autowired
    private IPetitionService petitionService;
  
    //URL de acceso para este controlador
    @GetMapping("/listpetitions")
    public String petitions(Model model) {
        //Genera la lista de consolas
        List<Petition> listaPeticiones = petitionService.listPetitions();
        //Sustituye "titulo" por "Lista de solicitudes"
        model.addAttribute("titulo", "Lista de solicitudes");
        //Remplaza "solicitudes" por el listado de solicitudes
        model.addAttribute("solicitudes", listaPeticiones);
        //Regresa al HTML llamado "petitions"
        return "petitions";
    }
    
    //URL de acceso para este controlador
    @GetMapping("/createpetition")
    public String createPetition(Model model) {
        //Remplaza "solicitud" por una nueva solicitud
        model.addAttribute("solicitud", new Petition());
        //Regresa al HTML llamado "createPetition"
        return "createPetition";
    }
    
    //URL para esto, usa PostMapping para guardar el elemento
    @PostMapping("/savepetition")
    //Se asegura que el objeto a guardar es un juego y que se hace mediante front end
    public String saveGame(@ModelAttribute Petition petition) {
        //Guarda el objeto mediante el servicio
        petitionService.savePetition(petition);
        //Redirecciona el HTML inicial
        return "redirect:/listpetitions";
    }
    
    //URL de acceso, incluye el id que se está editando como parámetro
    @GetMapping("/editPetition/{id}")
    //Sustituye automáticamente el elemento de la ruta por el id correspondiente
    public String editGame(@PathVariable("id") Long idPetition, Model model) {
        //Crea una instancia del objeto con el ID del objeto seleecionado
        Petition petition = petitionService.getPetitionById(idPetition);
        //Remplaza "solicitud" por la instancia correspondiente
        model.addAttribute("solicitud", petition);
        //Regresa al HTML llamado "createConsole"
        return "createPetition";
    }
    
    //URL de acceso, incluye el id que se elimina como parámetro
    @GetMapping("/deletePetition/{id}")
    //Sustituye automáticamente el elemento de la ruta por el id correspondiente
    public String deletePetition(@PathVariable("id") Long idPetition) {
        //Elimina el objeto correspondiente
        petitionService.deletePetition(idPetition);
        //Redirecciona el HTML inicial
        return "redirect:/listpetitions";
    }
}
