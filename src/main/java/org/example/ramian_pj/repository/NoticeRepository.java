package org.example.ramian_pj.repository;


import org.example.ramian_pj.dto.NoticeDTO;
import org.example.ramian_pj.dto.NoticeFileDTO;

import java.util.List;

public interface NoticeRepository {
    int saveNotice(NoticeDTO noticeDTO);

    int saveNoticeFile(NoticeFileDTO noticeFileDTO);

    List<NoticeDTO> getAllNotices();
}
