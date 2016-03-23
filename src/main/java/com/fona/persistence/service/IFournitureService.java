/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.service;

import com.fona.persistence.IOperations;
import com.fona.persistence.model.Categorie;
import com.fona.persistence.model.Fourniture;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IFournitureService extends IOperations<Fourniture>
{

    public List<Fourniture> findByCategorie(Categorie categorie);

    public Map<Long, String> findByCategorieName(String categorie);

    public List<Fourniture> findExisting();

    Page<Fourniture> findPaginated(Long Id, String designation, String reference,
            int nombrePage, Integer size);
}
