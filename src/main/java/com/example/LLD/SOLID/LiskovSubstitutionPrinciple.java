package com.example.LLD.SOLID;

public class LiskovSubstitutionPrinciple {


    // parent class and child class will be there and the properties of parent class should not be minimalised

    class Rectangle {
        protected int width;
        protected int height;

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getArea() {
            return width * height;
        }
    }

    class Square extends Rectangle {
        @Override
        public void setWidth(int width) {
            this.width = width;
            this.height = width; // Maintain square property
        }

        @Override
        public void setHeight(int height) {
            this.width = height;
            this.height = height; // Maintain square property
        }
    }

    public void main(String[] args) {
            Rectangle rect = new Rectangle();
            rect.setWidth(5);
            rect.setHeight(10);
            System.out.println("Rectangle Area: " + rect.getArea()); // Expected: 50

            Rectangle square = new Square();
            square.setWidth(5);
            square.setHeight(10); // Violates expectation of setting independent dimensions
            System.out.println("Square Area: " + square.getArea()); // Output: 100 (Incorrect behavior)
        }

}




