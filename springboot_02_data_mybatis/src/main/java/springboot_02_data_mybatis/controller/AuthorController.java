package springboot_02_data_mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot_02_data_mybatis.model.Author;
import springboot_02_data_mybatis.service.AuthorService;
import springboot_02_data_mybatis.service.AuthorService2;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorService2 authorService2;


    @PostMapping("/add")
    public int add(Author author){
        try{
            return this.authorService.add(author);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("新增错误");
        }
    }

    @PostMapping("/add1")
    public int add1(Author author){
        try{
            return this.authorService.add1(author);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("新增错误");
        }
    }

    @PostMapping("/add2")
    public int add2(Author author){
        try{
            return this.authorService.add2(author);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("新增失败");
        }
    }


    @PostMapping("/update")
    public int update(Author author){
        try{
            return this.authorService.update(author);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("更新失败");
        }
    }

    @PostMapping("/delete")
    public int delete(Long id){
        try{
            return this.authorService.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("删除失败");
        }
    }

    @GetMapping("/findauthor")
    public Author findAuthorById(Long id){
        return this.authorService.findAuthorById(id);
    }

    @GetMapping("/findauthors")
    public List<Author> findAuthors(){
        return this.authorService.findAuthors();
    }

    @GetMapping("/findauthor2")
    public Author findAuthor(Long id){
        return authorService2.findAuthor(id);
    }
}
