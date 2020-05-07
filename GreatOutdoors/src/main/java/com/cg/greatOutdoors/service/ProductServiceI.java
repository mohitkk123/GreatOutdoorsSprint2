package com.cg.greatOutdoors.service;
import java.util.List;


import com.cg.greatOutdoors.entity.Product;
public interface ProductServiceI {
	
	// ------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : getAllProducts - Input Parameters :- Return Type :
				 * List<Product>  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to get all product from the
				 * database
				 * 
				
				 ********************************************************************************************************/
	public List<Product> getAllProducts(); 
	
	// ------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : addProduct - Input Parameters : Product product Return Type :
				 * int id  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to add a product to the
				 * database
				 * 
				
				 ********************************************************************************************************/
	
	public int addProduct(Product product);
	
	// ------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : deleteProducts - Input Parameters : int id Return Type :
				 * boolean  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to delete a product from the
				 * database
				 * 
				
				 ********************************************************************************************************/
		
	
	public List<Product> getSearchedProducts(String name);
	
	// ------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : getSearchedProducts - Input Parameters : String name Return Type :
				 * List<Product>  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to search a product to the
				 * database
				 * 
				
				 ********************************************************************************************************/
	
	public boolean deleteProduct(int id);
	
	//------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : getCategoryProduct - Input Parameters : String name Return Type :
				 * List<Product>  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to get a product from given category from the
				 * database
				 * 
				
				 ********************************************************************************************************/
	
	public List<Product> getCategoryProducts(String name);
	
	//------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : editProduct - Input Parameters : Product product Return Type :
				 * int id  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to edit a product from the
				 * database
				 * 
				
				 ********************************************************************************************************/
	
	public int editProduct(Product product);

}
 