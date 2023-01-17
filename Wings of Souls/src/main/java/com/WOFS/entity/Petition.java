package com.WOFS.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Juan Carlos
 */
@Entity
@Table(name = "petitions")
public class Petition implements Serializable{
    
    //Los siguientes atributos representan las columnas de BD con los mismos nombres
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String description;
    //Se mapea con su columna para mantener un estándar con las buenas prácticas
    //de Java en la variable
    private String mail;
    @Column(name = "user_identification")
    private String userIdentification;
    
    //Métodos Get y Set para cada atributo

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserIdentification() {
        return userIdentification;
    }

    public void setUserIdentification(String user) {
        this.userIdentification = user;
    }
    
}
