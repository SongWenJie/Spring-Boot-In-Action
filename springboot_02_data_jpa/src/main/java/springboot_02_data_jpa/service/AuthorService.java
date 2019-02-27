package springboot_02_data_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_02_data_jpa.dao.AuthorRepository;
import springboot_02_data_jpa.model.Author;

import java.util.List;

/**
 * @program:
 * @description: Author Service
 * @author: songwenjie
 * @create: 2019-02-27 16:32
 **/
@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public Author findAuthor(Long id){
        return authorRepository.findAuthor(id);
    }


}
