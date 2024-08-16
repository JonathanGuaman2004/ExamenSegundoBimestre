package BusinessLogic.Entities.Hormiga;

import BusinessLogic.Entities.Alimento.GJCarnivoro;
import BusinessLogic.Entities.Alimento.GJXY;
import DataAccess.DTO.GJHormiga_DTO;

public interface GJIHormiga {
    public boolean gjComerIngestaNativa(GJHormiga_DTO entity,GJCarnivoro alimento) throws Exception;
    public boolean gjComerGenoAlimento(GJHormiga_DTO entity,GJXY alimento);
}
