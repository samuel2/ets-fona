
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fona.web.controller;

import com.fona.persistence.model.Client;
import com.fona.persistence.service.IClientService;
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
@RequestMapping("/client")
public class ClientController
{

    @Autowired
    private IClientService iClientService;

    @RequestMapping(value = "/{id}/show", method = RequestMethod.GET)
    public String showAction(@PathVariable("id") final Long id, final ModelMap model)
    {

        final Client client = iClientService.findOne(id);
        model.addAttribute("client", client);
        return "/client/show";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String indexAction(final ModelMap model, final WebRequest webRequest)
    {

        final String code = webRequest.getParameter("querycode") != null ? webRequest.getParameter("querycode") : "";
        final String nom = webRequest.getParameter("querynom") != null ? webRequest.getParameter("querynom") : "";
        final String prenom = webRequest.getParameter("queryprenom") != null ? webRequest.getParameter("queryprenom") : "";

        final Integer page = webRequest.getParameter("page") != null ? Integer.valueOf(webRequest.getParameter("page")) : 0;
        final Integer size = webRequest.getParameter("size") != null ? Integer.valueOf(webRequest.getParameter("size")) : 5;

        final Page<Client> resultPage = iClientService.findPaginated(nom, code, prenom, page, size);
        Client client = new Client();
        client.setCode(code);
        client.setNom(nom);
        client.setPrenom(prenom);
        model.addAttribute("page", page);
        model.addAttribute("client", client);
        model.addAttribute("Totalpage", resultPage.getTotalPages());
        model.addAttribute("size", size);
        model.addAttribute("clients", resultPage.getContent());

        return "client/index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newAction(final ModelMap model)
    {
        final Client client = new Client();
        model.addAttribute("client", client);
        return "client/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAction(@Valid final Client client, final BindingResult result,
            final ModelMap model, final RedirectAttributes redirectAttributes)
    {
        if (result.hasErrors()) {
            model.addAttribute("error", "error");
            model.addAttribute("client", client);
            return "client/new";
        }
        else {
            redirectAttributes.addFlashAttribute("info", "alert.success.new");
            final Client clientCreated = iClientService.create(client);
            return "redirect:/client/" + clientCreated.getId() + "/show";
        }
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteAction(final Client client)
    {
        final Client clientToDisable = iClientService.findOne(client.getId());
        iClientService.delete(clientToDisable);
        return "redirect:/client/";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editAction(@PathVariable("id") final Long id, final ModelMap model)
    {
        final Client client = iClientService.findOne(id);
        model.addAttribute("client", client);
        return "/client/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String updateAction(@Valid final Client client,
            @PathVariable("id") final Long id, final ModelMap model,
            final BindingResult result, final RedirectAttributes redirectAttributes)
    {
        if (result.hasErrors()) {
            model.addAttribute("error", "error");
            return "client/edit";
        }
        else {
            redirectAttributes.addFlashAttribute("info", "alert.success.new");
            iClientService.update(client);
            return "redirect:/client/" + client.getId() + "/show";
        }
    }
}
