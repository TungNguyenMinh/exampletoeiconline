import com.minhtung.core.dao.RoleDao;
import com.minhtung.core.daoimpl.RoleDaoImpl;
import org.testng.annotations.Test;

public class ApiTest {
    @Test
    public void checkFindByProperty(){
         RoleDao roleDao = new RoleDaoImpl();
         String property = null;
         String value = null;
         String sortExpression = null;
         String sortDirection = null;
         Object[] objects = (Object[]) roleDao.findeByProperty(property, value, sortExpression, sortDirection);
    }
}
