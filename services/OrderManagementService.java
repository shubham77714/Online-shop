package oops.exercises.online_shop.services;

import java.util.Arrays;
import java.util.Objects;

import oops.exercises.online_shop.entities.Order;

public class OrderManagementService {
	private static OrderManagementService instance;
	
	private static final int DEFAULT_ORDER_CAPACITY=10;
	private Order[] orders;
	private int lastOrderIndex;
	
	{
		orders=new Order[DEFAULT_ORDER_CAPACITY];
	}
	
	public OrderManagementService() {
	}
	
	public static OrderManagementService getInstance() {
		if(instance==null)
			instance= new OrderManagementService();
		return instance;
	}
	
	public void addOrder(Order order) {
		if(order==null)
			return;
		if(orders.length>=lastOrderIndex)
			orders= Arrays.copyOf(orders,lastOrderIndex + DEFAULT_ORDER_CAPACITY);
		
		orders[lastOrderIndex++]=order;
	}
	
	public Order[] getOrderByUserId(int userId) {
		return Arrays.stream(orders).filter(Objects::nonNull).
				filter(order->order.getCustomerId() == userId).toArray(Order[]::new);
	}
	
	void clearServiceState() {
		lastOrderIndex=0;
		orders=new Order[DEFAULT_ORDER_CAPACITY];
	}
}
