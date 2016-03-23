/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.service;

import com.fona.persistence.IOperations;
import com.fona.persistence.model.Categorie;
import com.fona.persistence.model.Entree;
import com.fona.persistence.model.User;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
public interface IEntreeService extends IOperations<Entree>
{

    public List<Entree> findByCategorie(Categorie categorie);

    public List<Entree> findByUser(User user);

    Page<Entree> findPaginated(long categorieID, Date dateOperation,
            String designation, int page, Integer size);
}
