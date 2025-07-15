package org.example.ramian_pj.repository;


import org.example.ramian_pj.dto.NoticeDTO;
import org.example.ramian_pj.dto.NoticeFileDTO;

public interface NoticeRepository {
    int saveNotice(NoticeDTO noticeDTO);

    int saveNoticeFile(NoticeFileDTO noticeFileDTO);
}
