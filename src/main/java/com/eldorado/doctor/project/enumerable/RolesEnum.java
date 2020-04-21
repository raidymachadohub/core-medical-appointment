package com.eldorado.doctor.project.enumerable;

import lombok.Getter;

public enum RolesEnum {
    
    ROLE_USER(1),
    ROLE_PM(2),
    ROLE_ADMIN(3);

    @Getter
    private final int id;

    RolesEnum(int id) {
        this.id = id;
    }

}
