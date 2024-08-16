package BusinessLogic.Entities;

public class GJEcuaFauna {

    private static GJEcuaFauna instance;
    private static String nombre;

    // hacer el constructor privado para evitar la inicializado
    private GJEcuaFauna() { }
    protected GJEcuaFauna(GJEcuaFauna GJEcuaFauna) { 
        if (GJEcuaFauna != null)
            instance = GJEcuaFauna;
    }

    public static GJEcuaFauna getInstance(String nombre) {
        if (instance == null){
            instance = new GJEcuaFauna();
            instance.setNombre(nombre);
        }
        return instance;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
