package com.storemgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.storemgmt.bean.ConfigurableParameterFormBean;
import com.storemgmt.bean.ProductCategoryBean;
import com.storemgmt.service.ConfigurableParameterService;

@Controller
@RequestMapping("/configurableParameters")
public class ConfigurableParameterController {

	@Autowired
	ConfigurableParameterService configurableParameterService;
	
	
	@RequestMapping("/")
	public ModelAndView getAllConfigParameters(Model model)
	{
		model.addAttribute("productCategoryList", configurableParameterService.getProductCategories());
		model.addAttribute("productSubCategoryList", configurableParameterService.getProductSubCategories());
		model.addAttribute("configurableParameterFormBean", new ConfigurableParameterFormBean());
		
		return new ModelAndView("/configurableParameter/home");
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView addConfigurableParameter(@ModelAttribute("configurableParameterFormBean") ConfigurableParameterFormBean configurableParameterFormBean,BindingResult result)
	{
		
		if(configurableParameterFormBean.getConfigurationName().equals("productCategory"))
		{
			if(configurableParameterFormBean.getProductCategoryName() == null)
			{
				result.addError(new FieldError("configurableParameterFormBean", "productCategoryName","Category Name Cannot be null"));
				return new ModelAndView("/configurableParameters");
			}
			configurableParameterService.insertProductType(configurableParameterFormBean);			
		}
		else if(configurableParameterFormBean.getConfigurationName().equals("productSubCategory"))
		{
			if(configurableParameterFormBean.getProductCategoryId() == 0)
			{
				result.addError(new FieldError("configurableParameterFormBean", "productSubCategoryName","Sub Category Name Cannot be null"));
				return new ModelAndView("/configurableParameters");
			}
			
			configurableParameterService.insertProductSubType(configurableParameterFormBean);			
		
		}
		
		return new ModelAndView("redirect:/configurableParameters/");
	}
}
