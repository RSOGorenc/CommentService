package com.amproductions.commentsmicroservice;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.json.bind.JsonbBuilder;

import static com.mongodb.client.model.Filters.eq;



class Database {
    private static MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://192.168.99.100:27017"));
    private static MongoDatabase database = mongoClient.getDatabase("imagePlatform");
    private static MongoCollection<Document> collection = database.getCollection("images");

    @SuppressWarnings("unchecked")
    static Document GetComments(String objectID){
        try {

            Document document = collection.find(eq("_id", new ObjectId(objectID))).first();

            Document res = null;
            if(document != null){
                return document;
            }
            return res;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    static boolean AddComment(CommentEntry comment){
        try {

            collection.updateOne(
                    new BasicDBObject("_id", new ObjectId(comment.get_id())),
                    new BasicDBObject("$push", new BasicDBObject("comments", comment.getComment()))
            );

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
