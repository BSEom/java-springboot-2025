package com.pknu.backboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pknu.backboard.entity.About;
import com.pknu.backboard.service.AboutService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/intro")
@RequiredArgsConstructor
public class IntroController {

    private final AboutService aboutService;

    @GetMapping("/about")
    public String aboutPage(Model model) {

        // DB에서 동적으로 들고올 데이터 가져오기
        About about = aboutService.getAbout();

        model.addAttribute("about", about); // FE로 넘겨줄 준비 끝

        return "intro/about"; // intro/about.html 리턴

    }

    @GetMapping("/admissions")
    public String admissionsPage() {
        // Static 페이지로 대체

        return "intro/admissions"; // intro/admissions.html 리턴
    }

    @GetMapping("/academics")
    public String academicsPage() {
        // Static 페이지로 대체

        return "intro/academics"; // intro/academics.html 리턴
    }

    // events
    @GetMapping("/events")
    public String eventsPage() {
        // Static 페이지로 대체

        return "intro/events"; // intro/events.html 리턴
    }

    // contact
    @GetMapping("/contact")
    public String contactPage() {
        // Static 페이지로 대체

        return "intro/contact"; // intro/contact.html 리턴
    }
}
