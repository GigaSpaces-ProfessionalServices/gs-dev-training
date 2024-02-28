package com.gigaspaces.training.model;


import com.gigaspaces.annotation.pojo.SpaceClass;
import com.gigaspaces.annotation.pojo.SpaceId;
import com.gigaspaces.annotation.pojo.SpaceIndex;
import com.gigaspaces.annotation.pojo.SpaceRouting;
import com.gigaspaces.metadata.index.SpaceIndexType;

import java.math.BigDecimal;


@SpaceClass
public class Product implements java.io.Serializable {

    private static final long serialVersionUID = 0L;

    private Integer id;
    private String name;
    private BigDecimal price;

    public Product() {}

    @SpaceId(autoGenerate=false)
    @SpaceRouting
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @SpaceIndex(type=SpaceIndexType.EQUAL_AND_ORDERED)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
