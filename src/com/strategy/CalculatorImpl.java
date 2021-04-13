package com.strategy;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class CalculatorImpl {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        FileReader fileReader = new FileReader("E:\\PROJECT\\design-patterns\\src\\com\\strategy\\classes.properties");
        Properties p = new Properties();
        p.load(fileReader);

        System.out.println("Classname: "+p.getProperty("classname"));
        Class<?> clazz = Class.forName(p.getProperty("classname"));



        Calculator cal1 = new Calculator((IStrategy) clazz.getDeclaredConstructor().newInstance());
        System.out.println(cal1.execute(4,5));

        Calculator cal2 = new Calculator(new OperationSubtract());
        System.out.println(cal2.execute(90, 20));
    }
}
