package com.gigaspaces.training.model;


import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.metadata.index.SpaceIndexType;


@SpaceClass
public class MyPojo implements java.io.Serializable {

    private static final long serialVersionUID = 0L;

    private Integer id;
    private String message;

    public MyPojo() {}

    @SpaceId(autoGenerate=false)
    @SpaceRouting
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @SpaceIndex(type=SpaceIndexType.EQUAL)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
