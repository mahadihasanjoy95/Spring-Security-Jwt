package com.security.SpringSecurityDemo.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Products {
    @Id
    private UUID id = UUID.randomUUID();
    private String name;
    private Integer price;
    private String image;
}
