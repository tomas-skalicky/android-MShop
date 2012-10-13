package cz.skalicky.android.MShopService.service;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import cz.skalicky.android.MShopService.publicapi.Category;

@Path("/category")
public class CategoryService {

	@Resource(name = "category")
	private Category category;

	@GET
	@Path("/getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCategories() {
		return Response.status(Status.OK).entity(this.category.toString())
				.build();
	}

	@GET
	@Path("/get/{categoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCategory(@PathParam("categoryId") String categoryId) {
		return Response.status(Status.OK).entity(this.category.toString())
				.build();
	}

	@GET
	@Path("/{param}")
	public Response printMessage(@PathParam("param") String msg) {

		String result = "Restful example : " + msg;

		return Response.status(200).entity(result).build();

	}
}
