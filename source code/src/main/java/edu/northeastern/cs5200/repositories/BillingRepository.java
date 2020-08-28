package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.northeastern.cs5200.models.Billing;

public interface BillingRepository extends CrudRepository<Billing, Integer>{

}
