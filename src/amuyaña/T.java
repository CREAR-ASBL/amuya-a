
package amuyaña;

class T {
    private double position;
    private double magnitud;

    double getPosition() {return position;}
    void setPosition(double position) {this.position = position;}
    double getMagnitud() {return magnitud;}
    void setMagnitud(double magnitud) {this.magnitud = magnitud;}

    T() {
        this.position = 0;
        this.magnitud = 0;
    }
}