package com.farmfinder.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.farmfinder.commands.CategoryRepo;
import com.farmfinder.config.MongoConfig;
import com.farmfinder.model.Category;

@Path("/farmfinder")
public class FarmFinder {
	@POST
	@Path("/createFarm")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createFarm(){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		CategoryRepo repo = (CategoryRepo) ctx.getBean(CategoryRepo.class) ;
		/*Create new category class*/ 
		Category cat = new Category() ;
		cat.setName("Strawberry") ;		
		repo.save(cat) ;
		return Response.status(201).entity(cat).build() ;
	}
	
	// This is a rest service for getting 1 category
	@GET
	@Path("/getCategory/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategory(@PathParam("Id") String Id){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class); //get the application scope
		CategoryRepo repo = (CategoryRepo) ctx.getBean(CategoryRepo.class) ;				//getting mongo repo for category
		Category category = repo.findOne(Id);												//create a category 
		return Response.status(200).entity(category).build();								//return the build		
	}
	
	// rest service to get all catergories
	@GET
	@Path("/getCategories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategories(){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class); //get the application scope
		CategoryRepo repo = (CategoryRepo) ctx.getBean(CategoryRepo.class) ;
		List<Category> categories = repo.findAll();											//returns a list
		return Response.status(200).entity(categories).build();
	}
}
