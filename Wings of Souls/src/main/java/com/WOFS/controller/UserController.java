package com.WOFS.controller;

import com.WOFS.entity.User;
import com.WOFS.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //URL de acceso para este controlador
    @GetMapping("/listusers")
    public String users(Model model) {
        //Genera la lista de usuarios
        List<User> listaUsuarios = userService.listUsers();
        //Sustituye "titulo" por "Lista de usuarios"
        model.addAttribute("titulo", "Lista de usuarios");
        //Remplaza "usuarios" por el listado de usuarios
        model.addAttribute("usuarios", listaUsuarios);
        //Regresa al HTML llamado "consoles"
        return "users";
    }

    //URL de acceso para este controlador
    @GetMapping("/signin")
    public String signIn(Model model) {
        //Remplaza "usuario" por un nuevo usuario
        model.addAttribute("usuario", new User());
        //Regresa al HTML llamado "consoles"
        return "SignIn";
    }

    //URL para esto, usa PostMapping para guardar el elemento
    @PostMapping("/signinuser")
    //Se asegura que el objeto a guardar es un juego y que se hace mediante front end
    public String signInUser(@ModelAttribute User user) {
        try {
            String passEncriptado = bCryptPasswordEncoder.encode(user.getPassword());
            //Se asigna al usuario la contraseña encriptada
            user.setPassword(passEncriptado);
            user.setPermissions("ADMIN");
            user.setRoles("USER");
            user.setActive(1);
            //Guarda el objeto mediante el servicio
            userService.saveUser(user);
            //Redirecciona el HTML inicial
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/signinuser";
        }

    }

    //URL de acceso para este controlador
    @GetMapping("/createuser")
    public String createUser(Model model) {
        //Remplaza "usuario" por un nuevo usuario
        model.addAttribute("usuario", new User());
        //Regresa al HTML llamado "createUser"
        return "createUser";
    }

    //URL para esto, usa PostMapping para guardar el elemento
    @PostMapping("/saveuser")
    //Se asegura que el objeto a guardar es un juego y que se hace mediante front end
    public String saveUser(@ModelAttribute User user) {
        try {
            //Guarda el objeto mediante el servicio
            //Hace uso del BCryptPassword encoder para encriptar la contraseña
            //Toma la contraseña que tiene el objeto, la encripta con BCrypt
            //La guarda en un objeto String para poder transferirla
            String passEncriptado = bCryptPasswordEncoder.encode(user.getPassword());
            //Se asigna al usuario la contraseña encriptada
            user.setPassword(passEncriptado);
            //Se guarda el usuario
            userService.saveUser(user);
        } catch (Exception e) {
            
        }

        //Redirecciona el HTML inicial
        return "redirect:/listusers";
    }

    //URL de acceso, incluye el id que se está editando como parámetro
    @GetMapping("/editUser/{id}")
    //Sustituye automáticamente el elemento de la ruta por el id correspondiente
    public String editUser(@PathVariable("id") Long idUser, Model model) {
        //Crea una instancia del objeto con el ID del objeto seleecionado
        User user = userService.getUserById(idUser);
        //Remplaza "usuario" por la consola correspondiente
        model.addAttribute("usuario", user);
        //Regresa al HTML llamado "createUser"
        return "createUser";
    }

    //URL de acceso, incluye el id que se elimina como parámetro
    @GetMapping("/deleteUser/{id}")
    //Sustituye automáticamente el elemento de la ruta por el id correspondiente
    public String deleteUser(@PathVariable("id") Long idUser) {
        //Elimina el objeto correspondiente
        userService.deleteUser(idUser);
        //Redirecciona el HTML inicial
        return "redirect:/listusers";
    }

    @GetMapping("/admin")
    public String InicioAdmin() {
        return "indexAdmin";
    }

}
