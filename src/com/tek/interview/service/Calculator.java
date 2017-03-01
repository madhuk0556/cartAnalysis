/**
 * 
 */
package com.tek.interview.service;

import java.util.Map;

import com.tek.interview.dto.Order;
import com.tek.interview.util.ApplicationUtil;

/**
 * @author H156759
 *
 */
public class Calculator {

	/**
	 * receives a collection of orders. For each order, iterates on the order
	 * lines and calculate the total price which is the item's price * quantity
	 * * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without
	 * taxes for this order
	 */
	public void calculate(Map<String, Order> o) {

		double grandtotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");

			Order r = entry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			for (int i = 0; i < r.size(); i++) {

				// Calculate the taxes
				double tax = 0;

				if (r.get(i).getItem().getDescription().contains("Imported")) {
					tax = ApplicationUtil.rounding(r.get(i).getItem().getPrice() * 0.15,2); // Extra
																			// 5%
																			// tax
																			// on
					// imported items
				} else {
					tax = ApplicationUtil.rounding(r.get(i).getItem().getPrice() * 0.10,2);
				}

				// Calculate the total price
				double totalprice = r.get(i).getItem().getPrice() + tax;

				// Print out the item's total price
				System.out.println(r.get(i).getItem().getDescription() + ": " + ApplicationUtil.rounding(totalprice,2));

				// Keep a running total
				totalTax += tax;
				total += ApplicationUtil.rounding(r.get(i).getItem().getPrice(),2);
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + ApplicationUtil.rounding(totalTax,2));

			// Print out the total amount
			System.out.println("Total: " + ApplicationUtil.rounding(total , 2));
			grandtotal += ApplicationUtil.rounding((total),2);
		}

		System.out.println("Sum of orders: " + Math.floor(grandtotal * 100) / 100);
	}
}
