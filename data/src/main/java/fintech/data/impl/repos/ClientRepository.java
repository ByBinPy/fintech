package fintech.data.impl.repos;

import fintech.data.declare.Entity;
import fintech.data.declare.Repository;
import fintech.data.impl.entities.Client;
import fintech.data.impl.exceptions.DeleteRepositoryException;
import fintech.data.impl.exceptions.GetRepositoryException;
import fintech.data.impl.exceptions.SaveRepositoryException;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@org.springframework.stereotype.Repository
public class ClientRepository implements Repository {

    private final Connection connection;

    @Autowired
    public ClientRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Entity getById(int id) throws GetRepositoryException {
        String query = "SELECT id, ip FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Client(rs.getInt("id"), rs.getString("ip"));
            }
        } catch (SQLException e) {
            throw new GetRepositoryException();
        }
        return null;
    }

    @Override
    public Entity save(Entity entity) throws SaveRepositoryException {
        if (entity instanceof Client client) {
            String query = "INSERT INTO users (id, ip) VALUES (?, ?) ON CONFLICT (id) DO UPDATE SET ip = EXCLUDED.ip RETURNING *";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, client.id());
                stmt.setString(2, client.ip());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return new Client(rs.getInt("id"), rs.getString("ip"));
                }
            } catch (SQLException e) {
                throw new SaveRepositoryException();
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) throws DeleteRepositoryException {
        String query = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
        } catch (SQLException e) {
            throw new DeleteRepositoryException();
        }
    }

    @Override
    public void delete(Entity entity) throws DeleteRepositoryException {
        if (entity instanceof Client client) {
            deleteById(client.id());
        }
    }
}
