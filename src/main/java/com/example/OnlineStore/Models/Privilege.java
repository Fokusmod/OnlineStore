package com.example.OnlineStore.Models;


import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "privileges")
public class Privilege {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;



}
