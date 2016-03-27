/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.web.controller;

import com.fona.persistence.model.Entree;
import com.fona.persistence.model.Fournisseur;
import com.fona.persistence.service.IEntreeService;
import com.fona.persistence.service.IFournisseurService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author samuel   < smlfolong@gmail.com >
 */
@Controller
@Secured(
        {
            "ROLE_USER", "ROLE_ADMIN"
        })
@RequestMapping("fournisseur")
public class FournisseurController
{

    @Autowired
    IFournisseurService fournisseurService;

    @Autowired
    IEntreeService entreeService;

    private static Logger logger = Logger.getLogger(FournisseurController.class.getName());

    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public String showAction(@PathVariable("id") final Long id, final ModelMap model, WebRequest webRequest)
    {
        final Integer page = webRequest.getParameter("page") != null ? Integer.valueOf(webRequest.getParameter("page")) : 0;
        final Integer size = webRequest.getParameter("size") != null ? Integer.valueOf(webRequest.getParameter("size")) : 55;
        final Fournisseur fournisseur = fournisseurService.findOne(id);
        Page<Entree> resultPage = entreeService.findByFournisseur(id, page, size);
        model.addAttribute("page", page);
        model.addAttribute("Totalpage", resultPage.getTotalPages());
        model.addAttribute("size", size);
        model.addAttribute("fournisseur", fournisseur);
        return "/fournisseur/show";
    }
}
