/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.service.impl;

import com.fona.persistence.dao.IClientDao;
import com.fona.persistence.model.Client;
import com.fona.persistence.service.IClientService;
import com.fona.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
@Service
public class ClientService extends AbstractService<Client> implements IClientService
{

    @Autowired
    IClientDao clientDao;

    @Override
    public Page<Client> findPaginated(String nom, String code, String prenom, int page, Integer size)
    {
        return clientDao.findByUsername('%' + nom + '%', '%' + code + '%', '%' + prenom + '%', new PageRequest(page, size));
    }

    @Override
    protected PagingAndSortingRepository<Client, Long> getDao()
    {
        return clientDao;
    }

    @Override
    public Client update(Client entity)
    {
        Client toUpdate = clientDao.findOne(entity.getId());
        toUpdate.setAdresse(entity.getAdresse());
        toUpdate.setCni(entity.getCni());
        toUpdate.setCode(entity.getCode());
        toUpdate.setNom(entity.getNom());
        toUpdate.setNumeroContribuable(entity.getNumeroContribuable());
        toUpdate.setPrenom(entity.getPrenom());
        return clientDao.save(toUpdate);
    }

}
