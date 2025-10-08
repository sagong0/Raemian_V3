package org.example.ramian_pj.service;


import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.domain.SearchType;
import org.example.ramian_pj.domain.SortOption;
import org.example.ramian_pj.dto.NoticeDTO;
import org.example.ramian_pj.dto.NoticeFileDTO;
import org.example.ramian_pj.dto.PageDTO;
import org.example.ramian_pj.dto.SearchConditionDTO;
import org.example.ramian_pj.repository.NoticeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final Logger log = LoggerFactory.getLogger(NoticeService.class);

    private final NoticeRepository noticeRepository;

    public void saveNotice(NoticeDTO noticeDTO) {
        noticeRepository.saveNotice(noticeDTO);
    }

    public void saveNoticeFile(NoticeFileDTO noticeFileDTO) {

        noticeRepository.saveNoticeFile(noticeFileDTO);
    }

//    public List<NoticeDTO> getAllNotices() {
//        return noticeRepository.getAllNotices();
//    }

    public PageDTO getPagedNotices(SearchConditionDTO searchConditionDTO){

        if (searchConditionDTO.getSearchType() == null || searchConditionDTO.getSearchType().isEmpty()) {
            searchConditionDTO.setSearchType("ntitle");
        }

        if(!SortOption.noticeValues().contains(searchConditionDTO.getSortBy())){
            searchConditionDTO.setSortBy("notice_id");
        }

        int offset = (searchConditionDTO.getPage() - 1) * searchConditionDTO.getPageSize();
        List<NoticeDTO> notices = noticeRepository.getNoticesBySearch(searchConditionDTO, offset);
        int totalCount = noticeRepository.countSearchNotices(searchConditionDTO);

        return new PageDTO(notices, totalCount, searchConditionDTO.getPage(), searchConditionDTO.getPageSize());
    }

    public int deleteNotice(String nid){
        return noticeRepository.deleteNotice(nid);
    }



    // Notice Detail
    public NoticeDTO getNoticeByIdx(Long nidx) {
        return noticeRepository.getNoticeByIdx(nidx);
    }
}
