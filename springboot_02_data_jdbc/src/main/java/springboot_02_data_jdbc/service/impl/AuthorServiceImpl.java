package springboot_02_data_jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_02_data_jdbc.dao.AuthorDao;
import springboot_02_data_jdbc.model.Author;
import springboot_02_data_jdbc.service.AuthorService;

import java.util.List;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    public int add(Author author){
        return authorDao.add(author);
    }


    public int update(Author author){
        return authorDao.update(author);
    }

    public int delete(Long id){
        return authorDao.delete(id);
    }

    public Author findAuthor(Long id){
        return authorDao.findAuthor(id);
    }

    public List<Author> findAuthors(){
        return authorDao.findAuthors();
    }
}
