package org.example.ramian_pj.repository;


import org.example.ramian_pj.dto.NoticeDTO;

public interface NoticeRepository {
    int saveNotice(NoticeDTO noticeDTO);
}
