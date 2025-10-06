package org.example.ramian_pj.service;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.AdminReserveDTO;
import org.example.ramian_pj.dto.ReserveDTO;
import org.example.ramian_pj.repository.ReserveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReserveService {

    private final ReserveRepository reserveRepository;

    public int saveReserve(ReserveDTO reserveDTO) {
        return reserveRepository.saveReserve(reserveDTO);
    }

    public ReserveDTO getReservationByMemberId(int memberId) {

        return reserveRepository.getReserveByMemberId(memberId);
    }

    public boolean hasActiveReserve(int memberId) {

        return reserveRepository.countReserveByMemberId(memberId) > 0;
    }


    // 취소 부분
    public int cancelReserveByMemberId(int memberId) {
        return reserveRepository.cancelReserveByMemberId(memberId);
    }

    public int modifyReserve(ReserveDTO reserveDTO) {
        return reserveRepository.modifyReserveByMemberId(reserveDTO);
    }


    /**
     * For Admin Services
     */

    public List<AdminReserveDTO> getAllReservesForAdmin() {
        return reserveRepository.getAllReservesForAdmin();
    }
}
