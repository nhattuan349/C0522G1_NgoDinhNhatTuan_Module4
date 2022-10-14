package com.caculator.service;

import org.springframework.stereotype.Service;

@Service
public class CaculatorService implements ICaculatorService{
    @Override
    public double calculator(double firstOperand, double secondOperand, String operator) {
        switch (operator){
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand != 0)
                    return  firstOperand / secondOperand;
                else
                    throw new RuntimeException("Khong the chia cho 0");
            default:
                throw new RuntimeException("Khong hop le");
        }
    }
}
