package com.pknu.backboard.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pknu.backboard.entity.About;
import com.pknu.backboard.entity.History;
import com.pknu.backboard.repository.HistoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HistoryService {

    @Autowired // 생략 가능
    private final HistoryRepository historyRepository;

    public void setHistory(About about, String year, String description) {

        History history = new History();

        history.setYear(year);
        history.setDescription(description);
        history.setAbout(about);

        historyRepository.save(history);
    }

    public History getHistory(Long id) {

        Optional<History> opHistory = historyRepository.findById(id);

        if (opHistory.isPresent()) {
            return opHistory.get();

        } else {
            throw new RuntimeException("history not found");
        }

    }

    public void putHistory(History history) {
        this.historyRepository.save(history);
    }
}
