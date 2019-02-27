package springboot_02_data_jpa.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
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

    List<Author> findAll();


    @Query("from Author where id = :id")
    Author findAuthor(@Param("id") Long id);

}
