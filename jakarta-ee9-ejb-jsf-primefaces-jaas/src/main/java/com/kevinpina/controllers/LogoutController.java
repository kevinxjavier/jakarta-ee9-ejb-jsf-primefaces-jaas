package com.kevinpina.controllers;

import jakarta.enterprise.inject.Model;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.util.logging.Logger;

@Model
public class LogoutController {

    @Named("my-context")
    @Inject
    private FacesContext facesContext;

    public String logout() throws ServletException {

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        request.logout();
        request.getSession().invalidate();

        facesContext.addMessage(null, new FacesMessage("Closing successfully the session!"));

        return "/login.xhtml";
    }
}
