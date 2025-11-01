package org.example.ramian_pj.service;

import lombok.RequiredArgsConstructor;
import org.example.ramian_pj.repository.FaqRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FaqService {

    private final FaqRepository faqRepository;

    public void findAllFaqs() {

    }
}
