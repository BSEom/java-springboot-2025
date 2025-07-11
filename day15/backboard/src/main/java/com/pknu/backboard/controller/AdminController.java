package com.pknu.backboard.controller;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknu.backboard.entity.About;
import com.pknu.backboard.entity.History;
import com.pknu.backboard.service.AboutService;
import com.pknu.backboard.service.HistoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AboutService aboutService;

    private final HistoryService historyService;

    @PreAuthorize("isAuthenticated()") // 계정이 없으면 접근불가
    @GetMapping("/manage")
    public String managePage(About about) {
        About opAbout = aboutService.getAboutLatest(); // 가장 마지막 소개글 데이터 가져오기

        // About opAbout = aboutService.getAbout();

        try {
            about.setTitle(opAbout.getTitle());
            about.setSubtitle(opAbout.getSubtitle());
            about.setOurMission(opAbout.getOurMission());
            about.setOurVision(opAbout.getOurVision());
            about.setSchoolImgPath(opAbout.getSchoolImgPath());

            // 히스토리 할당
            List<History> historyList = opAbout.getHistoryList();

            if (historyList != null && historyList.size() > 0) {
                historyList.sort(Comparator.comparing(History::getYear)); // yaer 기준으로 오름차순으로 정렬
            }

            about.setHistoryList(opAbout.getHistoryList());

            // PK로 전달 필요
            about.setId(opAbout.getId());

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        return "admin/manage"; // /admin/manage.html
    }

    @PostMapping("/about")
    public String postAbout(About about, Principal principal) {

        About originAbout = aboutService.getAboutLatest();

        originAbout.setTitle(about.getTitle());
        originAbout.setSubtitle(about.getSubtitle());
        originAbout.setOurMission(about.getOurMission());
        originAbout.setOurVision(about.getOurVision());
        originAbout.setSchoolImgPath(about.getSchoolImgPath());

        // 서비스로 넘기는 파라미터가 하나(간결)
        aboutService.putAbout(originAbout);

        return "redirect:/admin/manage";
    }

    // 위랑 파라미터 전달 방식? 이 다름

    // 신규 히스토리 추가
    @PostMapping("/history/{id}")
    public String postHistory(@PathVariable("id") Long id, @RequestParam(value = "year") String year,
            @RequestParam(value = "description") String description) {

        About about = aboutService.getAbout();

        // 서비스로 넘기는 파라미터가 3개, 추후에 새 파라미터가 추가되면, 메서드도 변경되어야함
        historyService.setHistory(about, year, description);

        return "redirect:/admin/manage";
    }

    // 기존 히스토리 수정 진입(GetMapping)
    @GetMapping("/history/{id}")
    public String getHistoryModify(History history, @PathVariable("id") Long id) {
        History opHistory = this.historyService.getHistory(id);

        // about 추가 추후...
        history.setId(opHistory.getId());
        history.setYear(opHistory.getYear());
        history.setDescription(opHistory.getDescription());

        return "admin/history"; // admin/history.html
    }

    @PostMapping("/historyMod/{id}")
    public String postMethodName(History history, @PathVariable("id") Long id) {
        // 원본을 가져와서 year, description만 수정 후 save 하면 UPDATE 됨
        History originHistory = this.historyService.getHistory(id);

        originHistory.setYear(history.getYear());
        originHistory.setDescription(history.getDescription());

        historyService.putHistory(originHistory);

        return "redirect:/admin/manage"; // GetMapping
    }

}
