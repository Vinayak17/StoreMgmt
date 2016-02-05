package com.storemgmt.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.storemgmt.bean.ProductFormBean;
import com.storemgmt.model.ProductEntity;
import com.storemgmt.service.ConfigurableParameterService;
import com.storemgmt.service.ProductService;


@Controller
@RequestMapping(value = {"product"})
@Transactional
public class ProductController {

	@Autowired
	protected ProductService productServiceImpl;
	
	@Autowired
	private ConfigurableParameterService configurableParameterService;
	
	protected Validator validator;
	
	@Autowired
	protected ValidatorFactory factory;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView productsHomePage(Model model)
	{
		List<ProductFormBean> productList = productServiceImpl.getProducts();
		model.addAttribute("productList", productList);
		return new ModelAndView("products");
	}
	
	@RequestMapping(value="/productEntry")
	public ModelAndView productEntryPage(Model model,ProductFormBean productFormBean)
	{
		configurableParameterService.insertProductType();
		configurableParameterService.insertProductSubType();
		model.addAttribute("productFormBean", productFormBean);
		model.addAttribute("productTypes", configurableParameterService.getAllProductTypes());
		return new ModelAndView("productEntry");
	}

	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public ModelAndView addOrUpdateProduct(@ModelAttribute("productFormBean") ProductFormBean productFormBean,BindingResult result,Model model) throws Exception
	{
		
		validator = factory.getValidator();
		Set<ConstraintViolation<ProductFormBean>> constraintViolations = validator.validate( productFormBean );
		for(ConstraintViolation<ProductFormBean> x : constraintViolations)
		{
			result.addError(new FieldError("productFormBean", x.getPropertyPath().toString(), x.getMessage()) );
		}
		
		if(result.hasErrors())
		{
			return productsHomePage(model);
		}
		
		if(productFormBean.getProdId() == 0)
		{ 			
			productServiceImpl.addProduct(productFormBean);
		}
		else
		{
			productServiceImpl.updateProduct(productFormBean);
		}
		return new ModelAndView("redirect:/product/");
		
	}

	@RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
	public String editProduct(@PathVariable("id") long productId,Model model)throws Exception
	{
		model.addAttribute("productFormBean", ProductFormBean.toProductFormBean(productServiceImpl.getProductById(productId)));
		List<ProductFormBean> fetchedProductFormBeanList = productServiceImpl.getProducts();
		model.addAttribute("productList", fetchedProductFormBeanList);
		return "products";

	}



}
