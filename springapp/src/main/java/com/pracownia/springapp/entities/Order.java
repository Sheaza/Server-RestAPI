package com.pracownia.springapp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "order_seq")
    @Column(name = "id")
    @ApiModelProperty(hidden = true)
    private Integer id;

    @Column(name = "date", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(dataType = "java.sql.Date")
    private Date date;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;


    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Item> items = new ArrayList<>();

    @PrePersist
    @PreUpdate
    public void updateItemsAssociation(){
        for(Item item : this.items){
            item.setOrder(this);
        }
    }

    public Order(){

    }

    public Order(Date date, Client client, List<Item> items){
        this.date = date;
        this.client = client;
        this.items = items;
    }

}