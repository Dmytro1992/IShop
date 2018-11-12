package net.iship.service.impl;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;

import net.ishop.entity.Category;
import net.ishop.entity.Producer;
import net.ishop.entity.Product;
import net.ishop.form.SearchForm;
import net.ishop.service.ProductService;
import net.ishop.service.impl.ProductServiceImpl;
import net.ishop.service.impl.ServiceManager;

public class ProductServiceImplTest {
	
	private final DataSource dataSource = new ServiceManager().createDataSource();
	ProductService ps = new ProductServiceImpl(dataSource);
	
	 
	
	@Test
	public void listAllProductsTest(){
		List<Product> listAllProducts =	ps.listAllProducts(1,2);
		Assert.assertEquals(2, listAllProducts.size());
	}
	
	@Test
	public void listProductsByCategoryTest(){
		List<Product> listProducts = ps.listProductsByCategory("/phone", 1, 5);
		Assert.assertEquals(5, listProducts.size());
		
	}
	
	@Test
	public void listAllCategoriesTest(){
		List<Category> listAllCategorys = ps.listAllCategories();
		Assert.assertEquals(7, listAllCategorys.size());
	}
	
	@Test
	public void listAllProducersTest(){
		List<Producer> listAllProducts = ps.listAllProducers();
		Assert.assertEquals(25, listAllProducts.size());
	}
	
	@Test
	public void countAllProductsTest(){
		int countAllProducts = ps.countAllProducts();
		Assert.assertEquals(824, countAllProducts);
	}
	
	@Test
	public void countProductsByCategoryTest(){
		int countAllProducts = ps.countProductsByCategory("/tablet");
		Assert.assertEquals(161, countAllProducts);
	}
	
	@Test
	public void listProductsBySearchFormTest(){
		List<Product> listProducts = ps.listProductsBySearchForm(new SearchForm("aser", new String[]{"3","14"}, new String[]{"14","3"}), 10, 50);
		Assert.assertEquals(30, listProducts.size());
		}
	
	@Test
	public void countProductsBySearchFormTest(){
		int countAllProducts = ps.countProductsBySearchForm(new SearchForm("xcvx", new String[]{"3","14"}, new String[]{"14","3"}));
		Assert.assertEquals(0, countAllProducts);
	}
}
