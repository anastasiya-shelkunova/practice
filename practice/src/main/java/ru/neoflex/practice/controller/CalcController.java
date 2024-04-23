package ru.neoflex.practice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CalcController {
//сложение
    @GetMapping("/plus/{a}/{b}")
    public int add(@PathVariable("a")int a, @PathVariable("b") int b) {return a+b;}
    //вычитание
    @GetMapping("/minus/{a}/{b}")
    public int subtract(@PathVariable ("a")int a, @PathVariable("b")int b){return a-b;}
}