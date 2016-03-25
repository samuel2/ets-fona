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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Service("fournisseurService")
public class FournisseurService extends AbstractService<Fournisseur> implements IFournisseurService
{

    private IFournisseurDao fournisseurDao;

    @Override
    protected PagingAndSortingRepository<Fournisseur, Long> getDao()
    {
        return fournisseurDao;
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
    public Page<Fournisseur> findPaginated(String code, String nom, String prenom, String cni, String numeroContribuable, Pageable pageable)
    {
        return fournisseurDao.findPaginated(code, nom, prenom, cni, numeroContribuable, pageable);
    }

}
