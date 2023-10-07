// =========================================================
// Do NOT modify this file 
// =========================================================

class Apartment {
    String district;
    int price, area; // gia tien va dien tich cua can ho
    
    // Default constructure
    Apartment () {}
    
    // Constructor with full parameter
    Apartment (String xDistrict, int xPrice, int xArea) {
        this.district = xDistrict;
        this.price = xPrice; 
        this.area = xArea;
    }
    
    @Override
    public String toString(){
        return "(" +district+","+price + "," + area + ")";
    }

    public int getPrice() {
        return this.price;
    }
    public int getArea() {
        return this.area;
    }
    public String getDistrict() {
        return this.district;
    }
    public void setArea(int inArea) {
        this.area = inArea;
    }
    public void setPrice(int inPrice) {
        this.price = inPrice;
    }
    public void setDistrict(String inDistrict) {
        this.district = inDistrict;
    }
}
