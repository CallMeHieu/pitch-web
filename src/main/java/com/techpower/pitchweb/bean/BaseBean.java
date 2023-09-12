package com.techpower.pitchweb.bean;

import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class BaseBean {
    public String getParameter(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }

    public void addMessage(String message) {
        this.addMessage(FacesMessage.SEVERITY_INFO, message, null);
    }

    public void addWarning(String message) {
        this.addMessage(FacesMessage.SEVERITY_WARN, message, null);
    }

    //    public void addError(CrossCheckException serviceException) {
//        serviceException.printStackTrace();
//        this.addMessage(FacesMessage.SEVERITY_ERROR, serviceException.getMessage(), serviceException.getMessage());
//    }
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void openDialog(String executeScript) {
        PrimeFaces.current().executeScript("PF('" + executeScript + "').show();");
    }

    public void closeDialog(String executeScript) {
        PrimeFaces.current().executeScript("PF('" + executeScript + "').hide();");
    }
}
