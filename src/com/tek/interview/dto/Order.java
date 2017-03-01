/**
 * 
 */
package com.tek.interview.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author H156759
 *
 */
public class Order {

private List<OrderLine> orderLines;
	
	public Order() {
		orderLines = new ArrayList<OrderLine>();
	}

	public void add(OrderLine o) throws Exception {
		if (o == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		orderLines.add(o);
	}

	public int size() {
		return orderLines.size();
	}

	public OrderLine get(int i) {
		return orderLines.get(i);
	}

	public void clear() {
		this.orderLines.clear();
	}
}
