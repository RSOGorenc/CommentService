package com.amproductions.commentsmicroservice;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.time.LocalDate;
import java.util.List;

public class CommentEntry {
    private String imageId;
    private String comment;

    @JsonbCreator
    public CommentEntry(@JsonbProperty("imageId")String imageId,
                        @JsonbProperty("comment")String comment){
        this.imageId = imageId;
        this.comment = comment;
    }

    public String getImageId(){
        return imageId;
    }



    public String getComment(){
        return comment;
    }

}

