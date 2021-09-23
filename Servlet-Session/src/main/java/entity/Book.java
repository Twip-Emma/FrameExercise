package entity;

import lombok.Data;

@Data
public class Book {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private Book(){}
    public Book(String id,String name){
        this.id = id;
        this.name = name;
    }
}
