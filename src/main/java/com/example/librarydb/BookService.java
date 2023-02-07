package com.example.librarydb;

import com.example.librarydb.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService
{
    @Autowired
    BookRepository bookRepository;
    public void createBook(Book book)throws Exception
    {
        //Logic is written here
        //Validation part
        if(bookRepository.findById(book.getId()).get()!=null)
        {
            throw new Exception("Book is already present");
        }
        bookRepository.save(book);
    }
    public Book getBookById(Integer id)
    {
        Book book=bookRepository.findById(id).get();
        System.out.println(book.getName());
        return book;
    }
    public void updateBookPages(UpdateBookPage updateBookPage)
    {
        int id=updateBookPage.getId();
        Book bookToBeUpdated=bookRepository.findById(id).get();
        bookToBeUpdated.setPages(updateBookPage.getPages());
        bookRepository.save(bookToBeUpdated);
    }
    public List<ResponseObj>getBookNameAndAuthor()
    {
        //From the repository class -->what will I get
        List<Book>bookList=bookRepository.findAll();//Select * from book_table;
        //Convert this entity into responseObject
        List<ResponseObj>ansList =new ArrayList<>();
        for(Book book:bookList)
        {
            ResponseObj obj=new ResponseObj();
            obj.author=book.getAuthor();
            obj.name=book.getName();
            ansList.add(obj);
        }
        return ansList;
    }
}
