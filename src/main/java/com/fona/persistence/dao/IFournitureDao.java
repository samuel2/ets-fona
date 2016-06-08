/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.dao;

import com.fona.persistence.model.Categorie;
import com.fona.persistence.model.Fourniture;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public interface IFournitureDao extends JpaRepository<Fourniture, Long>, JpaSpecificationExecutor<Fourniture>
{

    @Query("SELECT f FROM Fourniture f WHERE f.categorie = :categorie")
    public List<Fourniture> findByCategorie(@Param("categorie") Categorie categorie);

    @Query("SELECT f FROM Fourniture f WHERE f.categorie.intitule LIKE :categorie")
    public List<Fourniture> findByCategorieName(@Param("categorie") String categorie);

    @Query("SELECT f FROM Fourniture f WHERE f.quantite>0")
    public List<Fourniture> findExisting();

    @Query("SELECT F FROM Fourniture F WHERE F.designation LIKE :designation"
           + " and F.reference LIKE :reference")
    Page<Fourniture> findPaginated(@Param("designation") String designation,
                                   @Param("reference") String reference, Pageable pageable);

    @Query("SELECT F FROM Fourniture F WHERE F.categorie.id = :categorieId "
           + " AND F.designation LIKE :designation and F.reference LIKE :reference AND F.dateDePeremption <= :dateDePeremption")
    Page<Fourniture> findPaginated(@Param("categorieId") Long Id,
                                   @Param("designation") String designation,
                                   @Param("reference") String reference,
                                   @Param("dateDePeremption") Date dateDePeremption, Pageable pageable);

    @Query("SELECT f FROM Fourniture f WHERE f.dateDePeremption <= :dateDePeremption")
    Page<Fourniture> findPaginated(@Param("dateDePeremption") Date dateDePeremption, Pageable pageable);

}
