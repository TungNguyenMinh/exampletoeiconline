package com.minhtung.core.testapi;

import com.minhtung.core.model.Book;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class reviewHashMap {
    @Test
    public void checkHashMap() {
        Book book1 = returnBookModel(1, "A", "B", "C", 1);
        Book book2 = returnBookModel(2, "D", "E", "F", 2);
        Book book3 = returnBookModel(3, "G", "H", "J", 3);
        Map<Integer, Book> map = new HashMap<Integer, Book>();
        map.put(1, book1);
        map.put(2, book2);
        map.put(3, book3);
        for (Map.Entry<Integer, Book> item : map.entrySet()) {
            System.out.println(item.getKey());
            Book value = item.getValue();
            System.out.println(value.getId() + "_" + value.getName() + "_" + value.getAuthor() + "_" + value.getPublisher() + "_" + value.getQuantity());
        }

    }

    private Book returnBookModel(int id, String name, String author, String publisher, int quantity) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setQuantity(quantity);
        book.setPublisher(publisher);
        return book;
    }
}
