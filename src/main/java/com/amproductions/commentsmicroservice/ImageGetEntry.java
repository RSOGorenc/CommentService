package com.amproductions.commentsmicroservice;
import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class ImageGetEntry {
    private String _id;
    @JsonbCreator
    public ImageGetEntry(@JsonbProperty("_id")String _id){
        this._id = _id;
    }

    public String getObjectID(){
        return _id;
    }
}
