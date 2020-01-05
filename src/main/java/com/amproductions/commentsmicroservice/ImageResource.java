package com.amproductions.commentsmicroservice;

import org.bson.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("comments")
public class ImageResource {

    @GET
    @Path("/{objectID}")
    public Response getImage(@PathParam("objectID") String objectID) {
        try {
            Object comments = Database.GetComments(objectID).get("comments");

            if (comments == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            return Response.status(Response.Status.OK).entity(comments).build();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
    @POST
    public Response postComment(CommentEntry comment) {
        try {

            CommentEntry response = new CommentEntry(comment.get_id(),  comment.getComment());
            if(Database.AddComment(response)){
                return Response.status(Response.Status.CREATED).build();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
