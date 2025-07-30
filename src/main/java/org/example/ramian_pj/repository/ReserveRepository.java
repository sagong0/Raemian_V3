package org.example.ramian_pj.repository;

import org.example.ramian_pj.dto.ReserveDTO;

public interface ReserveRepository {
    int saveReserve(ReserveDTO reserveDTO);
}
