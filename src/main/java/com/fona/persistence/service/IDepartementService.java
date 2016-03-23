/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.service;

import com.fona.persistence.IOperations;
import com.fona.persistence.model.Departement;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IDepartementService extends IOperations<Departement>
{

    Page<Departement> searchDepartements(String code, String intitule, int nombrePage, Integer size);

    List<Departement> filterDepartementByAgenceId(long agenceId);

}
