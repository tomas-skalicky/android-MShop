package cz.skalicky.android.MShopService.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import cz.skalicky.android.MShopService.context.SpringApplicationContext;
import cz.skalicky.android.MShopService.domain.CategoryImpl;
import cz.skalicky.android.MShopService.publicapi.Category;

/**
 * @author <a href="mailto:skalicky.tomas@gmail.com">Tomas Skalicky</a>
 *         &lt;skalicky.tomas@gmail.com&gt;
 */
@Path("/category")
public class CategoryService {

	/**
	 * For example: http://localhost:8081/MShopService/rest/category/getAll
	 */
//	@GET
//	@Path("/getAll")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getAllCategories() {
//		Category category = (Category) SpringApplicationContext
//				.getBean(CategoryImpl.BEAN_NAME);
//		return Response.status(Status.OK).entity(category.toString()).build();
//	}
//
//	@GET
//	@Path("/get/{categoryId}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getCategory(@PathParam("categoryId") String categoryId) {
//		Category category = (Category) SpringApplicationContext
//				.getBean(CategoryImpl.BEAN_NAME);
//		return Response.status(Status.OK).entity(category.toString()).build();
//	}
}
