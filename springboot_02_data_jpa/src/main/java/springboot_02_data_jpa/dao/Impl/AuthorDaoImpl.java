package springboot_02_data_jpa.dao.Impl;

import org.springframework.stereotype.Repository;
import springboot_02_data_jpa.dao.AuthorDao;
import springboot_02_data_jpa.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @program:
 * @description: 通过调用 EntityManager 类方法
 * @author: songwenjie
 * @create: 2019-02-28 13:54
 **/
@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Author> findAll() {
        return this.entityManager
                .createQuery("select t from Author t", Author.class)
                .getResultList();
    }

    @Override
    public Author findAuthor(long id) {
        List<Author> authors = this.entityManager
                                .createQuery("select t from Author t where id = ?1 ",Author.class)
                                .setParameter(1,new Long(id))
                                .getResultList();
        if(authors !=null && authors.size()>0){
            return authors.get(0);
        }
        return null;
    }
}
