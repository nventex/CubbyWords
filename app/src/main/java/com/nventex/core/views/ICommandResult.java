package com.nventex.core.views;

public interface ICommandResult<T> {
    T getResultData();

    void setResultData(T t);
}
