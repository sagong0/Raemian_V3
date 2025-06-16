package org.example.ramian_pj.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.ramian_pj.dto.SearchConditionDTO;
import org.example.ramian_pj.dto.UserJoinDTO;

import java.util.List;

public interface ClientMapper {
    UserJoinDTO findUserById(String mid);

    int joinUser(UserJoinDTO userJoinDTO);

    List<UserJoinDTO> getAllUsers();

    List<UserJoinDTO> getUserBySearchOption(@Param("searchConditionDTO") SearchConditionDTO searchConditionDTO, @Param("offset") int offset);

    int countSearchUsers(@Param("searchConditionDTO") SearchConditionDTO searchConditionDTO);
}
