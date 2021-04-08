package exceptions;

public class IDParityException extends Exception{

    public IDParityException(String id, int day) {
        super("El número de documento " + id + " no cumple las condiciones de paridad del día " + day + " y por lo tanto la persona no puede ingresar.");
    }
}
