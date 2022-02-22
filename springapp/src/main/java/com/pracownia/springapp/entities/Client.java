package com.pracownia.springapp.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "client_seq")
    @Column(name = "id")
    @ApiModelProperty(hidden = true)
    private Integer id;


    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "age")
    private Integer age;


    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    @PrePersist
    @PreUpdate
    public void updateOrdersAssociation(){
        for(Order order : this.orders){
            order.setClient(this);
        }
        address.setClient(this);
        phone.setClient(this);
    }

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "client_id", updatable = false,insertable = false)
    private Address address;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Phone phone;


    public Client(){

    }

    public Client(String name, String surname, Integer age, List<Order> orders,Address address, Phone phone){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.orders = orders;
        this.address = address;
        this.phone = phone;

    }

}