package com.example.sbb.user;

import lombok.Getter;

@Getter
public enum SiteUserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    SiteUserRole(String value){
        this.value= value;
    }
    private String value;
}
