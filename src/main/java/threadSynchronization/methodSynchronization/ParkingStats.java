package threadSynchronization.methodSynchronization;

public class ParkingStats {
    private long numberCars;
    private long numberMotorcycles;
    private ParkingCash cash;
    private final Object controlCars;
    private final Object controlMotors;

    public ParkingStats(ParkingCash cash) {
        numberCars = 0;
        numberMotorcycles = 0;
        this.cash = cash;
        this.controlCars = new Object();
        this.controlMotors = new Object();
    }

    public void carComeIn() {
        synchronized (controlCars) {
            numberCars++;
        }
    }

    public void carLeave() {
        synchronized (controlCars) {
            numberCars--;
        }
        this.cash.vehiclePay();
    }

    public void motoCome() {
        synchronized (controlMotors) {
            numberMotorcycles++;
        }
    }

    public void motoLeave() {
        synchronized (controlMotors) {
            numberMotorcycles--;
        }
        this.cash.vehiclePay();
    }

    public long getNumberCars() {
        return this.numberCars;
    }

    public long getNumberMotors() {
        return this.numberMotorcycles;
    }
}
