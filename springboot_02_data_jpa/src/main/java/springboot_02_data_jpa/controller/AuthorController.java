package springboot_02_data_jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot_02_data_jpa.model.Author;
import springboot_02_data_jpa.service.AuthorService;

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

}
