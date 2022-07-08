package co.kr.gym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.kr.gym.service.BulkUpService;

@Controller
public class BulkUp {
	
   @Autowired
	private BulkUpService bulkupService;
   
	
      @GetMapping("/bulkUp")
      public String bulkUp(){
             return "bulkUp";
      }
	
   
   }
