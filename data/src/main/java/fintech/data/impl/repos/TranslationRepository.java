package fintech.data.impl.repos;

import fintech.data.declare.Entity;
import fintech.data.declare.Repository;
import fintech.data.impl.entities.Translation;
import fintech.data.impl.exceptions.DeleteRepositoryException;
import fintech.data.impl.exceptions.GetRepositoryException;
import fintech.data.impl.exceptions.SaveRepositoryException;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@org.springframework.stereotype.Repository
public class TranslationRepository implements Repository {

    private final Connection connection;

    @Autowired
    public TranslationRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Translation getById(int id) throws GetRepositoryException {
        String query = "SELECT * FROM translations WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Translation(
                        id,
                        rs.getInt("client_id"),
                        rs.getString("received_text"),
                        rs.getString("translatedText")
                );
            }
        } catch (SQLException e) {
            throw new GetRepositoryException();
        }
        return null;
    }

    @Override
    public Translation save(Entity entity) throws SaveRepositoryException {
        if (!(entity instanceof Translation translation)) {
            throw new IllegalArgumentException("Invalid entity type");
        }
        String query = "INSERT INTO translations (id, client_id, received_text, translated_text) VALUES (?, ?, ?, ?) ";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, translation.id());
            stmt.setInt(2, translation.clientId());
            stmt.setString(3, translation.receivedText());
            stmt.setString(4, translation.translatedText());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SaveRepositoryException();
        }
        return translation;
    }

    @Override
    public void delete(Entity entity) throws DeleteRepositoryException {
        if (!(entity instanceof Translation translation)) {
            throw new IllegalArgumentException("Invalid entity type");
        }
        deleteById(translation.clientId());
    }

    @Override
    public void deleteById(int id) throws DeleteRepositoryException {
        String query = "DELETE FROM translations WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DeleteRepositoryException();
        }
    }

    public int getCountTranslations() throws GetRepositoryException {
        String query = "SELECT COUNT(*) AS CNT FROM translations";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("CNT");
            }

        } catch (SQLException e) {
            throw new GetRepositoryException();
        }
        return 0;
    }
}
