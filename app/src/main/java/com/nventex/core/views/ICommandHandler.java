package com.nventex.core.views;

public interface ICommandHandler<T> {
    void Execute(ICommand iCommand);

    ICommandResult<T> getCommandResult();
}
