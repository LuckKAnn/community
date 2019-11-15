package oneone.community.service;

import oneone.community.dto.PaginationDTO;
import oneone.community.dto.QuestionDTO;
import oneone.community.mapper.QuestionMapper;
import oneone.community.mapper.UserMapper;
import oneone.community.model.Question;
import oneone.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(Integer page, Integer size) {

        Integer offSet = size * (page - 1);
        List<Question> questionList = questionMapper.list(offSet,size);

        Integer totalCount = questionMapper.count();

        Integer totalPage;
        if (totalCount % size == 0)
            totalPage = totalCount / size;
        else
            totalPage = totalCount / size + 1;

        List<QuestionDTO> questionDTOList = new ArrayList<>();

        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question:questionList) {
            String creator = String.valueOf(question.getCreator());
            User user = userMapper.findById(creator);

            QuestionDTO questionDTO = new QuestionDTO();//快速抽取变量：alt + ctrl+v
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setTotalPage(totalPage);
        paginationDTO.setPagination(page);
        paginationDTO.setQuestionDTOS(questionDTOList);
        return paginationDTO;
    }


    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        Integer offSet = size * (page - 1);
        List<Question> questionList = questionMapper.listByUserId(userId,offSet,size);

        Integer totalPage;

        Integer totalCount = questionMapper.countByUserId(userId);
        if (totalCount % size == 0)
            totalPage = totalCount / size;
        else
            totalPage = totalCount / size + 1;

        if (page<1)
            page = 1;
        if (page>totalPage)
            page = totalPage;

        List<QuestionDTO> questionDTOList = new ArrayList<>();

        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question:questionList) {
            String creator = String.valueOf(question.getCreator());
            User user = userMapper.findById(creator);

            QuestionDTO questionDTO = new QuestionDTO();//快速抽取变量：alt + ctrl+v
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setTotalPage(totalPage);
        paginationDTO.setPagination(page);
        paginationDTO.setQuestionDTOS(questionDTOList);
        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        Question question = questionMapper.getById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        String creator = String.valueOf(question.getCreator());
        User user = userMapper.findById(creator);
        questionDTO.setUser(user);
        return questionDTO;
    }

    public void createOrUpdate(Question question) {
        if (question.getId() == null){
            //创建
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.create(question);
        }else {
            //更新
            question.setGmtModified(System.currentTimeMillis());
            questionMapper.update(question);
        }
    }
}
