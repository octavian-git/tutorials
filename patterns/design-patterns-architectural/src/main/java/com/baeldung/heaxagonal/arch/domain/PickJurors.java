package com.baeldung.heaxagonal.arch.domain;

import com.baeldung.heaxagonal.arch.port.CreateJury;
import com.baeldung.heaxagonal.arch.port.GetEligibleJurors;
import com.baeldung.heaxagonal.arch.port.ShowJurors;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PickJurors implements CreateJury {

    private GetEligibleJurors getEligibleJurors;
    private ShowJurors showJurors;

    public PickJurors(GetEligibleJurors getEligibleJurors, ShowJurors showJurors) {
        this.getEligibleJurors = getEligibleJurors;
        this.showJurors = showJurors;
    }

    @Override
    public void execute(int neededNumber) {
        List<String> eligibleJurors = getEligibleJurors.execute();
        List<String> pickedJurors = pick(eligibleJurors, neededNumber);
        showJurors.execute(pickedJurors);
    }

    private List<String> pick(List<String> eligibleJurors, int neededNumber) {
        if (neededNumber > eligibleJurors.size()) {
            throw new IllegalArgumentException("The number of needed jurors exceeds the number of eligible jurors.");
        }
        
        List<String> eligibleJurorsLinked = new LinkedList<>(eligibleJurors);
        List<String> pickedJurors = new ArrayList<>();
        
        Random random = new Random();
        
        for (int i = 0; i < neededNumber; i++) {
            int randomInt = (int) (random.nextFloat() * eligibleJurorsLinked.size());
            pickedJurors.add(eligibleJurorsLinked.get(randomInt));
            eligibleJurorsLinked.remove(randomInt);
        }

        return pickedJurors;
    }

}
