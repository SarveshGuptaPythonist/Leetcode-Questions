class ParkingSystem {
    int[] ps;
    int[] currps;
    public ParkingSystem(int big, int medium, int small) {
        ps = new int[4];
        ps[1] = big;
        ps[2] = medium;
        ps[3] = small;
        currps = new int[4];
        
    }
    
    public boolean addCar(int cartype) {
        if(currps[cartype] == ps[cartype]) return false;
        currps[cartype]++;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
