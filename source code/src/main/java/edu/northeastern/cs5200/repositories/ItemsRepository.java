package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Items;

public interface ItemsRepository extends CrudRepository<Items, Integer>{

}
