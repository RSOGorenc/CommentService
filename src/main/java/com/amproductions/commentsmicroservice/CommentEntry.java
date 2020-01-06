package com.amproductions.commentsmicroservice;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.time.LocalDate;
import java.util.List;

public class CommentEntry {
    private String _id;
    private String comment;

    @JsonbCreator
    public CommentEntry(@JsonbProperty("_id")String _id,
                        @JsonbProperty("comment")String comment){
        this._id = _id;
        this.comment = comment;
    }

    public String get_id(){
        return _id;
    }


    public String getComment(){
        return comment;
    }

}

