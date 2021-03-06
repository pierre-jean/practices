package fr.baraud.codingame.easy.marslander1;

import java.util.Collections;
import java.util.Scanner;

public class Builder {

    private static double MARS_GRAVITY = 3.711;

    public static LandscapeBuilder buildLandscape() {
        return new LandscapeBuilder();
    }

    public static LanderBuilder buildLander() {
        return new LanderBuilder();
    }

    public static class LandscapeBuilder {

        public LandscapeBuilder fromMars() {
            return this;
        }

        public LandscapeBuilder fromScanner(Scanner inputScanner){
            return this;
        }
        public Landscape build() {
            return new Landscape(Collections.emptyList(), new Gravity(0d));
        }

        public LandscapeBuilder addEdge(int x, int y) {
            return this;
        }
    }

    public static class LanderBuilder {
        private static final int MIN_ENGINE_POWER = 0;
        private static final int MAX_ENGINE_POWER = 4;
        private int x;
        private int y;
        private int horizontalSpeed;
        private int verticalSpeed;
        private int fuelAmount;
        private int rotationAngle;
        private int enginePower;

        public LanderBuilder fromScanner(Scanner inputScanner) {
            x = inputScanner.nextInt();
            y = inputScanner.nextInt();
            horizontalSpeed = inputScanner.nextInt();
            verticalSpeed = inputScanner.nextInt();
            fuelAmount = inputScanner.nextInt();
            rotationAngle = inputScanner.nextInt();
            enginePower = inputScanner.nextInt();
            inputScanner.nextLine();
            return this;
        }

        public LanderBuilder fromMars(){
            return this;
        }

        public LanderBuilder atXCoord(int x) {
            this.x = x;
            return this;
        }

        public LanderBuilder atYCoord(int y) {
            this.y = y;
            return this;
        }

        public LanderBuilder atHorizontalSpeed(int hSpeed) {
            this.horizontalSpeed = hSpeed;
            return this;
        }

        public LanderBuilder atVerticalSpeed(int vSpeed) {
            this.verticalSpeed = vSpeed;
            return this;
        }

        public LanderBuilder withFuelAmount(int fuel) {
            this.fuelAmount = fuel;
            return this;
        }

        public LanderBuilder withRotation(int angle) {
            this.rotationAngle = angle;
            return this;
        }

        public LanderBuilder withPower(int power) {
            this.enginePower = power;
            return this;
        }

        public LanderBuilder fromLander(Lander initLander) {
            this.x = initLander.x;
            this.y = initLander.y;
            this.horizontalSpeed = initLander .hSpeed;
            this.verticalSpeed = initLander.vSpeed;
            this.rotationAngle = initLander.rotation;
            this.fuelAmount = initLander.fuel;
            this.enginePower = initLander.power;
            return this;
        }


        public LanderBuilder next() {
            this.x = x + horizontalSpeed;
            this.y = y + verticalSpeed;
            this.horizontalSpeed = (int) (horizontalSpeed + (enginePower * Math.sin(rotationAngle)));
            this.verticalSpeed = (int) (verticalSpeed + (enginePower * Math.sin(rotationAngle)) - MARS_GRAVITY);
            return this;
        }

        public Lander build(){
            return new Lander(x,y,horizontalSpeed,verticalSpeed,fuelAmount,rotationAngle,enginePower);
        }

        public LanderBuilder decreasePower() {
            if (enginePower > MIN_ENGINE_POWER){
                enginePower --;
            }
            return this;
        }

        public LanderBuilder increasePower() {
            if (enginePower < MAX_ENGINE_POWER){
                enginePower ++;
            }
            return this;
        }
    }
}
