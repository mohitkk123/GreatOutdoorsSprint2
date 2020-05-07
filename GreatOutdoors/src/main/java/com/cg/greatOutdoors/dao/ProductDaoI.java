package com.cg.greatOutdoors.dao;

import java.util.List;

import com.cg.greatOutdoors.entity.Product;

public interface ProductDaoI {
	// ------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : getProducts - Input Parameters :  Return Type :
				 * List<Product>  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to get all product from the
				 * database
				 * 
				
				 ********************************************************************************************************/
	public List<Product> getProducts(); 
	
	// ------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : insertProduct - Input Parameters : Product product Return Type :
				 * int id  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to add a product to the
				 * database
				 * 
				
				 ********************************************************************************************************/
	
	public int insertProduct(Product product);
	
	// ------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : deleteItem - Input Parameters : int id Return Type :
				 * int id  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to delete a product from the
				 * database
				 * 
				
				 ********************************************************************************************************/
	
	public int deleteItem(int id);
	
	// ------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : searchProduct - Input Parameters : String name Return Type :
				 * List<Product>  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to search a product from the
				 * database
				 * 
				
				 ********************************************************************************************************/
	
	public List<Product> searchProduct(String name);
	
	//------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : getCategoryProduct - Input Parameters : String name Return Type :
				 * List<Product>  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to get a product from given category from the
				 * database
				 * 
				
				 ********************************************************************************************************/
	
	public List<Product> searchCategoryProduct(String name);
	
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
  