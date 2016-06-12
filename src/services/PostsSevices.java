package services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import BL.PostsManager;

@Path("/posts")
public class PostsSevices {

    @Path("/newsfeed")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response getNewFeed(String jsonObject) {
    	
		try { 
	    	final JSONObject json = new JSONObject(jsonObject);
	    	Integer userID = json.getInt("userID");
	    	
	    	PostsManager postsManager = new PostsManager();
	    	
	        JSONArray obj = postsManager.getNewsFeed(userID);
	        
	        return Response.status(200).entity(obj.toString()).build();
		} catch (Exception e) {
			 return Response.status(500).build();
		}
    }
}
