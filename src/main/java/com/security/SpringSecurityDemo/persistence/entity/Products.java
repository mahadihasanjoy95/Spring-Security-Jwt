package com.security.SpringSecurityDemo.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Products {
//    id: '1',
//    name: 'MacBook',
//    price: 1400,
//    image: 'https://picsum.photos/id/180/2400/1600',
    @Id
    private String id;
    private String name;
    private Integer price;
    private String image;
}
