/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.dao;

import com.fona.persistence.model.Categorie;
import com.fona.persistence.model.Entree;
import com.fona.persistence.model.User;
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
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
public interface IEntreeDao extends JpaSpecificationExecutor<Entree>, JpaRepository<Entree, Long>
{

    @Query("SELECT e FROM Entree e WHERE e.categorie = :categorie")
    public List<Entree> findByCategorie(@Param("categorie") Categorie categorie);

    @Query("SELECT e FROM Entree e WHERE e.user = :user")
    public List<Entree> findByUser(@Param("user") User user);

    @Query("SELECT e FROM Entree e, Lot l WHERE e.dateEntree >= :dateOperation AND "
            + "e.categorie.id= :id AND l.entree.id=e.id AND "
            + " l.fourniture.designation LIKE :designation ")
    Page<Entree> findPaginated(
            @Param("id") long categorieID,
            @Param("dateOperation") Date dateOperation,
            @Param("designation") String designation,
            Pageable pageable
    );

    @Query("SELECT e FROM Entree e, Lot l WHERE e.dateEntree >= :dateOperation "
            + " AND l.entree.id=e.id AND "
            + " l.fourniture.designation LIKE :designation ")
    Page<Entree> findPaginated(
            @Param("dateOperation") Date dateOperation,
            @Param("designation") String designation,
            Pageable pageable
    );

}
