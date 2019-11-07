package oneone.community.mapper;

import oneone.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question(id,title,description,gmt_create,gmt_modified,creator,comment_count,view_count,like_count,tag) " +
            "values(#{id},#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{commentCount},#{viewCount},#{likeCount},#{tag})")
    void create(Question question);

    @Select("select id,title,description,gmt_create as gmtCreate,gmt_modified as gmtModified," +
            "creator,comment_count as commentCount,view_count as viewCount,like_count as likeCount,tag from question")
    List<Question> list();
}
