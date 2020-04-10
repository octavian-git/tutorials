package com.baeldung.heaxagonal.arch;

import com.baeldung.heaxagonal.arch.adapter.GetEligibleJurorsAdapter;
import com.baeldung.heaxagonal.arch.adapter.CreateJuryAdapter;
import com.baeldung.heaxagonal.arch.adapter.ShowJurorsAdapter;
import com.baeldung.heaxagonal.arch.port.GetEligibleJurors;
import com.baeldung.heaxagonal.arch.port.ShowJurors;

public class PrepareTrial {
    public static void main(String[] args) {
        GetEligibleJurors getEligibleJurors = new GetEligibleJurorsAdapter();
        ShowJurors showJurors = new ShowJurorsAdapter();
        CreateJuryAdapter createJuryAdapter = new CreateJuryAdapter(getEligibleJurors, showJurors);

        createJuryAdapter.execute(3);
    }
}
