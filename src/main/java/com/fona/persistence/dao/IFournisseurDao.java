/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.dao;

import com.fona.persistence.model.Fournisseur;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IFournisseurDao extends JpaRepository<Fournisseur, Long>, JpaSpecificationExecutor<Fournisseur>
{

    @Query("SELECT f FROM Fournisseur f WHERE f.cni LIKE :cni")
    public List<Fournisseur> findFournisseurByCni(@PathVariable("cni") String cni);

    @Query("SELECT f FROM Fournisseur f WHERE f.code LIKE :code")
    public List<Fournisseur> findFournisseurByCode(@PathVariable("code") String code);

    @Query("SELECT f FROM Fournisseur f WHERE f.code LIKE :code AND "
           + "f.nom LIKE :nom AND "
           + "f.prenom LIKE :prenom AND "
           + "f.cni LIKE :cni AND "
           + "f.numeroContribuable LIKE :numeroContribuable")
    Page<Fournisseur> findPaginated(
            @PathVariable("code") String code,
            @PathVariable("nom") String nom,
            @PathVariable("prenom") String prenom,
            @PathVariable("cni") String cni,
            @PathVariable("numeroContribuable") String numeroContribuable,
            Pageable pageable
    );
}
