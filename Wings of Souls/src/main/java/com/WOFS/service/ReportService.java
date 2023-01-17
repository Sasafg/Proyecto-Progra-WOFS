package com.WOFS.service;

import com.WOFS.entity.Console;
import com.WOFS.entity.Game;
import com.WOFS.entity.Petition;
import com.WOFS.entity.User;
import com.WOFS.repository.ConsoleRepository;
import com.WOFS.repository.GameRepository;
import com.WOFS.repository.PetitionRepository;
import com.WOFS.repository.UserRepository;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

/**
 *
 * @author Juan Carlos
 */
@Service
public class ReportService {
    
    @Autowired
    private ConsoleRepository consoleRepository;
    
    @Autowired
    private GameRepository gameRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PetitionRepository petitionRepository;
    
    public String generarConsola() throws FileNotFoundException, JRException{
        String ruta = "D:\\WOFS\\";
        List<Console> consolas = (List<Console>) consoleRepository.findAll();
        //Carga el jrxml y lo compila
        File archivo = ResourceUtils.getFile("classpath:consolas.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(archivo.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(consolas);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Creado por ", "Juan C Molina");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, ruta + "Consolas.pdf");
        return "redirect:/listconsolesadmin";
    }
    
    public String generarJuego() throws FileNotFoundException, JRException{
        String ruta = "D:\\WOFS\\";
        List<Game> juegos = (List<Game>) gameRepository.findAll();
        //Carga el jrxml y lo compila
        File archivo = ResourceUtils.getFile("classpath:juegos.jrxml");
        //Compila el archivo
        JasperReport jasperReport = JasperCompileManager.compileReport(archivo.getAbsolutePath());
        //Define el origen de datos
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(juegos);
        //Parametros adicionales
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Creado por ", "Juan C Molina");
        //Imprime el archivo
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        //Define el formato
        JasperExportManager.exportReportToPdfFile(jasperPrint, ruta + "Juegos.pdf");
        return "redirect:/listgamesadmin";
    }
    
    public String generarUsuario() throws FileNotFoundException, JRException{
        String ruta = "D:\\WOFS\\";
        List<User> usuarios = (List<User>) userRepository.findAll();
        //Carga el jrxml y lo compila
        File archivo = ResourceUtils.getFile("classpath:usuarios.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(archivo.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(usuarios);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Creado por ", "Juan C Molina");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, ruta + "Usuarios.pdf");
        return "redirect:/listusers";
    }
    
    public String generarSolicitud() throws FileNotFoundException, JRException{
        String ruta = "D:\\WOFS\\";
        List<Petition> solicitudes = (List<Petition>) petitionRepository.findAll();
        //Carga el jrxml y lo compila
        File archivo = ResourceUtils.getFile("classpath:solicitudes.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(archivo.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(solicitudes);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Creado por ", "Juan C Molina");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, ruta + "Solicitudes.pdf");
        return "redirect:/listpetitions";
    }
}
