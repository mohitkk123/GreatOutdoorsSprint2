package com.cg.greatOutdoors.controller;

import com.cg.greatOutdoors.entity.Product;
import com.cg.greatOutdoors.exception.ProductException;

import com.cg.greatOutdoors.service.ProductServiceI;
import com.cg.greatOutdoors.service.ProductServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ProductDashController {
	
	//this is the controller class for products management
	
		@Autowired
		ProductServiceI pService;
		
		 
		@GetMapping("/")
		public String getDashboard() {
			return "Welcome to your dashboard";
		}   
		
		// ------------------------ GreatOutdoor Application --------------------------
		/*******************************************************************************************************
		 * - Function Name : getProducts - Input Parameters : - Return Type :
		 * List<Product> - Throws : ProductException - Author : Mohit kumar Mastana -
		 * Creation Date : 28/04/2020 - Description : to get all the product from the
		 * database
		 * 
		 * @throws ProductException
		 ********************************************************************************************************/
		
		
		@GetMapping("/dashboard/Products")
		public List<Product> getProducts() {
			
			List<Product> products=pService.getAllProducts();
			
				if(products.size()==0) {
					throw new ProductException("there are not products yet");
				}else {

					return products;
				}
			
		}
		
		// ------------------------ GreatOutdoor Application --------------------------
			/*******************************************************************************************************
			 * - Function Name : addProduct - Input Parameters : Product p Return Type :
			 * ResponseEntity<Integer> - Throws : ProductException - Author : Mohit kumar Mastana -
			 * Creation Date : 28/04/2020 - Description : to add a product into the
			 * database
			 * 
			 * @throws ProductException
			 ********************************************************************************************************/
		
		@PostMapping("/dashboard/addProduct")
		public ResponseEntity<Integer> addProduct(@RequestBody Product product){
				int pid=pService.addProduct(product);
				if(pid==0) {
					throw new ProductException("Could not add the product");
				}else {
					return new ResponseEntity<Integer>(pid,HttpStatus.OK);
		
				}
				
		}
		
		// ------------------------ GreatOutdoor Application --------------------------
			/*******************************************************************************************************
			 * - Function Name : getProducts - Input Parameters : int  Return Type :
			 * boolean - Throws : ProductException - Author : Mohit kumar Mastana -
			 * Creation Date : 28/04/2020 - Description : to delete the product from the
			 * database
			 * 
			 * @throws ProductException
			 ********************************************************************************************************/
		
		
		@DeleteMapping("/dashboard/deleteProduct/{id}")
		public boolean deleteProduct(@PathVariable int id) {
				boolean result=pService.deleteProduct(id);
			if(result) {
				return result;
			}else {
				throw new ProductException("no product with such id...try with a different one");
			}
				
			
			
		}
		
		// ------------------------ GreatOutdoor Application --------------------------
			/*******************************************************************************************************
			 * - Function Name : searchProducts - Input Parameters : String name Return Type :
			 * List<Product> - Throws : ProductException - Author : Mohit kumar Mastana -
			 * Creation Date : 28/04/2020 - Description : to search list of product from the
			 * database
			 * 
			 * @throws ProductException
			 ********************************************************************************************************/
		
		
		@GetMapping("/dashboard/searchProducts/{name}")
		public List<Product> SearchProducts(@PathVariable String name) {
			
			List<Product> products=pService.getSearchedProducts(name);
			
				if(products.size()==0) {
					throw new ProductException("there are no such products");
				}else {

					return products;
				}
			
		}
		
		// ------------------------ GreatOutdoor Application --------------------------
			/*******************************************************************************************************
			 * - Function Name : searchCategoryProducts - Input Parameters :String name Return Type :
			 * List<Product> - Throws : ProductException - Author : Mohit kumar Mastana -
			 * Creation Date : 28/04/2020 - Description : to get all the product of a category from the
			 * database
			 * 
			 * @throws ProductException
			 ********************************************************************************************************/
		
		@GetMapping("/dashboard/searchProducts/category/{name}")
		public List<Product> SearchCategoryProducts(@PathVariable String name) {
			
			List<Product> products=pService.getCategoryProducts(name);
			
				if(products.size()==0) {
					throw new ProductException("no product in this category...try another");
				}else {

					return products;
				}
			
		}
		
		// ------------------------ GreatOutdoor Application --------------------------
			/*******************************************************************************************************
			 * - Function Name : editProduct - Input Parameters : Product product Return Type :
			 * List<Product> - Throws : ProductException - Author : Mohit kumar Mastana -
			 * Creation Date : 28/04/2020 - Description : to edit a product from the
			 * database
			 * 
			 * @throws ProductException
			 ********************************************************************************************************/
		
		@PutMapping("/dashboard/editProduct")
		public ResponseEntity<Integer> editProduct(@RequestBody Product product){
				int pid=pService.editProduct(product);
				if(pid==0) {
					throw new ProductException("Could not edit the product");
				}else {
					return new ResponseEntity<Integer>(pid,HttpStatus.OK);
		
				}
				
		}


}
