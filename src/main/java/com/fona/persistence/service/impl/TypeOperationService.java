/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.service.impl;

import com.fona.persistence.dao.ITypeOperationDao;
import com.fona.persistence.model.TypeOperation;
import com.fona.persistence.service.ITypeOperationService;
import com.fona.persistence.service.common.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
@Service("auditService")
public class TypeOperationService extends AbstractService<TypeOperation> implements ITypeOperationService
{

    @Autowired
    ITypeOperationDao typeOperationDao;

    @Override
    protected PagingAndSortingRepository<TypeOperation, Long> getDao()
    {
        return typeOperationDao;
    }

    @Override
    public TypeOperation findByIntitule(String nomType)
    {
        return typeOperationDao.findByIntitule('%' + nomType + '%');
    }
}
