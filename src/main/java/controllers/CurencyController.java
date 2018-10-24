package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("curency")
public class CurencyController {
    @GetMapping
    private String moveToWelcome() {
        return "converter";
    }

    @PostMapping
    private ModelAndView convert(@RequestParam String money, String rate) {
        try {
            Double.parseDouble(money);
            Double.parseDouble(rate);
        } catch (Throwable a) {
            return new ModelAndView("error404");
        }
        double origin = Double.parseDouble(money);
        double convertRate = Double.parseDouble(rate);
        double converted = origin * convertRate;
        ModelAndView modelAndView = new ModelAndView("converted");
        modelAndView.addObject("origin", origin);
        modelAndView.addObject("converted", converted);
        return modelAndView;
    }
}
