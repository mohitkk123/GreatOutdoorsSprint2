package com.cg.greatOutdoors.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.greatOutdoors.entity.Product;

@Repository

public class ProductDaoImp implements ProductDaoI{
	
	// this class is wired with the entityManager to do some operation in the
		// database
	
	@PersistenceContext
	EntityManager em; 
	
	     // ------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : getProducts - Input Parameters :  Return Type :
				 * List<Product>  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to get all product from the
				 * database
				 * 
				
				 ********************************************************************************************************/

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
	String qStr="SELECT product FROM Product product";
		TypedQuery<Product> query=em.createQuery(qStr,Product.class);
		
		return query.getResultList();
	} 
	
		// ------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : insertProduct - Input Parameters : Product product Return Type :
				 * int id  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to add a product to the
				 * database
				 * 
				
				 ********************************************************************************************************/

	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		
		em.persist(product);
		
		return product.getId();
		
	}
	
	   // ------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : deleteItem - Input Parameters : int id Return Type :
				 * int id  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to delete a product from the
				 * database
				 * 
				
				 ********************************************************************************************************/

	public int deleteItem(int id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
			
		Product p=	em.find(Product.class, id);
		if(p!=null) {
			em.remove(p);
			return p.getProductid();
		}else {
			return 0;
		}
		
		
	}
	
		// ------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : searchProduct - Input Parameters : String name Return Type :
				 * List<Product>  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to search a product from the
				 * database
				 * 
				
				 ********************************************************************************************************/


public List<Product> searchProduct(String name) {
	// TODO Auto-generated method stub
	
	String qStr="SELECT product FROM Product product where product.productName like '%"+(name)+"%'";
	TypedQuery<Product> query=em.createQuery(qStr,Product.class);
	//query.setParameter("name", name);
	
	return query.getResultList();
}


	   //------------------------ GreatOutdoor Application --------------------------
				/*******************************************************************************************************
				 * - Function Name : getCategoryProduct - Input Parameters : String name Return Type :
				 * List<Product>  - Author : Mohit kumar Mastana -
				 * Creation Date : 28/04/2020 - Description : to get a product from given category from the
				 * database
				 * 
				
		 ********************************************************************************************************/

public List<Product> searchCategoryProduct(String name) {
	// TODO Auto-generated method stub
	String qStr="SELECT product FROM Product product where product.productCategory='"+(name)+"'";
	TypedQuery<Product> query=em.createQuery(qStr,Product.class);
	return query.getResultList();
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
	Product oldProduct=em.find(Product.class,product.getProductid());
	
	if(oldProduct!=null) {
		oldProduct.setProductName(product.getProductName());
		oldProduct.setProductCategory(product.getProductCategory());
		oldProduct.setProductcost(product.getProductcost());
		oldProduct.setProductDescription(product.getProductDescription());
		oldProduct.setProductManufacturer(product.getProductManufacturer());
		oldProduct.setProductQuantity(product.getProductQuantity());
		
		Product  newProduct=em.merge(oldProduct);
		return newProduct.getProductid();
	}else {
		return 0;
	}
}

}
