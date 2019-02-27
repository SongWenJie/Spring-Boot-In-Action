package springboot_02_data_mybatis.mapper;

import org.apache.ibatis.annotations.*;
import springboot_02_data_mybatis.model.Author;

import java.util.List;
import java.util.Map;

/**
 * 方案一 通过注解的方式
 */
@Mapper
public interface AuthorMapper {
    @Insert("insert into t_author(real_name, nick_name) values(#{realName}, #{nickName})")
    int add(Author author);

    @Insert("insert into t_author(real_name, nick_name) values(#{realName}, #{nickName})")
    int add1(Map<String,Object> map);

    @Insert("insert into t_author(real_name, nick_name) values(#{realName}, #{nickName})")
    int add2(@Param("realName")String realName,@Param("nickName")String nickName);

    @Update("update t_author set real_name=#{realName},nick_name=#{nickName} where id=#{id}")
    int update(Author author);

    @Delete("delete from t_author where id=#{id}")
    int delete(@Param("id") Long id);

    @Select("Select * from t_author where id=#{id}")
    @Results({
            @Result(column = "real_name",property = "realName"),
            @Result(column = "nick_name",property = "nickName")
    })
    Author findAuthorById(Long id);

    @Select("select * from t_author")
    @Results({
            @Result(column = "real_name",property = "realName"),
            @Result(column = "nick_name",property = "nickName")
    })
    List<Author> findAuthors();



}
