package org.example.ramian_pj.repository;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.NoticeDTO;
import org.example.ramian_pj.dto.NoticeFileDTO;
import org.example.ramian_pj.dto.SearchConditionDTO;
import org.example.ramian_pj.mapper.NoticeMapper;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class NoticeRepoImpl implements NoticeRepository{

    private final NoticeMapper noticeMapper;

    @Override
    public int saveNotice(NoticeDTO noticeDTO) {
        return noticeMapper.saveNotice(noticeDTO);
    }

    @Override
    public int saveNoticeFile(NoticeFileDTO noticeFileDTO) {
        return noticeMapper.saveNoticeFile(noticeFileDTO);
    }

    @Override
    public List<NoticeDTO> getAllNotices() {
        return noticeMapper.getAllNotices();
    }

    @Override
    public List<NoticeDTO> getNoticesBySearch(SearchConditionDTO searchConditionDTO, int offset) {
        return noticeMapper.getNoticesBySearchOption(searchConditionDTO,offset);
    }

    @Override
    public int countSearchNotices(SearchConditionDTO searchConditionDTO) {
        return noticeMapper.countSearchNotices(searchConditionDTO);
    }

    @Override
    public int deleteNotice(String nid) {
        return noticeMapper.deleteNotice(nid);
    }

}
