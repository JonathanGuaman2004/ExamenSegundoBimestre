package DataAccess.DTO;

public class GJHormiga_DTO {

    private Integer gjRowNum;
    private Integer gjIDHormiga;
    private String  gjTipoHormiga;
    private Integer gjSexo;
    private Integer gjProvincia;
    private Integer gjGenoAlimento;
    private Integer gjIngestaNativa;
    private String gjNombreGenoAlimento;
    private String gjNombreIngestaNativa;
    private String gjNombreSexo;
    private String gjNombreProvincia;
    private String gjEstadoCondición;
    private String gjEstado;

    /**
     * ConstructorUno
     * @param gjTipoHormiga: gjTipoHormiga
     */
    public GJHormiga_DTO(String gjTipoHormiga) {
        this.gjTipoHormiga = gjTipoHormiga;
    }

    /**
     * Constructor Vacio
     */
    public GJHormiga_DTO() {
    }

    /**
     * ConstructoDos
     * @param gjRowNum: gjRowNum
     * @param gjIDHormiga: gjIDHormiga
     * @param gjTipoHormiga: gjTipoHormiga
     * @param gjNombreGenoAlimento: gjNombreGenoAlimento
     * @param gjNombreIngestaNativa: gjNombreIngestaNativa
     * @param gjNombreSexo: gjNombreSexo
     * @param gjNombreProvincia: gjNombreProvincia
     * @param gjEstadoCondición: gjEstadoCondición
     */
    public GJHormiga_DTO(Integer gjRowNum, Integer gjIDHormiga, String gjTipoHormiga, String gjNombreGenoAlimento,
            String gjNombreIngestaNativa, String gjNombreSexo, String gjNombreProvincia, String gjEstadoCondición) {
        this.gjRowNum = gjRowNum;
        this.gjIDHormiga = gjIDHormiga;
        this.gjTipoHormiga = gjTipoHormiga;
        this.gjNombreGenoAlimento = gjNombreGenoAlimento;
        this.gjNombreIngestaNativa = gjNombreIngestaNativa;
        this.gjNombreSexo = gjNombreSexo;
        this.gjNombreProvincia = gjNombreProvincia;
        this.gjEstadoCondición = gjEstadoCondición;
    }

    public Integer getGjIDHormiga() {
        return gjIDHormiga;
    }
    public void setGjIDHormiga(Integer gjIDHormiga) {
        this.gjIDHormiga = gjIDHormiga;
    }
    public String getGjTipoHormiga() {
        return gjTipoHormiga;
    }
    public void setGjTipoHormiga(String gjTipoHormiga) {
        this.gjTipoHormiga = gjTipoHormiga;
    }
    public Integer getGjSexo() {
        return gjSexo;
    }
    public void setGjSexo(Integer gjSexo) {
        this.gjSexo = gjSexo;
    }
    public Integer getGjProvincia() {
        return gjProvincia;
    }
    public void setGjProvincia(Integer gjProvincia) {
        this.gjProvincia = gjProvincia;
    }
    public Integer getGjGenoAlimento() {
        return gjGenoAlimento;
    }
    public void setGjGenoAlimento(Integer gjGenoAlimento) {
        this.gjGenoAlimento = gjGenoAlimento;
    }
    public Integer getGjIngestaNativa() {
        return gjIngestaNativa;
    }
    public void setGjIngestaNativa(Integer gjIngestaNativa) {
        this.gjIngestaNativa = gjIngestaNativa;
    }
    public String getGjNombreSexo() {
        return gjNombreSexo;
    }
    public void setGjNombreSexo(String gjNombreSexo) {
        this.gjNombreSexo = gjNombreSexo;
    }
    public String getGjNombreProvincia() {
        return gjNombreProvincia;
    }
    public void setGjNombreProvincia(String gjNombreProvincia) {
        this.gjNombreProvincia = gjNombreProvincia;
    }
    public String getGjNombreGenoAlimento() {
        return gjNombreGenoAlimento;
    }
    public void setGjNombreGenoAlimento(String gjNombreGenoAlimento) {
        this.gjNombreGenoAlimento = gjNombreGenoAlimento;
    }
    public String getGjNombreIngestaNativa() {
        return gjNombreIngestaNativa;
    }
    public void setGjNombreIngestaNativa(String gjNombreIngestaNativa) {
        this.gjNombreIngestaNativa = gjNombreIngestaNativa;
    }
    public String getGjEstadoCondición() {
        return gjEstadoCondición;
    }
    public void setGjEstadoCondición(String gjEstadoCondición) {
        this.gjEstadoCondición = gjEstadoCondición;
    }
    public String getGjEstado() {
        return gjEstado;
    }
    public void setGjEstado(String gjEstado) {
        this.gjEstado = gjEstado;
    }
    public Integer getGjRowNum() {
        return gjRowNum;
    }
    public void setGjRowNum(Integer gjRowNum) {
        this.gjRowNum = gjRowNum;
    }

    
}
