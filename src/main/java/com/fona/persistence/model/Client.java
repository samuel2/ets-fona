/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Entity
@DiscriminatorValue("Client")
public class Client extends Partenaire
{

    public Client()
    {
    }

    public Client(String code, String nom, String prenom, String cni, String numeroContribuable, Adresse adresse, Long id, long version)
    {
        super(code, nom, prenom, cni, numeroContribuable, adresse, id, version);
    }

}
