package org.example.ramian_pj.mapper;

import org.example.ramian_pj.dto.NoticeDTO;
import org.example.ramian_pj.dto.NoticeFileDTO;

import java.util.List;

public interface NoticeMapper {
    int saveNotice(NoticeDTO noticeDTO);

    int saveNoticeFile(NoticeFileDTO noticeFileDTO);

    List<NoticeDTO> getAllNotices();
}
