/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.service.impl;

import com.fona.persistence.dao.IFournisseurDao;
import com.fona.persistence.model.Fournisseur;
import com.fona.persistence.service.IFournisseurService;
import com.fona.persistence.service.common.AbstractService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Service("fournisseurService")
public class FournisseurService extends AbstractService<Fournisseur> implements IFournisseurService
{

    @Autowired
    private IFournisseurDao fournisseurDao;

    @Override
    protected PagingAndSortingRepository<Fournisseur, Long> getDao()
    {
        return fournisseurDao;
    }

    @Override
    public Fournisseur create(Fournisseur entity)
    {
        return fournisseurDao.save(entity);
    }

    @Override
    public Fournisseur update(Fournisseur entity)
    {
        Fournisseur fournisseurToUpdate = fournisseurDao.findOne(entity.getId());
        fournisseurToUpdate.setCode(entity.getCode());
        fournisseurToUpdate.setNom(entity.getNom());
        fournisseurToUpdate.setPrenom(entity.getPrenom());
        fournisseurToUpdate.setCni(entity.getCni());
        fournisseurToUpdate.setNumeroContribuable(entity.getNumeroContribuable());
        fournisseurToUpdate.setAdresse(entity.getAdresse());
        return fournisseurDao.save(fournisseurToUpdate);
    }

    @Override
    public void delete(Fournisseur entity)
    {
        super.delete(entity);
    }

    @Override
    public List<Fournisseur> findFournisseurByCni(String cni)
    {
        return fournisseurDao.findFournisseurByCni(cni);
    }

    @Override
    public List<Fournisseur> findFournisseurByCode(String code)
    {
        return fournisseurDao.findFournisseurByCode(code);
    }

    @Override
    public Page<Fournisseur> findPaginated(String code, String nom, String prenom, String cni, String numeroContribuable, int page, Integer size)
    {
        return fournisseurDao.findPaginated('%' + code + '%', '%' + nom + '%', '%' + prenom + '%', '%' + cni + '%', '%' + numeroContribuable + '%', new PageRequest(page, size));
    }

}
