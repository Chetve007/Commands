package org.itstep;

import java.util.List;

public interface NumberCommandFactory {
    public Command construct(List<Integer> lst);
}
