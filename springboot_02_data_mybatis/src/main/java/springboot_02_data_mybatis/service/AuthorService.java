package springboot_02_data_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import springboot_02_data_mybatis.mapper.AuthorMapper;
import springboot_02_data_mybatis.model.Author;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthorService {

    @Autowired
    private AuthorMapper authorMapper;

    public int add(Author author){
        return authorMapper.add(author);
    }

    public int add1(Author author){
        Map<String,Object> map =new HashMap<>();
        map.put("realName",author.getRealName());
        map.put("nickName",author.getNickName());
        return authorMapper.add1(map);
    }

    public int add2(Author author){
        return authorMapper.add2(author.getRealName(),author.getNickName());
    }

    public int update(Author author){
        return authorMapper.update(author);
    }

    public int delete(Long id){
        return authorMapper.delete(id);
    }

    public Author findAuthorById(Long id){
        return authorMapper.findAuthorById(id);
    }

    public List<Author> findAuthors(){
        return authorMapper.findAuthors();
    }
}
