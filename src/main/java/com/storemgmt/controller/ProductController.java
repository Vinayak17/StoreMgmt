package com.storemgmt.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.storemgmt.bean.ProductFormBean;
import com.storemgmt.model.ProductEntity;
import com.storemgmt.service.ProductService;


@Controller
@RequestMapping(value = {"product"})
public class ProductController {

	@Autowired
	@Qualifier("ProductServiceImpl")
	ProductService productServiceImpl;
	
	Validator validator;
	 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView productsHomePage(Model model,ProductFormBean productFormBean)
	{
		
		List<ProductEntity> productList = productServiceImpl.getProducts();
		model.addAttribute("productList", productList);
		model.addAttribute("productFormBean", productFormBean);
		return new ModelAndView("products");
	}
	
	@RequestMapping(value ="add", method = RequestMethod.POST)
	public ModelAndView addNewProduct(@Valid @ModelAttribute("productFormBean") ProductFormBean productFormBean,BindingResult result,Model model)
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	     validator = factory.getValidator();
		
		Set<ConstraintViolation<ProductFormBean>> constraintViolations =
                validator.validate( productFormBean );
		
		System.out.println(constraintViolations.iterator().next().getMessage());
		System.out.println(" Hello " +productFormBean.getProdName());
		productFormBean.convertProductFormBeanToEntity(productFormBean);
		System.out.println(result.hasErrors());
		return new ModelAndView("products");
	}
}