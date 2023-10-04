package czitnetwork.controllers;

import czitnetwork.models.CalculateService;
import czitnetwork.models.CalculatorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("calculator")
public class CalculatorController {
    @Autowired
    private CalculateService calculateService;

    @GetMapping
    public String renderCalculator(@ModelAttribute CalculatorDTO calculatorDTO) {
        return "calculator";
    }

    @PostMapping
    public String calculate(@ModelAttribute CalculatorDTO calculatorDTO, Model model) {
        float result = calculateService.calculate(calculatorDTO);
        model.addAttribute("result", result);
        return "result";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException() {
        return "invalid-form";
    }
}
