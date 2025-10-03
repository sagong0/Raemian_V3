package org.example.ramian_pj.repository;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.ReserveDTO;
import org.example.ramian_pj.mapper.ReserveMapper;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReserveRepoImpl implements ReserveRepository{

    private final ReserveMapper reserveMapper;

    @Override
    public int saveReserve(ReserveDTO reserveDTO) {

        return reserveMapper.saveReserve(reserveDTO);
    }

    @Override
    public ReserveDTO getReserveByMemberId(int memberId) {
        return reserveMapper.getReserveByMemberId(memberId);
    }

    @Override
    public int countReserveByMemberId(int memberId) {
        return reserveMapper.countReserveByMemberId(memberId);
    }

    @Override
    public int cancelReserveByMemberId(int memberId) {
        return reserveMapper.cancelReserveByMemberId(memberId);
    }

    @Override
    public int modifyReserveByMemberId(ReserveDTO reserveDTO) {
        return reserveMapper.modifyReserveByMemberId(reserveDTO);
    }
}
