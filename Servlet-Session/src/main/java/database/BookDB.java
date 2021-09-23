package database;

import entity.Book;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class BookDB {
    private static final Map<String, Book> books = new LinkedHashMap<>();

    static {
        books.put("1",new Book("1","初级魔法目录"));
        books.put("2",new Book("2","高阶剑术"));
        books.put("3",new Book("3","妖精族的起源"));
        books.put("4",new Book("4","空域旅游指南"));
    }
    public static Collection<Book> getAll(){
        return books.values();
    }

    public static Book getBook(String id){
        return books.get(id);
    }
}
