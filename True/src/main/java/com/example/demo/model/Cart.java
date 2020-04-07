package com.example.demo.model;

import java.util.*;

public class Cart {
	private List<MenuItem> menuItemList;
	private double total;

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cart(List<MenuItem> menuItemList, double total) {
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public Cart() {
		super();
	}

	@Override
	public String toString() {
		return "Cart [menuItemList=" + menuItemList + ", total=" + total + "]";
	}

}
