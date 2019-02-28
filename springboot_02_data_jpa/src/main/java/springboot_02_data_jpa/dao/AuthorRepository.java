package springboot_02_data_jpa.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springboot_02_data_jpa.model.Author;

import java.util.List;

/**
 * @program:
 * @description: Author Dao
 * @author: songwenjie
 * @create: 2019-02-27 16:24
 **/
public interface AuthorRepository extends JpaRepository<Author,Long> {

    /**
    * @Description: 查询全部
    * @Param: []
    * @return: java.util.List<springboot_02_data_jpa.model.Author>
    * @Author: songwenjie
    * @Date: 2019/2/28
    */
    List<Author> findAll();

    /**
    * @Description: 条件查询 注意：操作的是POJO对象属性
    * @Param: [id]
    * @return: springboot_02_data_jpa.model.Author
    * @Author: songwenjie
    * @Date: 2019/2/28
    */
    @Query("from Author where id = :id")
    Author findAuthor(@Param("id") Long id);

    List<Author> findAuthorByRealName(@Param("realName") String realName);





}
