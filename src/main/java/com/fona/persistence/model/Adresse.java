/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Embeddable
public class Adresse implements Serializable
{

    @NotBlank(message = "{blank.message}")
    @Size(max = 9, min = 9, message = "{size.message}")
    protected String telephone;

    @Email
    @Size(max = 255, min = 7, message = "{size.message}")
    protected String email;

    protected String boitePostal;

    public Adresse()
    {
    }

    public Adresse(String telephone, String email, String boitePostal)
    {
        this.telephone = telephone;
        this.email = email;
        this.boitePostal = boitePostal;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getBoitePostal()
    {
        return boitePostal;
    }

    public void setBoitePostal(String boitePostal)
    {
        this.boitePostal = boitePostal;
    }

}
