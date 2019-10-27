package oneone.community.mapper;

import oneone.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user (name,account_id,token,gmt_create,gmt_modified,bio) " +
            "values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{bio})")
    void insert(User user);

    @Select("select id,name,account_id as accountId,token,gmt_create as gtmCreate," +
            "gmt_modified as gmtModified, bio from user where token=#{token}")
    User findUserByToken(@Param("token")String token);
}
