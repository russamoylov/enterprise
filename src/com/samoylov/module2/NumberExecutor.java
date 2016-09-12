package com.samoylov.module2;


import java.util.ArrayList;
import java.util.List;

public class NumberExecutor implements Executor<Number> {
    private List<Number> validResults = new ArrayList<>();
    private List<Number> invalidResults = new ArrayList<>();
    private List<Task<? extends Number>> taskList = new ArrayList<>();
    private Validator<Number> resultValidator = new NumberValidator();
    private Task<? extends Number> task;
    private Validator<? super Number> validator;
    private boolean isExecuteLaunched = false;


    @Override
    public void addTask(Task<? extends Number> currentTask) throws WrongExecuteLaunchException {
        this.task = currentTask;
        if (isExecuteLaunched) {
            throw new WrongExecuteLaunchException("Premature execute method launch detected!");
        }
        taskList.add(currentTask);
    }


    @Override
    public void addTask(Task<? extends Number> currentTask, Validator<? super Number> numberValidator) throws WrongExecuteLaunchException {
        this.task = currentTask;
        this.validator = numberValidator;
        if (isExecuteLaunched) {
            throw new WrongExecuteLaunchException("Premature execute method launch detected!");
        }
        taskList.add(currentTask);
    }


    @Override
    public void execute() {
        isExecuteLaunched = true;
        for (Task<? extends Number> tasks : taskList) {
            tasks.execute();
            if (validator.isValid(tasks.getResult())) {
                validResults.add(tasks.getResult());
            } else {
                invalidResults.add(tasks.getResult());
            }
        }
    }

    @Override
    public List<Number> getValidResults() throws WrongExecuteLaunchException {
        if (!isExecuteLaunched) {
            throw new WrongExecuteLaunchException("Execute method hasn't been launched!");
        }
        return validResults;

    }


    @Override
    public List<Number> getInvalidResults() throws WrongExecuteLaunchException {
        if (!isExecuteLaunched) {
            throw new WrongExecuteLaunchException("Execute method hasn't been launched!");
        }
        return invalidResults;
    }
}

