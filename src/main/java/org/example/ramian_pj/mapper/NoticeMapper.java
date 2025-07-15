package org.example.ramian_pj.mapper;

import org.example.ramian_pj.dto.NoticeDTO;
import org.example.ramian_pj.dto.NoticeFileDTO;

public interface NoticeMapper {
    int saveNotice(NoticeDTO noticeDTO);

    int saveNoticeFile(NoticeFileDTO noticeFileDTO);
}
