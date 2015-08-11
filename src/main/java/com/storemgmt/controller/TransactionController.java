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

import com.storemgmt.bean.PurchaseTransactionFormBean;
import com.storemgmt.bean.SaleTransactionFormBean;
import com.storemgmt.model.TransactionEntity;
import com.storemgmt.service.PurchaseTransactionServiceImpl;
import com.storemgmt.service.TransactionService;

@Controller
@RequestMapping("transaction")
public class TransactionController {
	
	@Autowired
	@Qualifier("PurchaseTransactionServiceImpl")
	TransactionService purchaseTransactionServiceImpl ;
	
	@Autowired
	@Qualifier("SaleTransactionServiceImpl")
	TransactionService saleTransactionServiceImpl ;
	
	
	@RequestMapping("/")
	public ModelAndView getHomePage(Model model,PurchaseTransactionFormBean purchaseTransactionFormBean,SaleTransactionFormBean saleTransactionFormBean)
	{
		model.addAttribute("purchaseTransactionFormBean", purchaseTransactionFormBean);
		model.addAttribute("saleTransactionFormBean", saleTransactionFormBean);
		
		return new ModelAndView("transaction");
		
	}
	
	@RequestMapping(value = "purchaseTransaction", method = RequestMethod.POST)
	public ModelAndView createTransaction(@ModelAttribute("purchaseTransactionFormBean") PurchaseTransactionFormBean purchaseTransactionFormBean,ModelAndView modelAndView) throws Exception
	{
		purchaseTransactionServiceImpl.createTransaction(purchaseTransactionFormBean.convertToTransactionEntity());		
		return new ModelAndView("index");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
