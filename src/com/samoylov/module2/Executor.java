package com.samoylov.module2;

import java.util.List;

public interface Executor <T> {



    void addTask (Task <? extends T> task) throws WrongExecuteLaunchException;

    void addTask (Task<? extends T> task, Validator<? super T> validator) throws WrongExecuteLaunchException;

    void execute();


    List<? extends T> getValidResults() throws WrongExecuteLaunchException;

    List<? extends T> getInvalidResults() throws WrongExecuteLaunchException;

}



