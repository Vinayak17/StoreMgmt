package com.storemgmt.controller;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	
	@Autowired
	private MessageSource messageSource;
	
	Logger logger = Logger.getLogger(ProductController.class);
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {

	    binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true));

	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView productsHomePage(Model model)
	{
		logger.debug("Entering productsHomePage(Model)");
		
		List<ProductFormBean> productList = productServiceImpl.getProducts();
		model.addAttribute("productList", productList);
		
		logger.debug("Returning from productsHomePage(Model)");
		
		return new ModelAndView("products");
	}
	
	@RequestMapping(value="/productEntry")
	public ModelAndView productEntryPage(Model model,ProductFormBean productFormBean,BindingResult result)
	{
		logger.debug("Entering productEntryPage(Model,ProductFormBean,BindingResult)");
		
		//configurableParameterService.insertProductType();
		//configurableParameterService.insertProductSubType();
		model.addAttribute("productFormBean", productFormBean);
		model.addAttribute("productTypeList", configurableParameterService.getProductCategories());
		model.addAttribute("productSubTypeList", configurableParameterService.getProductSubCategories());
		model.addAttribute("measurementScaleList", ProductService.MeasurementScale.values());
		model.addAttribute("pageResult",result);
		
		logger.debug("Returning from productEntryPage(Model,ProductFormBean,BindingResult)");
		
		return new ModelAndView("productEntry");
				
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public ModelAndView addOrUpdateProduct(@ModelAttribute("productFormBean") ProductFormBean productFormBean,BindingResult result,Model model) throws Exception
	{
		logger.debug("Entering function addOrUpdateProduct(ProductFormBean,BindingResult,Model)");
		
		validator = factory.getValidator();
		Set<ConstraintViolation<ProductFormBean>> constraintViolations = validator.validate( productFormBean );
		for(ConstraintViolation<ProductFormBean> x : constraintViolations)
		{
			//result.addError(new FieldError("productFormBean", x.getPropertyPath().toString(), messageSource.getMessage("NotEmpty.productFormBean.prodName", new String []{productFormBean.getProdName()}, Locale.getDefault())) );
			result.addError(new FieldError("productFormBean", x.getPropertyPath().toString(), x.getMessage()));
		}
		
		if(result.hasErrors())
		{
			logger.debug("Validation Errors found in the ProductFormBean");			
			logger.debug("Returning from addOrUpdateProduct(ProductFormBean,BindingResult,Model)");
			
			return productEntryPage(model,productFormBean,result);
		}
		
		if(productFormBean.getProdId() == 0)
		{
			if(productServiceImpl.searchForDuplicateProductName(productFormBean.getProdName()))
			{
				result.addError(new FieldError("productFormBean", "prodName", "Duplicate Product Name Exist"));
				
				logger.debug("Validation Errors found in the ProductFormBean");			
				logger.debug("Returning from addOrUpdateProduct(ProductFormBean,BindingResult,Model)");
				
				return productEntryPage(model,productFormBean,result);
			}
			
			productServiceImpl.addProduct(productFormBean);
		}
		else
			productServiceImpl.updateProduct(productFormBean);
				
		logger.debug("Returning from addOrUpdateProduct(ProductFormBean,BindingResult,Model)");
		
		return new ModelAndView("redirect:/product/");
		
	}

	@RequestMapping(value="/edit/{id}",method = RequestMethod.GET)
	public String editProduct(@PathVariable("id") long productId,Model model)throws Exception
	{
		logger.debug("Entering function editProduct(long,Model)");
		
		model.addAttribute("productFormBean", ProductFormBean.toProductFormBean(productServiceImpl.getProductById(productId)));
		model.addAttribute("productTypeList", configurableParameterService.getProductCategories());
		model.addAttribute("productSubTypeList", configurableParameterService.getProductSubCategories());
		model.addAttribute("measurementScaleList", ProductService.MeasurementScale.values());
		logger.debug("Returning from editProduct(long,Model)");
		
		return "productEntry";

	}



}
