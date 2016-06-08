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
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
@RequestMapping("/fournisseur")
<<<<<<< HEAD
public class FournisseurController {
=======
public class FournisseurController
{
>>>>>>> 4b787c28176af57e5ce3c719dc2c0b07f295ba70

    @Autowired
    IFournisseurService fournisseurService;

    @Autowired
    IEntreeService entreeService;

    private static Logger logger = Logger.getLogger(FournisseurController.class.getName());

    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public String showAction(@PathVariable("id") final Long id, final ModelMap model, WebRequest webRequest) {

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

    @RequestMapping(method = RequestMethod.GET)
<<<<<<< HEAD
    public String indexAction(final ModelMap model, final WebRequest webRequest) {

        final String code = webRequest.getParameter("querycode") != null ? webRequest.getParameter("querycode") : "";
        final String cni = webRequest.getParameter("querycni") != null ? webRequest.getParameter("querycni") : "";
        final String nom = webRequest.getParameter("querynom") != null ? webRequest.getParameter("querynom") : "";
        final String prenom = webRequest.getParameter("queryprenom") != null ? webRequest.getParameter("queryprenom") : "";
        final String numeroContribuable = webRequest.getParameter("querynumeroContribuable") != null ? webRequest.getParameter("querynumeroContribuable") : "";
        final Integer page = webRequest.getParameter("page") != null ? Integer.valueOf(webRequest.getParameter("page")) : 0;
        final Integer size = webRequest.getParameter("size") != null ? Integer.valueOf(webRequest.getParameter("size")) : 5;

        final Page<Fournisseur> resultPage = fournisseurService.findPaginated(code, nom, prenom, cni, numeroContribuable, page, size);
        final Fournisseur fournisseur = new Fournisseur();
        fournisseur.setCode(code);
        fournisseur.setCni(cni);
        fournisseur.setNom(nom);
        fournisseur.setPrenom(prenom);
        fournisseur.setNumeroContribuable(numeroContribuable);
        model.addAttribute("fournisseur", fournisseur);
        model.addAttribute("page", page);
        model.addAttribute("Totapage", resultPage.getTotalPages());
        model.addAttribute("size", size);
        model.addAttribute("fournisseurs", resultPage.getContent());
        return "fournisseur/index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAction(@Valid Fournisseur fournisseur, final ModelMap model,
            final BindingResult result, final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("error", "error");
            model.addAttribute("fournisseur", fournisseur);
            return "fournisseur/new";
        } else {
            redirectAttributes.addFlashAttribute("info", "alert.success.new");
            fournisseurService.create(fournisseur);
            return "redirect:/fournisseur/" + fournisseur.getId() + "/show";
        }
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String updateAction(@Valid Fournisseur fournisseur, final ModelMap model, @PathVariable("id") final Long id,
            final BindingResult result, final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("error", "error");
            return "fournisseur/edit";
        } else {
            redirectAttributes.addFlashAttribute("info", "alert.success.new");
            fournisseurService.update(fournisseur);
            return "redirect:/fournisseur/" + fournisseur.getId() + "show";
        }
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newAction(final ModelMap model) {
        final Fournisseur fournisseur = new Fournisseur();
        model.addAttribute("fournisseur", fournisseur);
        return "/fournisseur/new";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editAction(@PathVariable("id") final Long id, final ModelMap model) {
=======
    public String indexAction(final ModelMap model, final WebRequest webRequest)
    {
        System.out.println("Debut liste fournisseur dans le controller...");
        final Integer page = webRequest.getParameter("page") != null ? Integer.valueOf(webRequest.getParameter("page")) : 0;
        final Integer size = webRequest.getParameter("size") != null ? Integer.valueOf(webRequest.getParameter("size")) : 55;

        final String code = webRequest.getParameter("querycode") != null ? webRequest.getParameter("querycode") : "";
        final String nom = webRequest.getParameter("querynom") != null ? webRequest.getParameter("querynom") : "";
        final String cni = webRequest.getParameter("querycni") != null ? webRequest.getParameter("querycni") : "";
        final String prenom = webRequest.getParameter("queryprenom") != null ? webRequest.getParameter("queryprenom") : "";
        final String numeroContribuable = webRequest.getParameter("querynumeroContribuable") != null ? webRequest.getParameter("querynumeroContribuable") : "";

        System.out.println("Liste des fournisseurs dans le controlleur...");
        final Page<Fournisseur> resultpPage = fournisseurService.findPaginated(page, size);

        System.out.println("Une instance de fournisseur dans le controlleur...");
        Fournisseur fournisseur = new Fournisseur();
        System.out.println("Instance cree correctement...");

        System.out.println("Construction des objets a afficher...");
        fournisseur.setCode(code);
        fournisseur.setNom(nom);
        fournisseur.setPrenom(prenom);
        fournisseur.setCni(cni);
        fournisseur.setNumeroContribuable(numeroContribuable);

        System.out.println("Ajout des elements dans la vue...");
        model.addAttribute("page", page);
        model.addAttribute("fournisseur", fournisseur);
        model.addAttribute("Totalpage", resultpPage.getTotalPages());
        model.addAttribute("size", size);
        model.addAttribute("fournisseurs", resultpPage.getContent());
        System.out.println("Reurn de la vue cree...");
        return "fournisseur/index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newAction(final ModelMap model)
    {
        final Fournisseur fournisseur = new Fournisseur();
        model.addAttribute("fournisseur", fournisseur);
        return "fournisseur/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAction(@Valid final Fournisseur fournisseur, final BindingResult result,
                               final ModelMap model, final RedirectAttributes redirectAttributes)
    {
        if(result.hasErrors())
        {
            model.addAttribute("error", "error");
            model.addAttribute("fournisseur", fournisseur);
            return "fournisseur/new";
        }
        else
        {
            redirectAttributes.addFlashAttribute("info", "alert.success.new");
            final Fournisseur fournisseurCreated = fournisseurService.create(fournisseur);
            return "redirect:/fournisseur/" + fournisseurCreated.getId() + "/show";
        }
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editAction(@PathVariable("id") final Long id, final ModelMap model)
    {
>>>>>>> 4b787c28176af57e5ce3c719dc2c0b07f295ba70
        final Fournisseur fournisseur = fournisseurService.findOne(id);
        model.addAttribute("fournisseur", fournisseur);
        return "fournisseur/edit";
    }

<<<<<<< HEAD
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteAction(@PathVariable("id") final Long id, final RedirectAttributes redirectAttributes) {
        final Fournisseur fournisseur = fournisseurService.findOne(id);
        fournisseurService.delete(fournisseur);
        return "redirect:/fournisseur";
    }
=======
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String updateAction(@Valid final Fournisseur fournisseur, @PathVariable("id") final Long id,
                               final ModelMap model, final BindingResult result, final RedirectAttributes redirectAttributes)
    {
        if(result.hasErrors())
        {
            redirectAttributes.addAttribute("error", "error");
            return "fournisseur/edit";
        }
        else
        {
            redirectAttributes.addFlashAttribute("info", "alert.success.new");
            fournisseurService.update(fournisseur);
            return "redirect:/fournisseur/" + fournisseur.getId() + "/show";
        }
    }

//    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
//    public String deleteAction(){
//
//    }
>>>>>>> 4b787c28176af57e5ce3c719dc2c0b07f295ba70
}
