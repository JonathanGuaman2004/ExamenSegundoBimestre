package DataAccess;

import java.util.List;

public interface GJIDAO<T> {
    public boolean gjCreate()     throws Exception;
    public List<T> gjReadAll()            throws Exception;
    public boolean gjUpdateGenoAlimento(T entity)     throws Exception;
    public boolean gjUpdateIngestaNativa(T entity)     throws Exception;
    public boolean gjDelete(int id)       throws Exception;
    public T       gjReadBy(Integer id)   throws Exception;
    public Integer gjGetMaxRow()          throws Exception;
}
