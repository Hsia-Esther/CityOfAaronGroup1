/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author conta
 */
public class StorehouseControlException extends Exception {

    public StorehouseControlException() {
        //empty
    }

    public StorehouseControlException(String message) {
        super(message);
    }

    public StorehouseControlException(Throwable cause) {
        super(cause);
    }

    public StorehouseControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorehouseControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
