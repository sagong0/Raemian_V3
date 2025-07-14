package org.example.ramian_pj.service;


import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.NoticeDTO;
import org.example.ramian_pj.dto.NoticeFileDTO;
import org.example.ramian_pj.repository.NoticeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final Logger log = LoggerFactory.getLogger(NoticeService.class);

    private final NoticeRepository noticeRepository;

    public void saveNotice(NoticeDTO noticeDTO) {
        int resultSign = noticeRepository.saveNotice(noticeDTO);

        log.info("resultSign = {}", resultSign);
    }

    public void saveNoticeFile(NoticeFileDTO fileDTO) {
        log.info("saveNoticeFile 진입 !!!!!!!!!");
    }
}
