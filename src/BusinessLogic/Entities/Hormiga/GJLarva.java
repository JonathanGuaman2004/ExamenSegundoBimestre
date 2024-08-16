package BusinessLogic.Entities.Hormiga;

import BusinessLogic.GJHormigaBL;
import BusinessLogic.Entities.Alimento.GJCarnivoro;
import BusinessLogic.Entities.Alimento.GJXY;
import DataAccess.DTO.GJHormiga_DTO;

public class GJLarva extends GJHormiga{
    String tipo;
    private GJHormigaBL bl = new GJHormigaBL();
    
    public GJLarva() {
        tipo = "Larva";
    }
    
    
    
    public String getTipo() {
        return tipo;
    }



    @Override
    public boolean gjComerIngestaNativa(GJHormiga_DTO entity, GJCarnivoro alimento) {
        System.out.println(entity.getGjNombreIngestaNativa());
        if(entity.getGjNombreIngestaNativa().equals(alimento.toString())){
            entity.setGjIngestaNativa(4);
        }else if(entity.getGjNombreIngestaNativa().equals("Herbivoro")){
            entity.setGjIngestaNativa(5);
        }else if(entity.getGjNombreIngestaNativa().equals("Omnivoro")){
            entity.setGjIngestaNativa(6);
        }else if(entity.getGjNombreIngestaNativa().equals("Insectivoro")){
            entity.setGjIngestaNativa(7);
        }else{
            entity.setGjIngestaNativa(8);
        }

        try {
            return bl.gjUpdateIngAliment(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }



    @Override
    public boolean gjComerGenoAlimento(GJHormiga_DTO entity, GJXY alimento) {
        if(entity.getGjNombreGenoAlimento().equals(alimento.toString())){
            entity.setGjGenoAlimento(11);
        }else if(entity.getGjNombreGenoAlimento().equals("X")){
            entity.setGjGenoAlimento(9);
        }else{
            entity.setGjGenoAlimento(10);
        }

        try {
            return bl.gjUpdateGenAliment(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
