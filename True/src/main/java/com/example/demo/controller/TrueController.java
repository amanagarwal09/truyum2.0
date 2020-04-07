package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.MenuItem;
import com.example.demo.service.impl.CartServiceImpl;
import com.example.demo.service.impl.MenuItemServiceImpl;

@Controller
public class TrueController {

	@Autowired
	private MenuItemServiceImpl menuServiceImpl;

	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	long custId = 1;
	
	@RequestMapping(value = "/")
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = "getMenuAdmin")
	public ModelAndView getMenuItem() {
		ModelAndView mv = new ModelAndView();
		List<MenuItem> list = menuServiceImpl.getMenuItemListAdmin();
		mv.addObject("adminlist", list);
		mv.setViewName("getMenuAdmin");
		return mv;
	}

	@RequestMapping(value = "getMenuCustomer")
	public ModelAndView getMenuCustomerItem() {
		ModelAndView mv = new ModelAndView();
		List<MenuItem> list = menuServiceImpl.getMenuItemListCustomer();
		mv.addObject("customerlist", list);
		mv.setViewName("getMenuCustomer");
		return mv;
	}

	@RequestMapping(value = "getMenuCustomerId", method = RequestMethod.GET)
	public ModelAndView getMenuCustomerById() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("getMenuCustomerId");
		return mv;
	}

	@RequestMapping(value = "getMenuCustomerId", method = RequestMethod.POST)
	public ModelAndView getMenuCustomerById(@ModelAttribute("getMenuCustomerId") MenuItem menuItem) {
		ModelAndView mv = new ModelAndView();
		custId = menuItem.getId();
		List<MenuItem> list = menuServiceImpl.getMenuItemListCustomer();
		mv.addObject("customerlist", list);
		mv.setViewName("getMenuCustomer");
		return mv;
	}
	
	@RequestMapping(value = "modify", method = RequestMethod.GET)
	public ModelAndView modify(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.setViewName("modifyAdmin");
		return mv;
	}

	@RequestMapping(value = "updateAdmin", method = RequestMethod.POST)
	public ModelAndView modifyPage(@ModelAttribute("modifyAdmin") MenuItem menuItem) {
		System.out.println(menuItem);
		ModelAndView mv = new ModelAndView();
		int modifyMenuItem = menuServiceImpl.modifyMenuItem(menuItem);
		if (modifyMenuItem == 1) {
			mv.addObject("msg", "Menu Item Details Saved Successfully");
		} else {
			mv.addObject("msg", "Menu Item Details Not Saved Successfully");
		}
		mv.setViewName("modifyAdminSuccess");
		return mv;
	}

	@RequestMapping(value = "addToCart", method = RequestMethod.GET)
	public ModelAndView addtocart(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		int addCartItem = cartServiceImpl.addCartItem(custId, id);
		if (addCartItem == 1) {
			mv.addObject("msg", "Cart Item Added");
		} else {
			mv.addObject("msg", "Cart Item Not Added It is Present ");
		}
		List<MenuItem> list = menuServiceImpl.getMenuItemListCustomer();
		mv.addObject("customerlist", list);
		mv.setViewName("getMenuCustomer");
		return mv;
	}

	@RequestMapping(value = "getCart")
	public ModelAndView getcart() {
		ModelAndView mv = new ModelAndView();
		List<MenuItem> list = cartServiceImpl.getAllCartItems(custId);
		double cost = 0;
		for (MenuItem i : list) {
			cost += i.getPrice();
		}
		if (list.isEmpty()) {
			mv.setViewName("BlankCart");
			return mv;
		}
		mv.addObject("total", cost);
		mv.addObject("customerlist", list);
		mv.setViewName("addToCart");
		return mv;
	}

	@RequestMapping(value = "deleteCart", method = RequestMethod.GET)
	public ModelAndView deletefromcart(@RequestParam("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		int removecartitem = cartServiceImpl.removeCartItem(custId, id);
		if (removecartitem == 1) {
			mv.addObject("msg", "Item Removed From the Cart");
		} else {
			mv.addObject("msg", "Item not Removed From the Cart");
		}
		List<MenuItem> list = cartServiceImpl.getAllCartItems(custId);
		double cost = 0;
		for (MenuItem i : list) {
			cost += i.getPrice();
		}
		if (list.isEmpty()) {
			mv.setViewName("BlankCart");
			return mv;
		}
		System.out.println(cost);
		mv.addObject("total", cost);
		mv.addObject("customerlist", list);
		mv.setViewName("addToCart");
		return mv;
	}

}
