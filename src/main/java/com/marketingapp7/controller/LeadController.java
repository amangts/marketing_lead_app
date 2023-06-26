package com.marketingapp7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp7.entity.Lead;
import com.marketingapp7.repository.LeadRepository;
import com.marketingapp7.service.LeadService;
import com.marketingapp7.util.EmailService;
 

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private EmailService emailService;
	
	// http://localhost:8080/view
	@RequestMapping("/view")
	public String viewLeadPage() {
		return "create_lead";
		
	}
	// http://localhost:8080/saveLead
	@RequestMapping("/saveLead")
	
	//stores the data into lead object from the view layer
	public String saveOneLaead(Lead lead, Model model) {   //  model model act as a request.setAttribute
		//it takes the lead object and passes to the service layer
		leadService.saveLead(lead);
		emailService.sendEmail(lead.getEmail(), "WELCOME", "YOUR RECORD IS SAVED");
		model.addAttribute("msg","Lead is saved!!");
		//and it return the content object to the view
		 return "create_lead";
		
	}
	//http://localhost:8080/listAll
	@RequestMapping("/listAll")
	public String getAllLeads(Model model) {   //Model model access request.get and request.setAttribute
		List<Lead> leads =leadService.getLeads();
		model.addAttribute("leads", leads); // here Attribute is leads and stores into the "leads".
		System.out.println(leads);
		return "list_leads";
	}
    @RequestMapping("/delete")
	public String deleteLeadById(@RequestParam("id") long id , Model model) {
    	leadService.deleteLead(id);
    	List<Lead> leads =leadService.getLeads();
    	model.addAttribute("leads", leads);
		System.out.println(leads);
		return "list_leads";
	}
    
    @RequestMapping("/update")
    public String getLeadById(@RequestParam("id") long id, Model model) {
    	Lead lead=leadService.getLeadById(id);
    	model.addAttribute("lead",lead);
    	return "update_lead";
    }
    
     @RequestMapping("/updateLead")
	//stores the data into lead object from the view layer
	public String updateOneLaead(Lead lead ,Model model) {   //  model model act as a request.setAttribute
		//it takes the lead object and passes to the service layer
		leadService.saveLead(lead);
		List<Lead> leads =leadService.getLeads();
    	model.addAttribute("leads", leads);
		return "list_leads";
     }
     
}












