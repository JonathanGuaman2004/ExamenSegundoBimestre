package BusinessLogic.Entities.Alimento;

public class GJCarnivoro extends GJIngestaNativa{
    String gjTipo;
    
    public GJCarnivoro() {
        gjTipo = "Carnivoro";
    }

    public String toString() {
        return gjTipo;
    }
}
