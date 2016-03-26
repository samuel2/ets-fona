/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.dao;

import com.fona.persistence.model.Client;
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
public interface IClientDao extends JpaSpecificationExecutor<Client>, JpaRepository<Client, Long>
{

    @Query("SELECT C FROM Client C WHERE C.nom LIKE :nom AND C.code LIKE :code AND C.prenom LIKE :prenom ")
    Page<Client> findByUsername(@Param("nom") String nom, @Param("code") String code, @Param("prenom") String prenom, Pageable pageable);
}
