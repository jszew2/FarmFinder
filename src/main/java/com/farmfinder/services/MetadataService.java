
package com.farmfinder.services;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.data.annotation.Id;

import com.farmfinder.model.* ;
import com.farmfinder.commands.CategoryRepo;
import com.farmfinder.commands.MetadataRepo ;
import com.farmfinder.config.MongoConfig;
import com.farmfinder.metadata.Metadata ;

import java.lang.reflect.Field ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Path("/metadata")
public class MetadataService {
	ObjectMapper mapper = new ObjectMapper();
	
	
	@POST
	@Path("/create/farm")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createFarmMetadata(){
		/*Create metadata for farm class using metadata class*/ 
		Metadata meta = new Metadata(Farm.class) ;
		/*Get repo from application context and store the generic metadata for farm. 
		 * Note can edit by getting the ArrayList<HashMap> if needed.*/
		try{
			ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
			MetadataRepo repo = (MetadataRepo) ctx.getBean(MetadataRepo.class) ;
			repo.save(meta) ;
			return Response.status(201).entity(meta).build() ;
		}catch(Exception e){
			e.printStackTrace() ;
			return Response.status(500).build() ;
		}
	}
	
	@POST
	@Path("/create/category")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCategoryMetadata(){
		/*Create metadata for Category class using metadata class*/ 
		Metadata meta = new Metadata(Category.class) ;
		/*Get repo from application context and store the generic metadata for category. 
		 * Note can edit by getting the ArrayList<HashMap> if needed.*/
		try{
			ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
			MetadataRepo repo = (MetadataRepo) ctx.getBean(MetadataRepo.class) ;
			repo.save(meta) ;
			return Response.status(201).entity(meta).build() ;
		}catch(Exception e){
			e.printStackTrace() ;
			return Response.status(500).build() ;
		}
	}
	
	@POST
	@Path("/create/product")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProductMetadata(){
		/*Create metadata for Product class using metadata class*/ 
		Metadata meta = new Metadata(Product.class) ;
		/*Get repo from application context and store the generic metadata for product. 
		 * Note can edit by getting the ArrayList<HashMap> if needed.*/
		try{
			ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
			MetadataRepo repo = (MetadataRepo) ctx.getBean(MetadataRepo.class) ;
			repo.save(meta) ;
			return Response.status(201).entity(meta).build() ;
		}catch(Exception e){
			e.printStackTrace() ;
			return Response.status(500).build() ;
		}
	}
	
	
	@GET
	@Path("/farm")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFarmMetadata() {
		/*Get repo from application context and get metadata for farm. */
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		MetadataRepo repo = (MetadataRepo) ctx.getBean(MetadataRepo.class) ;
		try{
			Metadata meta = repo.findByTitle("Farm") ;
			return Response.status(200).entity(meta).build();
		}
		catch(Exception e){
			e.printStackTrace() ;
			return Response.status(500).build();
		}
	}

	@GET
	@Path("/categories")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategoryMetadata() {
		Category cat = new Category();
		String catJSON;
		try {
			/*returns json object of a book */
			catJSON = mapper.writeValueAsString(cat);
			return Response.status(200).entity(catJSON).build();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@GET
	@Path("/product")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductMetadata() {
		Product prd = new Product();
		String prdJSON;
		try {
			/*returns json object of a book */
			prdJSON = mapper.writeValueAsString(prd);
			return Response.status(200).entity(prdJSON).build();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
}


