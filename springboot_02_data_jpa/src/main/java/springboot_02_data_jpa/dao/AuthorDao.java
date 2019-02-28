package springboot_02_data_jpa.dao;

import springboot_02_data_jpa.model.Author;

import java.util.List;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-02-28 13:52
 **/
public interface AuthorDao {
    List<Author> findAll();

    Author findAuthor(long id);
}
