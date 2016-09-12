package com.samoylov.module2;

import java.util.Arrays;
import java.util.List;


public class Test {

    public static void main(String[] args) {

        try {
            List<Task<Integer>> taskIntList = Arrays.asList(new AddInteger(9, 15), new AddInteger(-34, -25), new AddInteger(8, 8));

            Executor<Number> numberExecutor = new NumberExecutor();


            for (Task<Integer> intTask : taskIntList) {
                numberExecutor.addTask(intTask);
            }

            numberExecutor.addTask(new AddDouble(93.2, 25.3), new NumberValidator());

            numberExecutor.execute();

            System.out.println("Valid results: ");
            numberExecutor.getValidResults().forEach(System.out::println);

            System.out.println("Invalid results: ");
            numberExecutor.getInvalidResults().forEach(System.out::println);

        } catch (WrongExecuteLaunchException e) {
            System.out.println("Premature launch or no launch execute's method detected!");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Error! Wrong command sequence!");
            e.printStackTrace();
        }
    }
}
