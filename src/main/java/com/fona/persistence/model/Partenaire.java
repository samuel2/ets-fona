/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Entity
@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Partenaire")
public abstract class Partenaire extends EntityObject
{

    @NotBlank(message = "{blank.message}")
    protected String code;

    @NotBlank(message = "{blank.message}")
    protected String nom;

    protected String prenom;

    @NotBlank(message = "{blank.message}")
    protected String cni;

    protected String numeroContribuable;

    protected Adresse adresse;

    public Partenaire()
    {
    }

    public Partenaire(String code, String nom, String prenom, String cni, String numeroContribuable, Adresse adresse, Long id, long version)
    {
        super(id, version);
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.cni = cni;
        this.numeroContribuable = numeroContribuable;
        this.adresse = adresse;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public String getCni()
    {
        return cni;
    }

    public void setCni(String cni)
    {
        this.cni = cni;
    }

    public String getNumeroContribuable()
    {
        return numeroContribuable;
    }

    public void setNumeroContribuable(String numeroContribuable)
    {
        this.numeroContribuable = numeroContribuable;
    }

    public Adresse getAdresse()
    {
        return adresse;
    }

    public void setAdresse(Adresse adresse)
    {
        this.adresse = adresse;
    }

}
