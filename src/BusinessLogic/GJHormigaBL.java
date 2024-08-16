package BusinessLogic;

import java.util.List;
import DataAccess.DAO.GJHormiga_DAO;
import DataAccess.DTO.GJHormiga_DTO;

/**
 * Clase de Business logic de las hormigas
 */
public class GJHormigaBL {
    private GJHormiga_DTO gjHormiga_DTO;
    private GJHormiga_DAO gjHormiga_DAO = new GJHormiga_DAO();

    /**
     * Metodo para a;adir una larva
     * @return retorna un booleano que dice si se pudo o no
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean gjAdd() throws Exception{
        return gjHormiga_DAO.gjCreate();
    }
    
    /**
     * Metodo para borrar una hormiga
     * @param gjIDHormiga: id de la hormiga
     * @return retorna un booleano que dice si se pudo o no
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean gjDelete(int gjIDHormiga) throws Exception{
        return gjHormiga_DAO.gjDelete(gjIDHormiga);
    }
    
    /**
     * Metodo para contra la cantidad de datos
     * @return retorna el numero de datos
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public Integer gjGetRowCount() throws Exception{
        return gjHormiga_DAO.gjGetMaxRow();
    }
    
    /**
     * metodo para obtener todos los datos
     * @return retorna una lista con los objetos encontrados
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public List<GJHormiga_DTO> getAll() throws Exception{
        List<GJHormiga_DTO> lst = gjHormiga_DAO.gjReadAll();
        for (GJHormiga_DTO hormigaDTO : lst)
            hormigaDTO.setGjTipoHormiga(hormigaDTO.getGjTipoHormiga().toUpperCase());
        return lst;
    }
    
    /**
     * Metodo para buscar de uno en uno
     * @param gjIDHormiga: id de la hormiga a buscar
     * @return retorna el DTO
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public GJHormiga_DTO gjGetBy(int gjIDHormiga) throws Exception{
        gjHormiga_DTO = gjHormiga_DAO.gjReadBy(gjIDHormiga);
        return gjHormiga_DTO;
    }
    
    /**
     * Metodo para actualizar el genoalimento
     * @param hormigaDTO: objeto a actualizar
     * @return retorna un boolenao que indica si se logro o no
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean gjUpdateGenAliment(GJHormiga_DTO hormigaDTO) throws Exception{
        return gjHormiga_DAO.gjUpdateGenoAlimento(hormigaDTO);
    }

    /**
     * Metodo para actualizar la ingesta nativa
     * @param hormigaDTO: objeto a actualizar
     * @return retorna un boolenao que indica si se logro o no
     * @throws Exception: En caso de haber errores, se lanzará esta excepcion que indicará el error o el problema de su ejecucion
     */
    public boolean gjUpdateIngAliment(GJHormiga_DTO hormigaDTO) throws Exception{
        return gjHormiga_DAO.gjUpdateIngestaNativa(hormigaDTO);
    }
}
