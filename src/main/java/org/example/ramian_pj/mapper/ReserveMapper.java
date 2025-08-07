package org.example.ramian_pj.mapper;

import org.example.ramian_pj.dto.ReserveDTO;

public interface ReserveMapper {
    int saveReserve(ReserveDTO reserveDTO);

    ReserveDTO getReserveByMemberId(int memberId);

    int countReserveByMemberId(int memberId);
}
