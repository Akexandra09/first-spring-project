package ru.itgirl.firstspringproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

enum Week {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY}

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String hello (@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/dayOfWeek")
    public String dayOfWeek (@RequestParam(value = "day", defaultValue = "MONDAY") String day) {
        String dayOfWeekInRussian = "Понедельник";
        try {
            switch (Week.valueOf(day)) {
                case MONDAY:
                    dayOfWeekInRussian = "Пондельник";
                    break;
                case TUESDAY:
                    dayOfWeekInRussian = "Вторник";
                    break;
                case WEDNESDAY:
                    dayOfWeekInRussian = "Среда";
                    break;
                case THURSDAY:
                    dayOfWeekInRussian = "Четверг";
                    break;
                case FRIDAY:
                    dayOfWeekInRussian = "Пятница";
                    break;
                case SUNDAY:
                    dayOfWeekInRussian = "Суббота";
                    break;
                case SATURDAY:
                    dayOfWeekInRussian = "Воскресенье";
                    break;
            }
            return String.format("Сегодня %s!", dayOfWeekInRussian);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Неверно указан день недели");
        }
    }
}