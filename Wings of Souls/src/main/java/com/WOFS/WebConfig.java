package com.WOFS;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 *
 * @author Juan Carlos
 */

//Le hace saber a la aplicación que este archivo es de configuración al iniciar
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    //Indica que el siguiente método es una configuración se hace al momento de 
    //ejecutar la aplicación
    @Bean
    //SessionLocaleResolver guarda el locale que selecciona el usuario
    public SessionLocaleResolver localeResolver() {
        //Almaceno en la variable una nueva instancia del método
        var slr = new SessionLocaleResolver();
        //Crea un objeto locale que representa el lenguaje, región geográfica o 
        //dialecto del usuario
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }
    
    @Bean
    //Detecta los cambios del usuario hacía el locale
    public LocaleChangeInterceptor localeChangeInterceptor() {
        //Almaceno en la variable una nueva instancia del método
        var lci = new LocaleChangeInterceptor();
        //Define el parametro que se va a usar para el lenguage
        lci.setParamName("lang");
        return lci;
    }

    @Override
    //Ejecuta el método LocaleChangeInterceptor
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }
    
    
}
