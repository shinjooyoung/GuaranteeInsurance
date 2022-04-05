package jeonse.insurance;

import java.time.LocalDateTime;

public class HouseInfo {

    private LocalDateTime lastUpdtDt;
    private String aphusSeCodeNm;
    private int pblntfPc;
    private int Mortgage;

    public int getGuaranteeInsuranceAmount() {
        return (int) (this.pblntfPc * 1.5 - this.Mortgage);
    }


}
