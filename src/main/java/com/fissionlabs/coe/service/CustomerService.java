package com.fissionlabs.coe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fissionlabs.coe.model.Customer;
import com.fissionlabs.coe.util.KafkaConstants;

@Service("customerService")
public class CustomerService {

	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	public String add(List<Customer>  customers)
	{
		 if(!customers.isEmpty())
		 {
			  for(Customer c: customers)
			  {
				  kafkaTemplate.send(KafkaConstants.TOPIC,c);
				  System.out.println("***********Message public to kafka Template*******");
			  }
		 }
		 return "Customer record added to kafka Queue successfully";
	}
	
}
