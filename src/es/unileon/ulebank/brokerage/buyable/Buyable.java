/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.brokerage.buyable;

import java.util.logging.Handler;

/**
 *
 * @author roobre
 */
public class Buyable {

    protected final Handler id;
    protected int amount;
    protected int purchasedAmount;
    protected double totalPrice;

    public Buyable(Handler id, int amount, double totalPrice) throws InvalidBuyableException {
        if (totalPrice < 0) {
            throw new InvalidBuyableException("Price", "greater", 0);
        }

        if (amount < 0) {
            throw new InvalidBuyableException("Participations", "greater", 0);
        }

        this.id = id;
        this.amount = amount;
        this.totalPrice = totalPrice;
        this.purchasedAmount = 0;
    }

    public double getPPP() {
        return this.totalPrice / this.amount;
    }

    public void setPPP(double ppp, int participations) {
        this.totalPrice = ppp * participations;
    }

    public void setPPP(double ppp, double totalPrice) throws InvalidNumberOfParticipationsException, TotalLowerThanBoughtException {
        if (totalPrice % ppp != 0) {
            throw new InvalidNumberOfParticipationsException(totalPrice, ppp);
        } else if ((int) (totalPrice / ppp) < this.purchasedAmount) {
            throw new TotalLowerThanBoughtException();
        }
        this.amount = (int) (totalPrice / ppp);
    }

    /**
     * @return the fundID
     */
    public Handler getFoundID() {
        return id;
    }

    /**
     * @return the participations
     */
    public int getParticipations() {
        return amount;
    }

    /**
     * @return the totalPrice
     */
    public double getPrice() {
        return totalPrice;
    }

    /**
     * @param participations the participations to buy
     * @throws es.unileon.ulebank.exceptions.NotEnoughParticipationsException
     */
    public void buy(int participations) throws NotEnoughParticipationsException {
        if (participations > this.amount - this.purchasedAmount) {
            throw new NotEnoughParticipationsException();
        }
        this.purchasedAmount += participations;
    }

    public int getBuyableParticipations() {
        return this.amount - this.purchasedAmount;
    }

}
