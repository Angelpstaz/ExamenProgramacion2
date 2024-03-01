package BusinessLogic;
import java.util.List;

import DataAccess.FuentePoderDAO;
import DataAccess.DTO.FuentePoderDTO;
public class FuentePoderBL {
    private FuentePoderDTO FuentePoder;
    private FuentePoderDAO rDAO = new FuentePoderDAO();

    public FuentePoderBL(){}

    public List<FuentePoderDTO> getAll() throws Exception{
        return rDAO.readAll();
    }
    public FuentePoderDTO getByIdFuentePoder(int idFuentePoder) throws Exception{
        FuentePoder = rDAO.readBy(idFuentePoder);
        return FuentePoder;
    }
    public boolean create(FuentePoderDTO FuentePoderDTO) throws Exception{   
        return rDAO.create(FuentePoderDTO);
    }
    public boolean update(FuentePoderDTO FuentePoderDTO) throws Exception{
        return rDAO.update(FuentePoderDTO);
    }
    public boolean delete(int idFuentePoder) throws Exception{
        return rDAO.delete(idFuentePoder);
    }
    public Integer getMaxRow() throws Exception{
        return rDAO.getMaxRow();
    }
}
