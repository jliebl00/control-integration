/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.unileon.ulebank.history;

import es.unileon.ulebank.handler.Handler;

/**
 *
 * @author roobre
 */
public class TransactionHandler implements Handler {

    private final long id;
    private final String timestamp;

    public TransactionHandler(long id, String timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return timestamp + "." + Long.toString(id);
    }

    @Override
    public int compareTo(Handler another) {
        return this.toString().compareTo(another.toString());
    }

}
