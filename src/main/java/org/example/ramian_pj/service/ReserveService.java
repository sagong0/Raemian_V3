package org.example.ramian_pj.service;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.dto.ReserveDTO;
import org.example.ramian_pj.repository.ReserveRepository;
import org.springframework.stereotype.Service;

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
}
