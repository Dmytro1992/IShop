package net.ishop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import net.ishop.Constants;
import net.ishop.entity.Product;
import net.ishop.exception.ValidationException;


public class ShoppingCart implements Serializable {
	private static final long serialVersionUID = 1535770438453611801L;
	private Map<Integer, ShoppingCartItem> products = new LinkedHashMap<>();
	private int totalCount = 0;
	private BigDecimal totalCost = BigDecimal.ZERO;

	public void addProduct(Product product, int count) {
		validateShoppingCartSize(product.getId());
		ShoppingCartItem shoppingCartItem = products.get(product.getId());
		if (shoppingCartItem == null) {
			validateProductCount(count);
			shoppingCartItem = new ShoppingCartItem(product, count); 
			products.put(product.getId(), shoppingCartItem);
		} else {
			validateProductCount(count + shoppingCartItem.getCount());
			shoppingCartItem.setCount(shoppingCartItem.getCount() + count);
		}
		refreshStatistics();
	}
// delete one product  
	public void removeProduct(Integer idProduct, int count) {
		ShoppingCartItem shoppingCartItem = products.get(idProduct);
		if (shoppingCartItem != null) {
			if (shoppingCartItem.getCount() > count) {
				shoppingCartItem.setCount(shoppingCartItem.getCount() - count);
			} else {
				products.remove(idProduct);
			}
			refreshStatistics();
		}
	}
	// add count product
	public void addCountProduct(Integer idProduct, int count) {
		ShoppingCartItem shoppingCartItem = products.get(idProduct);
		if (shoppingCartItem != null) {
				shoppingCartItem.setCount(shoppingCartItem.getCount() + count);
			} 
			refreshStatistics();
		}

	public Collection<ShoppingCartItem> getItems() {
		return products.values();
	}

	public int getTotalCount() {
		return totalCount;
	}
	
	public BigDecimal getTotalCost() {
		return totalCost;
	}
	
	private void validateProductCount(int count) {
		if(count > Constants.MAX_PRODUCT_COUNT_PER_SHOPPING_CART){
			throw new ValidationException("Limit for product count reached: count="+count);
		}
	}
	
	private void validateShoppingCartSize(int idProduct){
		if(products.size() > Constants.MAX_PRODUCTS_PER_SHOPPING_CART || 
				(products.size() == Constants.MAX_PRODUCTS_PER_SHOPPING_CART && !products.containsKey(idProduct))) {
			throw new ValidationException("Limit for ShoppingCart size reached: size="+products.size());
		}
	}

	private void refreshStatistics() {
		totalCount = 0;
		totalCost = BigDecimal.ZERO;
		for (ShoppingCartItem shoppingCartItem : getItems()) {
			totalCount += shoppingCartItem.getCount();
			totalCost = totalCost.add(shoppingCartItem.getProduct().getPrice().multiply(BigDecimal.valueOf(shoppingCartItem.getCount())));
		}
	}

	@Override
	public String toString() {
		return String.format("ShoppingCart [products=%s, totalCount=%s, totalCost=%s]", products, totalCount, totalCost);
	}
}
