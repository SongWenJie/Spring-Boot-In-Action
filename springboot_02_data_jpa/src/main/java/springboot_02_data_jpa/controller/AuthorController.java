package springboot_02_data_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot_02_data_jpa.model.Author;
import springboot_02_data_jpa.service.AuthorService;

import java.util.List;

/**
 * @program:
 * @description: AuthorController
 * @author: songwenjie
 * @create: 2019-02-27 16:36
 **/

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/getauthor")
    public Author getAuthor(Long id){
        return authorService.findAuthor(id);
    }

    @GetMapping("/getAuthorByRealName")
    public List<Author> getAuthorByRealName(String realName){
        return authorService.findAuthorByRealName(realName);
    }

    @GetMapping("/findAll")
    public List<Author> findAll(){
        return authorService.findAll();
    }

    @GetMapping("/findAuthorPages")
    public Page<Author> findAuthorPages(int page, int size, Sort.Direction direction, String id){
        return authorService.findAuthorPages(page,size,direction,id);
    }

    @GetMapping("/findAuthorOrder")
    public List<Author> findAuthorOrder(Sort.Direction direction, String orderFields){
        return authorService.findAuthorOrder(direction,orderFields);
    }

    @GetMapping("/count")
    public long count(){
        return authorService.count();
    }

    @GetMapping("/conditionCount")
    public long count(Author author){
        return authorService.count(author);
    }

    @GetMapping("/existsById")
    public boolean existsById(long id){
        return authorService.existsById(id);
    }

    @GetMapping("/exists")
    public boolean exists(Author author){
        return authorService.exists(author);
    }

    @PostMapping("/addOrUpdate")
    public int addOrUpdate(Author author){
        return authorService.addOrUpdate(author);
    }

}
