/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.carlot.service;

import com.jdm.carlot.dao.CarLotDao;
import com.jdm.carlot.dto.Car;
import com.jdm.carlot.dto.CarKey;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class CarLotServiceImpl implements CarLotService {
    CarLotDao dao;
    
    @Override
    public Car getACar(String VIN) {
        return dao.getCar(VIN);
    }

    @Override
    public List<Car> getAllCars() {
        return dao.getCars();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        List<Car> coloredCars = new ArrayList<>();
        for(Car car : dao.getCars()){
            if(car.getColor().equals(color)){
                coloredCars.add(car);
            }
        }
        return coloredCars;
    }

    @Override
    public List<Car> getCarsInBudget(BigDecimal maxPrice) {
        List<Car> budgetCars = new ArrayList<>();
        for(Car car : dao.getCars()){
            if(car.getPrice().compareTo(maxPrice) <= 0){
                budgetCars.add(car);
            }
        }
        return budgetCars;
    }

    @Override
    public List<Car> getCarByMakeAndModel(String make, String model) {
        List<Car> specificCars = new ArrayList<>();
        for(Car car : dao.getCars()){
            if(car.getMake().equals(make) && car.getModel().equals(model)){
                specificCars.add(car);
            }
        }
        return specificCars;
    }

    @Override
    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException {
        Car car = dao.getCar(VIN);
        if(car == null){
            throw new NoSuchCarException("Car doesn't exist");
        }
        else{
            BigDecimal discountedPrice = car.getPrice().subtract(car.getPrice().multiply(percentDiscount.divide(new BigDecimal("100"))));
            return discountedPrice;
        }
    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
        Car car = dao.getCar(VIN);
        
        if(car == null){
            throw new NoSuchCarException("Car doesn't exist");
        }
        else if(car.getPrice().compareTo(cashPaid) > 0){
            throw new OverpaidPriceException("Overpaid price!");
        }
        else if(car.getPrice().compareTo(cashPaid) < 0)
        {
            throw new UnderpaidPriceException("Not enough money!");
        }
        else{
            dao.removeCar(VIN);
            return new CarKey(VIN, true);
        }
        
        
    }

}
