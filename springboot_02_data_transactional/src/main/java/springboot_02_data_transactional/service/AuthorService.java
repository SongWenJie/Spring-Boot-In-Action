package springboot_02_data_transactional.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot_02_data_transactional.dao.AuthorDao;
import springboot_02_data_transactional.model.Author;

/**
 * @program:
 * @description: Author Service
 * @author: songwenjie
 * @create: 2019-03-01 09:37
 **/
@Service
public class AuthorService {

    @Autowired
    private AuthorDao authorDao;

    /** 
    * @Description: 不使用声明式事务管理
    * @Param: [author] 
    * @return: int 
    * @Author: songwenjie 
    * @Date: 2019/3/1 
    */ 
    public int add1(Author author){
        int result = authorDao.add(author);
        if(author.getRealName().length() > 5 ){
            throw  new IllegalArgumentException("author realName is too long !");
        }
        return result;
    }

    /** 
    * @Description: 使用声明式事务，但是不进行回滚
     * noRollbackFor 修饰表明不做事务回滚
    * @Param: [author] 
    * @return: int 
    * @Author: songwenjie 
    * @Date: 2019/3/1 
    */ 
    @Transactional(noRollbackFor={IllegalArgumentException.class})
    public int add2(Author author){
        int result = authorDao.add(author);
        if(author.getRealName().length() > 5 ){
            throw  new IllegalArgumentException("author realName is too long !");
        }
        return result;
    }

    /** 
    * @Description: 使用生命式事务，并且进行回滚
     * rollbackFor 修饰的表明需要事务回滚
    * @Param: [author] 
    * @return: int 
    * @Author: songwenjie 
    * @Date: 2019/3/1 
    */ 
    @Transactional(rollbackFor={IllegalArgumentException.class})
    public int add3(Author author){
        int result = authorDao.add(author);
        if(author.getRealName().length() > 5 ){
            throw  new IllegalArgumentException("author realName is too long !");
        }
        return result;
    }

    /** 
    * @Description: 使用声明式事务，不限定异常类型
    * @Param: [author] 
    * @return: int 
    * @Author: songwenjie 
    * @Date: 2019/3/1 
    */ 
    @Transactional
    public int add4(Author author){
        int result = authorDao.add(author);
        if(author.getRealName().length() > 5 ){
            throw  new IllegalArgumentException("author realName is too long !");
        }
        return result;
    }

}
