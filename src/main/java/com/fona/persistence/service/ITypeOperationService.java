/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.service;

import com.fona.persistence.IOperations;
import com.fona.persistence.model.TypeOperation;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
public interface ITypeOperationService extends IOperations<TypeOperation>
{

    public TypeOperation findByIntitule(String nomType);
}
