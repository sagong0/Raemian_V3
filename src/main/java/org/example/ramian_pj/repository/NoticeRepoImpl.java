package org.example.ramian_pj.repository;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.NoticeDTO;
import org.example.ramian_pj.mapper.NoticeMapper;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class NoticeRepoImpl implements NoticeRepository{

    private final NoticeMapper noticeMapper;

    @Override
    public int saveNotice(NoticeDTO noticeDTO) {
        noticeMapper.saveNotice(noticeDTO);
        return 0;
    }

}
