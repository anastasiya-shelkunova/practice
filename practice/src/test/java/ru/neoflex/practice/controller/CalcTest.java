package ru.neoflex.practice.controller;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class CalcTest {
    CalcController calcController = new CalcController();
    void testAdd(int a, int b, int expected) {
        int add = calcController.add(a, b);
        Assertions.assertEquals(expected, add);}
        void testSubtract ( int a, int b, int expected){
            int subtract = calcController.subtract(a, b);
            Assertions.assertEquals(expected, subtract);}
            @Test
            void add () {
                testAdd(5, 7, 12);
            }
            @Test
            void substract () {
                testSubtract(7, 5, 2);
            }
        }
