package com.baeldung.heaxagonal.arch.adapter;

import com.baeldung.heaxagonal.arch.domain.PickJurors;
import com.baeldung.heaxagonal.arch.port.GetEligibleJurors;
import com.baeldung.heaxagonal.arch.port.CreateJury;
import com.baeldung.heaxagonal.arch.port.ShowJurors;

public class CreateJuryAdapter {

    private GetEligibleJurors getAllJuries;
    private ShowJurors showJurors;

    public CreateJuryAdapter(GetEligibleJurors getAllJuries, ShowJurors showJurors) {
        this.getAllJuries = getAllJuries;
        this.showJurors = showJurors;
    }

    public void execute(int neededJurorsNumber) {
        CreateJury createJury = new PickJurors(getAllJuries, showJurors);
        createJury.execute(neededJurorsNumber);
    }

}
