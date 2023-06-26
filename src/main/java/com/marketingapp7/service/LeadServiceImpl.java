package com.marketingapp7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp7.entity.Lead;
import com.marketingapp7.repository.LeadRepository;


@Service
public class LeadServiceImpl implements LeadService {

	
	
	//repository layer takes the content of the entity layer and pushed to the database
	//we use repository layer which acts  as a SQL Query
	//but the content goes to the database has to be  entity object content
	
	@Autowired
	private LeadRepository leadRepo;
	
	@Override
	public void saveLead(Lead lead) {
		//the content goes to the database has to be  entity object content (lead)
		leadRepo.save(lead);
		 
	}

	@Override
	public List<Lead> getLeads() {
		List<Lead> leads=leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLead(long id) {
		 leadRepo.deleteById(id);
		
	}

	@Override
	public Lead getLeadById(long id) {
		 Optional<Lead> findById = leadRepo.findById(id);
		 Lead lead = findById.get();
		return lead;
	}

}















