package com.pgs.apteka.medicaments.show;

import java.util.ArrayList;

public class SimpleMedicamentShow  implements IMedicaments {
    private ArrayList<SimpleMedicament> medicaments;

    public SimpleMedicamentShow(ArrayList<SimpleMedicament> medicaments) {
        this.medicaments = medicaments;
    }

    public SimpleMedicamentShow() {
    }

    public ArrayList<SimpleMedicament> getMedicaments() {
        return medicaments;
    }


}
