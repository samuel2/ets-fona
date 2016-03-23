/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.persistence.service;

import com.fona.persistence.IOperations;
import com.fona.persistence.model.Journal;
import java.util.List;

/**
 *
 * @author Brice GUEMKAM <briceguemkam@gmail.com>
 */
public interface IJournalService extends IOperations<Journal>
{

    public List<Journal> findExisting();

    public List<Journal> findByLigneOperationID(final long idLigneOperation);

    public List<Journal> findByLotID(final long idLot);

}
