/**
 * 
 */
package com.tek.interview.main;

import java.util.Map;
import java.util.TreeMap;

import com.tek.interview.dto.Item;
import com.tek.interview.dto.Order;
import com.tek.interview.dto.OrderLine;
import com.tek.interview.service.Calculator;

/**
 * @author H156759
 *
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Order> o = new TreeMap<String, Order>();

		Order c1 = new Order();
		Order c2 = new Order();
		Order c3 = new Order();

		try {
			c1.add(new OrderLine(new Item("book", (float) 12.49), 1));

			c1.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
			c1.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

			o.put("Order 1", c1);

			c2.add(new OrderLine(new Item("Imported box of chocolate", 10), 1));
			c2.add(new OrderLine(new Item("Imported bottle of perfume", (float) 47.50), 1));

			o.put("Order 2", c2);

			c3.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
			c3.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
			c3.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
			c3.add(new OrderLine(new Item("box of Imported chocolates", (float) 11.25), 1));

			o.put("Order 3", c3);

			new Calculator().calculate(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
