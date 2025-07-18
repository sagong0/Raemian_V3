package org.example.ramian_pj.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.ramian_pj.dto.NoticeDTO;
import org.example.ramian_pj.dto.NoticeFileDTO;
import org.example.ramian_pj.dto.SearchConditionDTO;

import java.util.List;

public interface NoticeMapper {
    int saveNotice(NoticeDTO noticeDTO);

    int saveNoticeFile(NoticeFileDTO noticeFileDTO);

    List<NoticeDTO> getAllNotices();

    List<NoticeDTO> getNoticesBySearchOption(@Param("searchConditionDTO") SearchConditionDTO searchConditionDTO, @Param("offset") int offset);

    int countSearchNotices(@Param("searchConditionDTO") SearchConditionDTO searchConditionDTO);

    int deleteNotice(String nid);
}
