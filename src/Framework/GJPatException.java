package Framework;

/**
 * clase para atrapar los errores
 */
public class GJPatException extends Exception {

    /**
     * Metodo que permite detectar los errores un los metodos
     * @param e: error
     * @param clase: nombre de la clase
     * @param metodo: metodo de la clase
     */
    public GJPatException(String e, String clase, String metodo) {
        System.out.println("[ERROR APP --> LOG] " + clase +"."+ metodo +" : "+ e );
    }

    @Override
    public String getMessage(){
        return "IPs..! se presento un error..";
    }
}