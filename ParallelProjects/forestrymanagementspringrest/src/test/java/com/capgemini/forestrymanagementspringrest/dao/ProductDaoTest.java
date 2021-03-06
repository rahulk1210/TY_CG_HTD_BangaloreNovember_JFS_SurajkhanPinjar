package com.capgemini.forestrymanagementspringrest.dao;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.capgemini.forestrymanagementspringrest.config.ORMConfig;
import com.capgemini.forestrymanagementspringrest.dao.ProductDao;
import com.capgemini.forestrymanagementspringrest.dto.Product;
import com.capgemini.forestrymanagementspringrest.testconfig.TestBeans;

@SpringJUnitConfig(classes = {TestBeans.class, ORMConfig.class})
class ProductDaoTest {
	@Autowired
	ProductDao productDao;
	
	@Test
	public void testAddProduct() {
		Product product = new Product();
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		assertTrue(productDao.addProduct(product));
		
	}

	@Test
	public void testDeleteProduct() {
		assertTrue(productDao.deleteProduct(786));
	}

	@Test
	public void testModifyProduct() {
		Product product = new Product();
		product.setProductId(786);
		product.setProductName("Wood");
		product.setQuantity("10Kg");
		productDao.addProduct(product);
		assertTrue(productDao.modifyProduct(product));
		productDao.deleteProduct(product.getProductId());
	}

	@Test
	public void testGetAllProduct() {
		assertNotNull(productDao.getAllProduct());
		
	}

}
