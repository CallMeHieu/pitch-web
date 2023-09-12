package com.techpower.pitchweb.bean;

import com.techpower.pitchweb.controller.pitch.PitchController;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@Getter
@Component
@ManagedBean
@ViewScoped
public class LoginBean extends BaseBean {
    @Autowired
    private PitchController pitchController;
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {

        addMessage(getUsername() + " " + getPassword());
    }
}
