package org.example.ramian_pj.service;


import org.example.ramian_pj.dto.NoticeDTO;
import org.example.ramian_pj.dto.NoticeFileDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

    private final Logger log = LoggerFactory.getLogger(NoticeService.class);

    public void saveNotice(NoticeDTO noticeDTO) {
        log.info("saveNotice 진입 !!! ");
    }

    public void saveNoticeFile(NoticeFileDTO fileDTO) {
        log.info("saveNoticeFile 진입 !!!!!!!!!");
    }
}
