1class ParkingSystem {
2    int big;
3    int medium;
4    int small;
5
6    public ParkingSystem(int big, int medium, int small) {
7        this.big = big;
8        this.medium = medium;
9        this.small = small;
10            
11    }
12    
13    public boolean addCar(int carType) {
14        if (carType == 1 && big > 0) {
15            big--;
16            return true;
17        } else if (carType == 2 && medium > 0) {
18            medium--;
19            return true;
20        } else if (carType == 3 && small > 0) {
21            small--;
22            return true;
23        } else {
24            return false;
25        }
26        
27    }
28}
29
30/**
31int 1. big
32int 2. medium
33int 3. small
34
35 */
36
37/**
38 * Your ParkingSystem object will be instantiated and called as such:
39 * ParkingSystem obj = new ParkingSystem(big, medium, small);
40 * boolean param_1 = obj.addCar(carType);
41 */