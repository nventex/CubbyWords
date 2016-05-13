package com.nventex.core.views;

public class CommandResult<T> implements ICommandResult<T> {
    T data;

    public T getResultData() {
        return this.data;
    }

    public void setResultData(T data) {
        this.data = data;
    }
}
