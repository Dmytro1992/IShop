package net.iship.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.ishop.entity.Order;
import net.ishop.model.CurrentAccount;
import net.ishop.model.ShoppingCart;
import net.ishop.model.SocialAccount;
import net.ishop.service.OrderService;
import net.ishop.service.impl.OrderServiceImpl;
import net.ishop.service.impl.ServiceManager;

public class OrderServiceImplTest {

	private  DataSource dataSource = null;
	private OrderService os = null;
	private CurrentAccount ac = null;
	
	@Before
	public void load() {
		dataSource = new ServiceManager().createDataSource();
		os = new OrderServiceImpl(dataSource);
		ac = os.authentificate(new SocialAccount("Dmitry", "dishumov@yandex.ru"));
	}
	
	@Test
	public void deserializeShoppingCartTest() {
		ShoppingCart cart = os.deserializeShoppingCart("278197-1");
		Assert.assertEquals(1, cart.getTotalCount());
	}
	 
	@Test
	public void serializeShoppingCartTest() {
		ShoppingCart cart = os.deserializeShoppingCart("278197-1");
		String sCart = os.serializeShoppingCart(cart);
		Assert.assertEquals("278197-1", sCart);
	}
	
	@Test
	public void authentificateTest() {
		
		Assert.assertEquals("Dmitry(dishumov@yandex.ru)", ac.getDescription());
	}
	
	@Test
	public void makeOrderTest() {
		
		ShoppingCart cart = os.deserializeShoppingCart("278197-1");
		long id = os.makeOrder(cart, ac);
		Assert.assertEquals(1, id);
	}
	
	@Test
	public void findOrderByIdTest() {
		
		Order order = os.findOrderById(1, ac);
		long id = order.getId();
		Assert.assertEquals(1L, id);
	}
	
	@Test
	public void listMyOrdersTest() {
		
		List<Order> listMyOrders = os.listMyOrders(ac, 1, 1);
		Assert.assertEquals(1, listMyOrders.size());
	}
	
	@Test
	public void countMyOrdersTest() {
		
		int count = os.countMyOrders(ac);
		Assert.assertEquals(1, count);
	}
	
}
