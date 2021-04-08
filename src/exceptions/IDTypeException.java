package exceptions;

public class IDTypeException extends Exception {

    public IDTypeException(String id) {
        super("El número de documento " + id + " pertenece a una tarjeta de identidad y por lo tanto la persona no puede ingresar.");
    }

}
