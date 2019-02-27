package springboot_02_data_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_02_data_mybatis.mapper.AuthorMapper;
import springboot_02_data_mybatis.mapper.AuthorMapper2;
import springboot_02_data_mybatis.model.Author;

@Service
public class AuthorService2 {

    @Autowired
    private AuthorMapper2 authorMapper2;

    public Author findAuthor(Long id){
        return authorMapper2.findAuthor(id);
    }
}
