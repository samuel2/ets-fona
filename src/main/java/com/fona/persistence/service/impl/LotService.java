/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.service.impl;

import com.fona.persistence.dao.IEntreeDao;
import com.fona.persistence.dao.IFournitureDao;
import com.fona.persistence.dao.ILotDao;
import com.fona.persistence.model.Entree;
import com.fona.persistence.model.Fourniture;
import com.fona.persistence.model.Lot;
import com.fona.persistence.service.ILotService;
import com.fona.persistence.service.common.AbstractService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
@Service("lotService")
public class LotService extends AbstractService<Lot> implements ILotService
{

    @Autowired
    private ILotDao iLotDao;

    @Autowired
    private IEntreeDao iEntreeDao;

    @Autowired
    private IFournitureDao iFournitureDao;

    @Override
    protected PagingAndSortingRepository<Lot, Long> getDao()
    {
        return iLotDao;
    }

    @Override
    public Lot create(Lot entity)
    {
        Entree entree = iEntreeDao.findOne(entity.getEntree().getId());
        Fourniture fourniture = iFournitureDao.findOne(entity.getFourniture().getId());
        entity.setEntree(entree);
        entity.setFourniture(fourniture);
        return iLotDao.save(entity);
    }

    @Override
    public Lot update(Lot entity)
    {
        Lot lotToUpdate = iLotDao.findOne(entity.getId());
        Fourniture fourniture = iFournitureDao.findOne(entity.getFourniture().getId());
        lotToUpdate.setDateEntree(entity.getDateEntree());
        lotToUpdate.setNumero(entity.getNumero());
        lotToUpdate.setPrixUnitaire(entity.getPrixUnitaire());
        lotToUpdate.setPrixVenteUnitaire(entity.getPrixVenteUnitaire());
        lotToUpdate.setQuantite(entity.getQuantite());
        lotToUpdate.setTotalMontant(entity.getTotalMontant());
        lotToUpdate.setEtat(entity.getEtat());
        lotToUpdate.setModifiable(entity.isModifiable());
        lotToUpdate.setFourniture(fourniture);
        return iLotDao.save(lotToUpdate);
    }

    @Override
    public void delete(Lot entity)
    {
        iLotDao.delete(entity);
    }

    @Override
    public void deleteById(long entityId)
    {
        iLotDao.delete(entityId);
    }

    @Override
    public Page<Lot> findByFourniture(long id, int page, int size)
    {
        return iLotDao.findByFourniture(id, new PageRequest(page, size));
    }

    @Override
    public Page<Lot> searchLots(String numero, Date dateEntree, float prixUnitaire, float prixVenteUnitaire, int quantite, float totalMontant, String etat, int page, Integer size)
    {
        return iLotDao.searchLots('%' + numero + '%', dateEntree, prixUnitaire, prixVenteUnitaire, quantite, totalMontant, '%' + etat + '%', new PageRequest(page, size));
    }

    @Override
    public List<Lot> findByEntreeId(long id)
    {
        return iLotDao.findByEntreeId(id);
    }

    @Override
    public List<Lot> findByEntreeIdForEdit(long id)
    {
        return iLotDao.findByEntreeIdForEdit(id);
    }

    @Override
    public List<Lot> findLotsForFifo(long id)
    {
        return iLotDao.findByFournitureForFifo(id);
    }

    @Override
    public List<Lot> filterByLigneAudit(long id)
    {
        return iLotDao.filterByLigneAudit(id);
    }

    @Override
    public Lot findOneByLigneAudit(long id)
    {
        return iLotDao.findOneByLigneAudit(id);
    }

    @Override
    public Map<Long, String> getEntreeFournitures(long id)
    {
        List<Fourniture> fournitures = iLotDao.getEntreeFournitures(id);
        Map<Long, String> listMap = new HashMap<>();
        for (Fourniture fourniture : fournitures) {
            listMap.put(fourniture.getId(),
                    fourniture.getDesignation());
        }
        return listMap;
    }

    @Override
    public Map<Long, String> getFournituresForPerte(long id)
    {
        List<Lot> lots = iLotDao.findByFournitureForPerte(id);
        Map<Long, String> listMap = new HashMap<>();
        for (Lot lot : lots) {
            listMap.put(lot.getId(), lot.getNumero() + " - " + lot.getDateEntree());
        }
        return listMap;
    }

    @Override
    public Page<Lot> search(long id, Date debut, Date fin, Integer quantite, int page, Integer size)
    {
        if (quantite == null) {
            return iLotDao.searchLots(id, debut, fin, new PageRequest(page, size));
        }
        else {
            return iLotDao.searchLots(id, debut, fin, quantite, new PageRequest(page, size));
        }
    }
}
