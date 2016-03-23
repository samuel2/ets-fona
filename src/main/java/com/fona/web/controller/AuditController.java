/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.web.controller;

import com.fona.persistence.model.Departement;
import com.fona.persistence.model.Fourniture;
import com.fona.persistence.model.LigneOperation;
import com.fona.persistence.model.Operation;
import com.fona.persistence.model.Role;
import com.fona.persistence.model.TypeOperation;
import com.fona.persistence.service.IDepartementService;
import com.fona.persistence.service.IFournitureService;
import com.fona.persistence.service.ILigneOperationService;
import com.fona.persistence.service.IOperationService;
import com.fona.persistence.service.IRoleService;
import com.fona.persistence.service.ITypeOperationService;
import com.fona.web.form.AuditForm;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Controller
@Secured(
        {
            "ROLE_USER", "ROLE_ADMIN"
        })
@RequestMapping("/audit")
public class AuditController
{

    @Autowired
    ILigneOperationService ligneOperationService;

    @Autowired
    IDepartementService departementService;

    @Autowired
    IOperationService auditService;

    @Autowired
    IFournitureService fournitureService;

    @Autowired
    IRoleService roleService;

    @Autowired
    ITypeOperationService typeOperationService;

    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public String ShowAction(@PathVariable("id") final Long id, final ModelMap model)
    {
        final Operation audit;
        audit = auditService.findOne(id);
        final List<LigneOperation> ligneOperations = ligneOperationService.filterByOperation(id);
        Role role = roleService.findOne(audit.getUser().getId());
        audit.setLigneOperations(ligneOperations);
        audit.setUser(role);
        model.addAttribute("audit", audit);
        model.addAttribute("user", role);
        model.addAttribute("ligneOperations", ligneOperations);
        return "audit/show";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editAction(@PathVariable("id") final Long id, final ModelMap model)
    {
        final Operation audit = auditService.findOne(id);
        final List<LigneOperation> ligneOperations = ligneOperationService.filterByOperation(id);
        final AuditForm auditForm = new AuditForm();
        auditForm.setAudit(audit);
        auditForm.setLigneOperations(ligneOperations);
        model.addAttribute("auditForm", auditForm);
        return "audit/edit";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String indexAction(final ModelMap model, final WebRequest webRequest)
    {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        final long departementID = webRequest.getParameter("querydepartement") != null
                && !webRequest.getParameter("querydepartement").equals("")
                        ? Long.valueOf(webRequest.getParameter("querydepartement"))
                        : -1;
        final Integer page = webRequest.getParameter("page") != null
                ? Integer.valueOf(webRequest.getParameter("page"))
                : 0;
        final Integer size = webRequest.getParameter("size") != null
                ? Integer.valueOf(webRequest.getParameter("size"))
                : 5;
        final String dateOperationString = webRequest.getParameter("querydateoperation") != null
                ? webRequest.getParameter("querydateoperation")
                : "01/01/1960";
        final String designation = webRequest.getParameter("querydesignation") != null
                ? webRequest.getParameter("querydesignation") : "";
        Date dateOperation = new Date();
        try {
            dateOperation = dateFormatter.parse(dateOperationString);
        }
        catch (ParseException ex) {
            try {
                dateOperation = dateFormatter.parse("01/01/1960");
            }
            catch (ParseException ex1) {
                Logger.getLogger(SortieController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        final Page<Operation> resultPage = auditService.findPaginated(departementID, dateOperation, "audit", designation, page, size);
        final Operation audit = new Operation();
        TypeOperation typeOperation = new TypeOperation();
        Departement departement = new Departement();
        typeOperation.setIntitule("Audit");
        departement.setId(departementID);

        audit.setDateOperation(dateOperation);
        audit.setDepartement(departement);
        audit.setTypeOperation(typeOperation);

        model.addAttribute("audit", audit);
        model.addAttribute("querydesignation", designation);
        model.addAttribute("page", page);
        model.addAttribute("Totalpage", resultPage.getTotalPages());
        model.addAttribute("size", size);
        model.addAttribute("audits", resultPage.getContent());
        return "audit/index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newAction(final ModelMap model)
    {
        final AuditForm auditForm = new AuditForm();
        final Operation audit = new Operation();
        TypeOperation typeOperation = typeOperationService.findByIntitule("audit");
        audit.setTypeOperation(typeOperation);
        auditForm.setAudit(audit);
        model.addAttribute("auditForm", auditForm);
        return "audit/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAction(final ModelMap model, @Valid AuditForm auditForm,
            final BindingResult result,
            final RedirectAttributes redirectAttributes)
    {
        if (result.hasErrors()) {
            model.addAttribute("error", "error");
            model.addAttribute("auditForm", auditForm);
            return "audit/new";
        }
        else {
            auditService.createAudit(auditForm.getAudit());
            redirectAttributes.addFlashAttribute("info", "alert.success.new");
            return "redirect:/audit/" + auditForm.getAudit().getId() + "/show";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteAction(final Operation audit)
    {
        Operation auditToDelete = auditService.findOne(audit.getId());
        auditService.delete(auditToDelete);
        return "redirect:/audit/";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String updateAction(final ModelMap model, @Valid AuditForm auditForm,
            final BindingResult result,
            final RedirectAttributes redirectAttributes)
    {
        if (result.hasErrors()) {
            model.addAttribute("error", "error");
            model.addAttribute("auditForm", auditForm);
            return "audit/edit";
        }
        else {
            auditService.updateAudit(auditForm.getAudit());
            redirectAttributes.addFlashAttribute("info", "alert.success.new");
            return "redirect:/audit/" + auditForm.getAudit().getId() + "/show";
        }
    }

    @ModelAttribute("departements")
    public Map<Long, String> getDepartements()
    {
        Map<Long, String> map = new HashMap<>();
        List<Departement> departements = departementService.findAll();
        for (Departement departement : departements) {
            map.put(departement.getId(), departement.getIntitule());
        }
        return map;
    }

    @ModelAttribute("fournitures")
    public Map<Long, String> getFournitures()
    {
        Map<Long, String> map = new HashMap<>();
        List<Fourniture> fournitures = fournitureService.findExisting();
        for (Fourniture fourniture : fournitures) {
            map.put(fourniture.getId(), fourniture.getDesignation());
        }
        return map;
    }
}
