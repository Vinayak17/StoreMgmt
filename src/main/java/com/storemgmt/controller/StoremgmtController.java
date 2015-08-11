package com.storemgmt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.storemgmt.model.TransactionEntity;
import com.storemgmt.service.TransactionService;

@Controller
public class StoremgmtController {

	@Autowired
	@Qualifier("PurchaseTransactionServiceImpl")
	TransactionService transactionService;
	
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView indexPageRequest(Model model)
	{
		model.addAttribute("transactionEntity",new TransactionEntity());
		return new ModelAndView("transactions");
	}
	
	@RequestMapping(value = "createTansaction", method = RequestMethod.POST)
	public ModelAndView createTransaction(@ModelAttribute("transactionEntity") TransactionEntity transactionEntity,ModelAndView modelAndView) throws Exception
	{
		transactionService.createTransaction(transactionEntity);		
		return new ModelAndView("index");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
