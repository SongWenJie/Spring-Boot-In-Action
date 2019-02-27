package springboot_02_data_jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot_02_data_jdbc.model.Author;
import springboot_02_data_jdbc.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public int add(Author author){
        try{
            return this.authorService.add(author);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("新增错误");
        }
    }

    @PostMapping("/update")
    public int update(Author author){
        try{
            return this.authorService.update(author);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("新增错误");
        }
    }

    @PostMapping("/delete")
    public int delet(Long id){
        try{
            return this.authorService.delete(id);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("删除错误");
        }
    }

    @GetMapping("/getAuthor")
    public Author getAuthor(Long id){
        return this.authorService.findAuthor(id);
    }

    @GetMapping("/getAuthors")
    public List<Author> getAuthors(){
        return this.authorService.findAuthors();
    }
}
