package com.example.vacationcalculator.CalculationController;


import com.example.vacationcalculator.model.VacationPayRequest;
import com.example.vacationcalculator.model.VacationPayResponse;
import com.example.vacationcalculator.service.VacationPayCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculationController {

    @Autowired
    private  VacationPayCalculatorService vacationPayCalculatorService;

    @GetMapping("/calculate")
    public VacationPayResponse calculateVacationPay(
            @RequestParam double averageSalary,
            @RequestParam int vacationDays,
            @RequestParam(required = false) String startDay,
            @RequestParam(required = false) String endDay) {
        VacationPayResponse vacationPay = null;
            if (startDay == null || endDay == null) {
                vacationPay = vacationPayCalculatorService.calculateVacationPay(averageSalary, vacationDays);
            } else {
                vacationPay = vacationPayCalculatorService.calculateVacationPayWithDays(averageSalary, vacationDays, startDay, endDay);
            }

            return vacationPay;
    }
}