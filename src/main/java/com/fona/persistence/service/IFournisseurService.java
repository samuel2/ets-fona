/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.service;

import com.fona.persistence.IOperations;
import com.fona.persistence.model.Fournisseur;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IFournisseurService extends IOperations<Fournisseur>
{

    public List<Fournisseur> findFournisseurByCni(String cni);

    public List<Fournisseur> findFournisseurByCode(String code);

    Page<Fournisseur> findPaginated(String code, String nom, String prenom, String cni, String numeroContribuable, Pageable pageable);
}
