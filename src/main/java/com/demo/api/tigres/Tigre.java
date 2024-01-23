package com.demo.api.tigres;

public class Tigre {
    private Integer id;
    private String name;
    private String color;
    private Integer age;

    public Tigre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModifyedId(int id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void patchValues(Tigre tigreClient) {
        if(tigreClient.getName() != null)
            setName(tigreClient.getName());
        if(tigreClient.getColor() != null)
            setColor(tigreClient.getColor());
        if(tigreClient.getAge() != null)
            setAge(tigreClient.getAge());
    }
}
