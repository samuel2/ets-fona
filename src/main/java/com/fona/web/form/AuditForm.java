/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.web.form;

import com.fona.persistence.model.LigneOperation;
import com.fona.persistence.model.Operation;
import com.fona.web.util.ShrinkableLazyList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.apache.commons.collections.FactoryUtils;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
public class AuditForm {

    @Valid
    private Operation audit;

    @Valid
    @NotEmpty(message = "{empty.message}")
    private List<LigneOperation> ligneOperations = ShrinkableLazyList.decorate(
            new ArrayList<>(), FactoryUtils.instantiateFactory(LigneOperation.class));

    public AuditForm() {
    }

    public Operation getAudit() {
        if (audit != null) {
            audit.setDateOperation(new Date());
            audit.setLigneOperations(ligneOperations);
        }
        return audit;
    }

    public void setAudit(Operation audit) {
        this.audit = audit;
    }

    public List<LigneOperation> getLigneOperations() {
        return ligneOperations;
    }

    public void setLigneOperations(List<LigneOperation> ligneOperations) {
        this.ligneOperations = ligneOperations;
    }

}
