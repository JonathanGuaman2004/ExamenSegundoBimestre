package DataAccess;

import java.util.List;

public interface GJIDAO<T> {
    /**
     * Metodo que crea un objeto
     * @return retorna un booleano que dice si se pudo o no
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean gjCreate()     throws Exception;
    
    /**
     * metodo para obtener todos los datos
     * @return retorna una lista con los objetos encontrados
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public List<T> gjReadAll()            throws Exception;
    
    /**
     * Metodo para actualizar el genoalimento
     * @param entity: objeto a actualizar
     * @return retorna un boolenao que indica si se logro o no
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean gjUpdateGenoAlimento(T entity)     throws Exception;
    
    /**
     * Metodo para actualizar la ingesta nativa
     * @param entity: objeto a actualizar
     * @return retorna un boolenao que indica si se logro o no
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean gjUpdateIngestaNativa(T entity)     throws Exception;
    
    /**
     * Metodo para borrar una hormiga
     * @param id: id de la hormiga
     * @return retorna un booleano que dice si se pudo o no
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean gjDelete(int id)       throws Exception;
    
    /**
     * Metodo para buscar de uno en uno
     * @param id: id de la hormiga a buscar
     * @return retorna el DTO
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public T       gjReadBy(Integer id)   throws Exception;
    
    /**
     * Metodo para contra la cantidad de datos
     * @return retorna el numero de datos
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public Integer gjGetMaxRow()          throws Exception;
}
