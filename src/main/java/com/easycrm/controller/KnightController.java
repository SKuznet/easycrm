package com.easycrm.controller;

import com.easycrm.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KnightController {
    private KnightService knightService;

    @RequestMapping("/knight/{enemy}")
    public String getKnightAction(@PathVariable("enemy") String enemy, Model model) {
        model.addAttribute("result", knightService.getAchievement(enemy));
        return "knight";
    }

    @Autowired
    public void setKnightService(KnightService knightService) {
        this.knightService = knightService;
    }
}
