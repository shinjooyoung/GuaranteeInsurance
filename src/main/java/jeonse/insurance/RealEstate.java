package jeonse.insurance;


import lombok.RequiredArgsConstructor;


public class RealEstate {

    private String numberName;
    private String roadName;
    private int buildingCode;
    private int deposit;

    public RealEstate(String numberName, String roadName, int buildingCode, int deposit) {
        this.numberName = numberName;
        this.roadName = roadName;
        this.buildingCode = buildingCode;
        this.deposit = deposit;
    }

    public int getJeonseRate(HouseInfo houseInfo) {
        return houseInfo.getAvailabilityCondition(this.deposit);
    }
}
