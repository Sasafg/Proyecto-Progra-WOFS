package com.WOFS.controller;

import com.WOFS.entity.Console;
import com.WOFS.entity.Game;
import com.WOFS.service.IConsoleService;
import com.WOFS.service.IGameService;
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
public class GameController {
    
    @Autowired 
    private IGameService gameService;
    
    @Autowired
    private IConsoleService consoleService;
    
    //URL de acceso para este controlador
    @GetMapping("/listgames")
    public String games(Model model) {
        //Genera la lista de juegos
        List<Game> listaJuegos = gameService.listGames();
        //Sustituye "titulo" por "Lista de juegos"
        model.addAttribute("titulo", "Lista de juegos");
        //Remplaza "juegos" por el listado de juegos
        model.addAttribute("juegos", listaJuegos);
        //Regresa al HTML llamado "games"
        return "games";
    }
    
    //URL de acceso para este controlador
    @GetMapping("/listgamesadmin")
    public String gamesAdmin(Model model) {
        //Genera la lista de juegos
        List<Game> listaJuegos = gameService.listGames();
        //Sustituye "titulo" por "Lista de juegos"
        model.addAttribute("titulo", "Lista de juegos");
        //Remplaza "juegos" por el listado de juegos
        model.addAttribute("juegos", listaJuegos);
        //Regresa al HTML llamado "games"
        return "gamesAdmin";
    }
   
    //URL de acceso para este controlador
    @GetMapping("/creategame")
    public String createGame(Model model) {
        //Crea una lista de consolas para la asociación
        List<Console> listaConsolas = consoleService.listConsoles();
        //Remplaza "juego" por un nuevo juego
        model.addAttribute("juego", new Game());
        //Sustituye "consolas" por el listado para poder seleccionarlo
        model.addAttribute("consolas", listaConsolas);
        //Regresa al HTML llamado "createGame"
        return "createGame";
    }
    
    //URL para esto, usa PostMapping para guardar el elemento
    @PostMapping("/savegame")
    //Se asegura que el objeto a guardar es un juego y que se hace mediante front end
    public String saveGame(@ModelAttribute Game game) {
        //Guarda el objeto mediante el servicio
        gameService.saveGame(game);
        //Redirecciona el HTML inicial
        return "redirect:/listgamesadmin";
    }
    
    //URL de acceso, incluye el id que se está editando como parámetro
    @GetMapping("/editGame/{id}")
    //Sustituye automáticamente el elemento de la ruta por el id correspondiente
    public String editGame(@PathVariable("id") Long idGame, Model model) {
        //Crea una instancia del objeto con el ID del objeto seleecionado
        Game game = gameService.getGameeById(idGame);
        //Crea una lista de consolas para la asociación
        List<Console> listaConsolas = consoleService.listConsoles();
        //Remplaza "juego" por la instancia correspondiente
        model.addAttribute("juego", game);
        //Sustituye "consolas" por el listado para poder seleccionarlo
        model.addAttribute("consolas", listaConsolas);
        //Regresa al HTML llamado "createConsole"
        return "createGame";
    }
    
    //URL de acceso, incluye el id que se elimina como parámetro
    @GetMapping("/deleteGame/{id}")
    //Sustituye automáticamente el elemento de la ruta por el id correspondiente
    public String deleteGame(@PathVariable("id") Long idGame) {
        //Elimina el objeto correspondiente
        gameService.deleteGame(idGame);
        //Redirecciona el HTML inicial
        return "redirect:/listgamesadmin";
    }
}
