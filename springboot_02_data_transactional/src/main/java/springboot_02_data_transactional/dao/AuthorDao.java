package springboot_02_data_transactional.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springboot_02_data_transactional.model.Author;

/**
 * @program:
 * @description: Author Dao
 * @author: songwenjie
 * @create: 2019-03-01 09:34
 **/

@Repository
public class AuthorDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int add (Author author){
        return jdbcTemplate.update("insert into t_author(real_name, nick_name) values(?, ?)",
                author.getRealName(),author.getNickName());
    }
}
