package oneone.community.mapper;

import oneone.community.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,bio,avatar_url) " +
            "values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{bio},#{avatarUrl})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User findUserByToken(@Param("token") String token);

    @Select("select * from user where account_id=#{accountId}")
    User findByAccountId(@Param("accountId") String accountId);

    @Update("update user set name = #{name}, token = #{token} , gmt_modified = #{gmtModified} , avatar_url = #{avatarUrl} " +
            "where id = #{id}")
    void update(User user);
    @Select("select * from user where id=#{creator}")
    User findById(@Param("creator")String creator);
}
