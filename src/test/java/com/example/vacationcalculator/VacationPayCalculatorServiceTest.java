package com.example.vacationcalculator;

import com.example.vacationcalculator.model.VacationPayResponse;
import com.example.vacationcalculator.service.VacationPayCalculatorService;
import com.example.vacationcalculator.util.HolidayDictionary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class VacationPayCalculatorServiceTest {

	@Autowired
	private VacationPayCalculatorService calculator;

	@MockBean
	private  HolidayDictionary holidayDictionary;

	@BeforeEach
	public void setUp() {
		calculator = new VacationPayCalculatorService(holidayDictionary);
	}

	@Test
	public void testCalculateWithNormalTest() {
		double averageSalary = 50000;
		int vacationDays = 14;
		VacationPayResponse result = calculator.calculateVacationPay(averageSalary, vacationDays);
		assertEquals(23890.784982935154, result.getVacationPay(), "Calculation is successfully.");
	}

	@Test
	public void testCalculateWithZeroAverageSalary() {
		int vacationDays = 10;
		VacationPayResponse result = calculator.calculateVacationPay(0, vacationDays);
		assertEquals(0, result.getVacationPay(), "Calculation result should be 0 with zero average salary.");
	}


	@Test
	public void testCalculateWithZeroVacationDays() {
		double averageSalary = 1000;
		int vacationDays = 0;
		VacationPayResponse result = calculator.calculateVacationPay(averageSalary, vacationDays);
		assertEquals(0, result.getVacationPay(), "Calculation result should be 0 with zero vacation days.");
	}

	@Test
	void testCalculateVacationPayAdvanced() {
		when(holidayDictionary.isHoliday(LocalDate.of(2024,3,8))).thenReturn(true);
		double averageSalary = 50000;
		int vacationDays = 14;
		String startDay = "2024-03-01";
		String endDay = "2024-03-14";
		double expected = 15358.36; // (50000 / 29.3) * 9 (excluding 5 holidays)
		VacationPayResponse result = calculator.calculateVacationPayWithDays(averageSalary, vacationDays, startDay, endDay);
		assertEquals(expected, result.getVacationPay(), 0.01);
	}

}