package com.prismoskills;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
@JsonSubTypes({
    @Type(value = DerivedType1.class, name = "DerivedType1"),
    @Type(value = DerivedType2.class, name = "DerivedType2"),
})
public class BaseType {

    private int data;
    private List<BaseType> types;

    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public List<BaseType> getTypes() {
        return types;
    }
    public void setTypes(List<BaseType> types) {
        this.types = types;
    }
}
