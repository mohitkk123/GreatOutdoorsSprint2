package com.cg.greatOutdoors.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.greatOutdoors.dao.ProductDaoI;
import com.cg.greatOutdoors.dao.ProductDaoImp;
import com.cg.greatOutdoors.entity.Product;
import com.cg.greatOutdoors.exception.ProductException;
@Transactional
@Service
public class ProductServiceImp  implements ProductServiceI{
	
	@Autowired
	ProductDaoI pDao;
	
	
	
	// ------------------------ GreatOutdoor Application --------------------------
			/*******************************************************************************************************
			 * - Function Name : getAllProducts - Input Parameters :- Return Type :
			 * List<Product>  - Author : Mohit kumar Mastana -
			 * Creation Date : 28/04/2020 - Description : to get all product from the
			 * database
			 * 
			
			 ********************************************************************************************************/

	@Override
	public List<Product> getAllProducts() { 
		// TODO Auto-generated method stub
		return pDao.getProducts();
	}
	
	// ------------------------ GreatOutdoor Application --------------------------
			/*******************************************************************************************************
			 * - Function Name : addProduct - Input Parameters : Product product Return Type :
			 * int id  - Author : Mohit kumar Mastana -
			 * Creation Date : 28/04/2020 - Description : to add a product to the
			 * database
			 * 
			
			 ********************************************************************************************************/

	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		
		 
		return pDao.insertProduct(product);
	}
	
	// ------------------------ GreatOutdoor Application --------------------------
			/*******************************************************************************************************
			 * - Function Name : deleteProducts - Input Parameters : int id Return Type :
			 * boolean  - Author : Mohit kumar Mastana -
			 * Creation Date : 28/04/2020 - Description : to delete a product from the
			 * database
			 * 
			
			 ********************************************************************************************************/

	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		
		int check= pDao.deleteItem(id);
		if(check==id) {
			return true;
			
		}else {
			return false;
		}
	}
	
	// ------------------------ GreatOutdoor Application --------------------------
			/*******************************************************************************************************
			 * - Function Name : getSearchedProducts - Input Parameters : String name Return Type :
			 * List<Product>  - Author : Mohit kumar Mastana -
			 * Creation Date : 28/04/2020 - Description : to search a product to the
			 * database
			 * 
			
			 ********************************************************************************************************/
	
	public List<Product> getSearchedProducts(String name) {
		// TODO Auto-generated method stub
		return pDao.searchProduct(name);
	}
	

	//------------------------ GreatOutdoor Application --------------------------
			/*******************************************************************************************************
			 * - Function Name : getCategoryProduct - Input Parameters : String name Return Type :
			 * List<Product>  - Author : Mohit kumar Mastana -
			 * Creation Date : 28/04/2020 - Description : to get a product from given category from the
			 * database
			 * 
			
			 ********************************************************************************************************/
	
	public List<Product> getCategoryProducts(String name) {
		// TODO Auto-generated method stub
	return pDao.searchCategoryProduct(name);
	}
	
	//------------------------ GreatOutdoor Application --------------------------
			/*******************************************************************************************************
			 * - Function Name : editProduct - Input Parameters : Product product Return Type :
			 * int id  - Author : Mohit kumar Mastana -
			 * Creation Date : 28/04/2020 - Description : to edit a product from the
			 * database
			 * 
			
			 ********************************************************************************************************/
	
	public int editProduct(Product product) {
		// TODO Auto-generated method stub
		return pDao.editProduct(product);
	}

}
