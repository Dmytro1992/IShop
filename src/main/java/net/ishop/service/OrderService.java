package net.ishop.service;

import java.util.List;

import net.ishop.entity.Order;
import net.ishop.form.ProductForm;
import net.ishop.model.CurrentAccount;
import net.ishop.model.ShoppingCart;
import net.ishop.model.SocialAccount;

public interface OrderService {

	void addProductToShoppingCart(ProductForm productForm, ShoppingCart shoppingCart);

	String serializeShoppingCart(ShoppingCart shoppingCart);

	ShoppingCart deserializeShoppingCart(String string);

	CurrentAccount authentificate(SocialAccount socialAccount);

	long makeOrder(ShoppingCart shoppingCart, CurrentAccount currentAccount);

	Order findOrderById(long id, CurrentAccount currentAccount);

	List<Order> listMyOrders(CurrentAccount currentAccount, int page, int limit);

	int countMyOrders(CurrentAccount currentAccount);
	
	//hw
	//remove one product from shopping cart
	void removeProductFromShoppingCart(ProductForm form, ShoppingCart shoppingCart);
	//add one product from shopping cart
	void addOneProductToShoppingCart(ProductForm form, ShoppingCart shoppingCart);
}
