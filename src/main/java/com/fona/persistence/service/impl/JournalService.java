/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.service.impl;

import com.fona.persistence.dao.IJournalDao;
import com.fona.persistence.model.Journal;
import com.fona.persistence.service.IJournalService;
import com.fona.persistence.service.common.AbstractService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
@Service("journalService")
public class JournalService extends AbstractService<Journal> implements IJournalService
{

    @Autowired
    IJournalDao journalDao;

    @Override
    protected PagingAndSortingRepository<Journal, Long> getDao()
    {
        return journalDao;
    }

    @Override
    public List<Journal> findExisting()
    {
        return journalDao.findExisting();
    }

    @Override
    public List<Journal> findByLigneOperationID(long idLigneOperation)
    {
        return journalDao.findByLigneOperationID(idLigneOperation);
    }

    @Override
    public List<Journal> findByLotID(long idLot)
    {
        return journalDao.findByLotID(idLot);
    }

}
