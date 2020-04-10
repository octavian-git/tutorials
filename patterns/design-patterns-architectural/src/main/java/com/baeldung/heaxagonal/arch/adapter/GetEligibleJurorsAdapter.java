package com.baeldung.heaxagonal.arch.adapter;

import com.baeldung.heaxagonal.arch.port.GetEligibleJurors;

import java.util.Arrays;
import java.util.List;

public class GetEligibleJurorsAdapter implements GetEligibleJurors {
    @Override
    public List<String> execute() {
        String[] eligibleJuries = { "John", "Mary", "Stuart", "Luke", "Katy", "Tom", "Richard", "Rachel", "Susan", "Mike" };
        return Arrays.asList(eligibleJuries);
    }
}
