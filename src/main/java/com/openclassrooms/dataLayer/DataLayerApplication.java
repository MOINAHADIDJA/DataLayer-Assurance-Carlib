package com.openclassrooms.dataLayer;

import com.openclassrooms.dataLayer.model.Category;
import com.openclassrooms.dataLayer.model.Comment;
import com.openclassrooms.dataLayer.model.Product;
import com.openclassrooms.dataLayer.service.CategoryService;
import com.openclassrooms.dataLayer.service.CommentService;
import com.openclassrooms.dataLayer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootApplication
public class DataLayerApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CommentService commentService;

	public static void main(String[] args) {
		SpringApplication.run(DataLayerApplication.class, args);
	}


	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Iterable<Product> products = productService.getProducts();
		products.forEach(product -> System.out.println(product.getName()));

		System.out.println("*******************");
		Iterable<Category> categories = categoryService.getCategories();
		categories.forEach(category -> System.out.println(category.getName()));
		System.out.println("*****************");
		Iterable<Comment> comments = commentService.getComments();
		comments.forEach(comment -> System.out.println(comment.getContent()));

    	Product product1 = productService.getProductById(1);
		Category cat1 = categoryService.getCategoryById(1);
		Comment com3 = commentService.getCommentById(3);

		System.out.println(product1.getName() +"******"+cat1.getName()+"*********"+com3.getContent());

		System.out.println("list of comments for product1");
		product1.getComments().forEach(comment -> System.out.println(comment.getContent()));

		System.out.println("list of categories for product1");
		product1.getCategories().forEach(category -> System.out.println(category.getName()));

		System.out.println("list of products for cat1");
		cat1.getProducts().forEach(product -> System.out.println(product.getName()));

		System.out.println("product's comments");
		System.out.println(com3.getProduct().getName());

	/*	Category c = new Category();
	c.setName("-25 ans");
	//categoryService.saveCategory(c);

		Product prdt = new Product();
		prdt.setCost(400);
		prdt.setName("AssuranceAuTiers-25ans");
		prdt.setDescription("Assurance aux tiers reservés aux conducteurs de -25ans");

		c.addProduct(prdt);
		//productService.saveProduct(prdt);

		categoryService.saveCategory(c);
		/*Comment comment = new Comment();
		comment.setContent("Assurance trés fiable");

		prdt.addComment(comment);
		commentService.saveComment(comment);

		Product existingProduct = productService.getProductById(6);
		System.out.println(existingProduct.getCost());

		existingProduct.setName("AssuranceAuTiersFidelité");
		existingProduct.setCost(1100);
		productService.saveProduct(existingProduct);

		existingProduct = productService.getProductById(6);
		System.out.println(existingProduct.getCost());*/
	//	productService.deleteProductById(5);
		//categoryService.deleteCategory(5);

		Iterable<Product> searchProducts=productService.getProductByName("AssuranceAuTiersFidelité");
		searchProducts.forEach(product -> System.out.println(product.getProductId()));
		searchProducts=productService.getProductByCategoryName("Standard");
		searchProducts.forEach(product -> System.out.println(product.getName()));

		searchProducts=productService.getProductsByCostLessThan(1000);
		searchProducts.forEach(product -> System.out.println(product.getDescription()));



		Iterable<Category> searchCategories=categoryService.getCategoryByName("Standard");
		searchCategories.forEach(category -> System.out.println(category.getCategoryId()));

		searchCategories = categoryService.getCategoriesByProductName("AssurancesAuTiers-25ans");
		searchCategories.forEach(category -> System.out.println(category.getName()));

		Iterable<Comment> searchComments=commentService.getCommentByContentContaining("deçu");
		searchComments.forEach(comment -> System.out.println(comment.getCommentId()));



	}
}
