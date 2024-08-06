package fintech.data.declare;

import fintech.data.impl.exceptions.DeleteRepositoryException;
import fintech.data.impl.exceptions.GetRepositoryException;
import fintech.data.impl.exceptions.SaveRepositoryException;

public interface Repository {
    Entity getById (int id) throws GetRepositoryException;
    Entity save(Entity entity) throws SaveRepositoryException;
    void delete(Entity entity) throws DeleteRepositoryException;
    void deleteById(int id) throws DeleteRepositoryException;

}
