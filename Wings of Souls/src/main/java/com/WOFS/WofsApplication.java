package com.WOFS;

import com.WOFS.service.ReportService;
import java.io.FileNotFoundException;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Controller
public class WofsApplication {

    @Autowired
    private ReportService reportService;
    
    @GetMapping("/report/consoles")
    public String generarReporteConsolas() throws FileNotFoundException, JRException{
        return reportService.generarConsola();
    }
    
    @GetMapping("/report/games")
    public String generarReporteJuegos() throws FileNotFoundException, JRException{
        return reportService.generarJuego();
    }
    
    @GetMapping("/report/users")
    public String generarReporteUsuarios() throws FileNotFoundException, JRException{
        return reportService.generarUsuario();
    }
    
    @GetMapping("/report/petitions")
    public String generarReporteSolicitudes() throws FileNotFoundException, JRException{
        return reportService.generarSolicitud();
    }
    
	public static void main(String[] args) {
		SpringApplication.run(WofsApplication.class, args);
	}

}
