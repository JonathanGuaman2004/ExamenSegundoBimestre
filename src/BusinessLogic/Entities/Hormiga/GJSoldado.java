package BusinessLogic.Entities.Hormiga;

import BusinessLogic.Entities.Alimento.GJCarnivoro;
import BusinessLogic.Entities.Alimento.GJXY;
import DataAccess.DTO.GJHormiga_DTO;

public class GJSoldado extends GJHormiga{
    String gjTipo;

    public GJSoldado() {
        gjTipo = "Soldado";
    }

    @Override
    public boolean gjComerGenoAlimento(GJHormiga_DTO entity, GJXY alimento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gjComerGenoAlimento'");
    }

    @Override
    public boolean gjComerIngestaNativa(GJHormiga_DTO entity, GJCarnivoro alimento) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gjComerIngestaNativa'");
    }


}
