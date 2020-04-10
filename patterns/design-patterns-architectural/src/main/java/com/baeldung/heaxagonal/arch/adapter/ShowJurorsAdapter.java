package com.baeldung.heaxagonal.arch.adapter;

import com.baeldung.heaxagonal.arch.port.ShowJurors;

import java.util.List;

public class ShowJurorsAdapter implements ShowJurors {
    @Override
    public void execute(List<String> jurors) {
        jurors.forEach(System.out::println);
    }
}
