package com.amproductions.commentsmicroservice;

import com.kumuluz.ee.metrics.producers.MetricRegistryProducer;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("comments")
public class CommentsResource {

    @GET
    @Path("/{objectID}")
    public Response getComments(@PathParam("objectID") String objectID) {
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


    @Counted(name = "commentPostCount",
            absolute = true,
            displayName = "Posted comment count",
            description = "Metric to show how many times comment was added.")

    @POST
    public Response postComment(CommentEntry comment) {
        try {

            if(Database.AddComment(comment)){
                return Response.status(Response.Status.CREATED).build();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @DELETE
    public Response deleteComment(CommentEntry comment) {
        try {

            if(Database.DeleteComment(comment)){
                return Response.status(Response.Status.CREATED).build();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
