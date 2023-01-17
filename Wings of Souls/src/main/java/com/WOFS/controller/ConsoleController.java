package com.WOFS.controller;

import com.WOFS.entity.Console;
import com.WOFS.service.IConsoleService;
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
public class ConsoleController {
    
    @Autowired
    private IConsoleService consoleService;
    
    //URL de acceso para este controlador
    @GetMapping("/listconsoles")
    public String consoles(Model model) {
        //Genera la lista de consolas
        List<Console> listaConsolas = consoleService.listConsoles();
        //Sustituye "titulo" por "Lista de consolas"
        model.addAttribute("titulo", "Lista de consolas");
        //Remplaza "consolas" por el listado de consolas
        model.addAttribute("consolas", listaConsolas);
        //Regresa al HTML llamado "consoles"
        return "consoles";
    }
    
    @GetMapping("/listconsolesadmin")
    public String consolesAdmin(Model model) {
        //Genera la lista de consolas
        List<Console> listaConsolas = consoleService.listConsoles();
        //Sustituye "titulo" por "Lista de consolas"
        model.addAttribute("titulo", "Lista de consolas");
        //Remplaza "consolas" por el listado de consolas
        model.addAttribute("consolas", listaConsolas);
        //Regresa al HTML llamado "consoles"
        return "consolesAdmin";
    }
    
    //URL de acceso para este controlador
    @GetMapping("/createconsole")
    public String createConsoles(Model model) {
        //Remplaza "consola" por una nueva consola
        model.addAttribute("consola", new Console());
        //Regresa al HTML llamado "createConsole"
        return "createConsole";
    }
    
    //URL para esto, usa PostMapping para guardar el elemento
    @PostMapping("/saveconsole")
    //Se asegura que el objeto a guardar es una consola y que se hace mediante front end
    public String saveConsole(@ModelAttribute Console console) {
        //Guarda el objeto mediante el servicio
        consoleService.saveConsole(console);
        //Redirecciona el HTML inicial
        return "redirect:/listconsolesadmin";
    }
    
    //URL de acceso, incluye el id que se está editando como parámetro
    @GetMapping("/editConsole/{id}")
    //Sustituye automáticamente el elemento de la ruta por el id correspondiente
    public String editConsole(@PathVariable("id") Long idConsole, Model model) {
        //Crea una instancia del objeto con el ID del objeto seleecionado
        Console console = consoleService.getConsoleById(idConsole);
        //Remplaza "consola" por la consola correspondiente
        model.addAttribute("consola", console);
        //Regresa al HTML llamado "createConsole"
        return "createConsole";
    }
    
    //URL de acceso, incluye el id que se elimina como parámetro
    @GetMapping("/deleteConsole/{id}")
    //Sustituye automáticamente el elemento de la ruta por el id correspondiente
    public String deleteConsole(@PathVariable("id") Long idConsole) {
        //Elimina el objeto correspondiente
        consoleService.deleteConsole(idConsole);
        //Redirecciona el HTML inicial
        return "redirect:/listconsolesadmin";
    }
}
