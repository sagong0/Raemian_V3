package org.example.ramian_pj.mapper;

import org.example.ramian_pj.dto.AdminReserveDTO;
import org.example.ramian_pj.dto.ReserveDTO;

import java.util.List;

public interface ReserveMapper {
    int saveReserve(ReserveDTO reserveDTO);

    ReserveDTO getReserveByMemberId(int memberId);

    int countReserveByMemberId(int memberId);

    int cancelReserveByMemberId(int memberId);

    int modifyReserveByMemberId(ReserveDTO reserveDTO);

    List<AdminReserveDTO> getAllReservesForAdmin();
}
