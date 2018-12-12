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
public class LandControlException extends Exception {

    public LandControlException() {
        //empty
    }

    public LandControlException(String message) {
        super(message);
    }

    public LandControlException(Throwable cause) {
        super(cause);
    }

    public LandControlException(String message, Throwable cause) {
        super(message, cause);
    }

    public LandControlException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
