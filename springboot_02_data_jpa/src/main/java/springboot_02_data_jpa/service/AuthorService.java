package springboot_02_data_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import springboot_02_data_jpa.dao.AuthorRepository;
import springboot_02_data_jpa.model.Author;

import java.util.List;
import java.util.Optional;

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

    /** 
    * @Description: 查询全部 
    * @Param: [] 
    * @return: java.util.List<springboot_02_data_jpa.model.Author> 
    * @Author: songwenjie 
    * @Date: 2019/2/28 
    */ 
    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    /** 
    * @Description: 根据主键查询 
    * @Param: [id] 
    * @return: springboot_02_data_jpa.model.Author 
    * @Author: songwenjie 
    * @Date: 2019/2/28 
    */ 
    public Author findAuthor(Long id){
        return authorRepository.findAuthor(id);
    }

    /**
    * @Description: 根据realName查询
    * @Param: [realName]
    * @return: java.util.List<springboot_02_data_jpa.model.Author>
    * @Author: songwenjie
    * @Date: 2019/2/28
    */
    public List<Author> findAuthorByRealName(String realName){
        return authorRepository.findAuthorByRealName(realName);
    }
    
    /** 
    * @Description: 分页查询
    * @Param: [page, size, direction, id] 
    * @return: org.springframework.data.domain.Page<springboot_02_data_jpa.model.Author> 
    * @Author: songwenjie 
    * @Date: 2019/2/28 
    */ 
    public Page<Author> findAuthorPages(int page, int size,Sort.Direction direction, String id){
        Pageable pageable = new PageRequest(page, size, direction, "id");
        Page<Author> authorPage =  authorRepository.findAll(pageable);
        return authorPage;
    }

    /**
    * @Description: 排序查询
    * @Param: [direction, orderField]
    * @return: java.util.List<springboot_02_data_jpa.model.Author>
    * @Author: songwenjie
    * @Date: 2019/2/28
    */
    public List<Author> findAuthorOrder(Sort.Direction direction, String orderField){
        List<Author> authors = authorRepository.findAll(new Sort(new Sort.Order(direction,orderField)));
        return authors;
    }
    
    /** 
    * @Description: 总计数
    * @Param: [] 
    * @return: long 
    * @Author: songwenjie 
    * @Date: 2019/2/28 
    */ 
    public long count(){
        return authorRepository.count();
    }

    /** 
    * @Description: 主键判断是否存在 
    * @Param: [id] 
    * @return: boolean 
    * @Author: songwenjie 
    * @Date: 2019/2/28 
    */ 
    public boolean existsById(long id){
        return authorRepository.existsById(id);
    }
    
    /** 
    * @Description: 条件判断是否存在
    * @Param: [author] 
    * @return: boolean 
    * @Author: songwenjie 
    * @Date: 2019/2/28 
    */ 
    public boolean exists(Author author){
        return authorRepository.exists(Example.of(author));
    }

    /** 
    * @Description: 条件计数
    * @Param: [author] 
    * @return: long 
    * @Author: songwenjie 
    * @Date: 2019/2/28 
    */ 
    public long count(Author author){
        return authorRepository.count(Example.of(author));
    }
    

    /**
    * @Description: 根据主键查询
    * @Param: [id]
    * @return: springboot_02_data_jpa.model.Author
    * @Author: songwenjie
    * @Date: 2019/2/28
    */
    public Author findById(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if(authorOptional.isPresent()){
            return authorOptional.get();
        }
        return null;
    }

    /** 
    * @Description: 新增修改 
    * @Param: [author] 
    * @return: int 
    * @Author: songwenjie 
    * @Date: 2019/2/28 
    */ 
    public int addOrUpdate(Author author){
        if(author == null){
            return 0;
        }
        try{
            authorRepository.save(author);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("操作失败");
        }
        return 1;
    }

    /** 
    * @Description: 删除对象 
    * @Param: [author] 
    * @return: int 
    * @Author: songwenjie 
    * @Date: 2019/2/28 
    */ 
    public int delete(Author author){
        if(author == null){
            return 0;
        }
        try{
            authorRepository.delete(author);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("删除失败");
        }
        return 1;
    }

    /** 
    * @Description: 根据主键删除
    * @Param: [id] 
    * @return: int 
    * @Author: songwenjie 
    * @Date: 2019/2/28 
    */ 
    public int delete(Long id){
        try{
            authorRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("删除失败");
        }
        return 1;
    }





}
