package com.pracownia.springapp.repositories;

import com.pracownia.springapp.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("select c from Client c where c.name = ?1")
    List<Client> findClientByName(String name);

}
