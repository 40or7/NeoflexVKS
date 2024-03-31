package com.example.vacationcalculator.service;

import com.example.vacationcalculator.model.VacationPayResponse;
import com.example.vacationcalculator.util.HolidayDictionary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
@Component
public class VacationPayCalculatorService {

    private final HolidayDictionary holidayDictionary;

    public VacationPayCalculatorService(HolidayDictionary holidayDictionary) {
        this.holidayDictionary = holidayDictionary;
    }
    public VacationPayResponse calculateVacationPay(double averageSalary, int vacationDays) {
        if (averageSalary < 0 || vacationDays < 0) {
            throw new IllegalArgumentException("Average salary and vacation days must be non-negative.");
        }

        return new VacationPayResponse((averageSalary / 29.3) * vacationDays);
    }

    public VacationPayResponse calculateVacationPayWithDays(double averageSalary, int vacationDays, String startDay, String endDay) {
        LocalDate start = LocalDate.parse(startDay, DateTimeFormatter.ISO_DATE);
        LocalDate end = LocalDate.parse(endDay, DateTimeFormatter.ISO_DATE);
        long countDays = ChronoUnit.DAYS.between(start,end)+1;

        if (averageSalary < 1 || vacationDays < 1 || start.isAfter(end) || countDays != vacationDays) {
            throw new RuntimeException("Incorrect input data!");
        } else {
            while (!start.isAfter(end)){
                if (start.getDayOfWeek().getValue() >= 6 || holidayDictionary.isHoliday(start)){
                    vacationDays--;
                }
                start = start.plusDays(1);
            }

            return new VacationPayResponse((averageSalary / 29.3) * vacationDays);
        }
    }
}