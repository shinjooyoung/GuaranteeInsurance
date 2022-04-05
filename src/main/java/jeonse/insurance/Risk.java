package jeonse.insurance;

public class Risk {

    private HouseInfo houseInfo;

    public RiskType getRisk(int price) {
        return calculateMortgage(price);
    }

    private RiskType calculateMortgage(int price){
        int standard = houseInfo.getGuaranteeInsuranceAmount();

        if(price > standard) {
            return RiskType.DANGER;
        } else {
            return RiskType.SAFETY;
        }
    }


}
