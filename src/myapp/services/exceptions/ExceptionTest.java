package myapp.services.exceptions;

import javax.ejb.ApplicationException;

// défaire les modifications déjà effectuées.
@ApplicationException(rollback = true)
public class ExceptionTest extends Exception{
    public ExceptionTest(String msg) {
        super(msg);
    }
}