package BusinessLogic;

import java.util.List;

import DataAccess.DAO.GJHormiga_DAO;
import DataAccess.DTO.GJHormiga_DTO;

public class GJHormigaBL {
    private GJHormiga_DTO gjHormiga_DTO;
    private GJHormiga_DAO gjHormiga_DAO = new GJHormiga_DAO();

    public boolean gjAdd() throws Exception{
        return gjHormiga_DAO.gjCreate();
    }
    
    public boolean gjDelete(int idSexo) throws Exception{
        return gjHormiga_DAO.gjDelete(idSexo);
    }
    
    public Integer gjGetRowCount() throws Exception{
        return gjHormiga_DAO.gjGetMaxRow();
    }
    
    public List<GJHormiga_DTO> getAll() throws Exception{
        List<GJHormiga_DTO> lst = gjHormiga_DAO.gjReadAll();
        for (GJHormiga_DTO hormigaDTO : lst)
            hormigaDTO.setGjTipoHormiga(hormigaDTO.getGjTipoHormiga().toUpperCase());
        return lst;
    }
    
    public GJHormiga_DTO gjGetBy(int idSexo) throws Exception{
        gjHormiga_DTO = gjHormiga_DAO.gjReadBy(idSexo);
        return gjHormiga_DTO;
    }
    
    public boolean gjUpdateGenAliment(GJHormiga_DTO hormigaDTO) throws Exception{
        return gjHormiga_DAO.gjUpdateGenoAlimento(hormigaDTO);
    }
    public boolean gjUpdateIngAliment(GJHormiga_DTO hormigaDTO) throws Exception{
        return gjHormiga_DAO.gjUpdateIngestaNativa(hormigaDTO);
    }
}
