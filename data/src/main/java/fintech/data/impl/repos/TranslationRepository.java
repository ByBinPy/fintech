package fintech.data.impl.repositories;

import fintech.data.declare.Entity;
import fintech.data.declare.Repository;
import fintech.data.impl.entities.Translation;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TranslationRepository implements Repository {

    private final Connection connection;

    @Autowired
    public TranslationRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Entity getById(int id) {
        String query = "SELECT * FROM translations WHERE client_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Translation(
                        rs.getInt("client_id"),
                        rs.getString("received_text"),
                        rs.getString("translatedText")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Entity save(Entity entity) {
        if (!(entity instanceof Translation translation)) {
            throw new IllegalArgumentException("Invalid entity type");
        }
        String query = "INSERT INTO translations (client_id, received_text, translated_text) VALUES (?, ?, ?) " +
                "ON CONFLICT (client_id) DO UPDATE SET received_text = ?, translated_text = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, translation.clientId());
            stmt.setString(2, translation.receivedText());
            stmt.setString(3, translation.translatedText());
            stmt.setString(4, translation.receivedText());
            stmt.setString(5, translation.translatedText());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return translation;
    }

    @Override
    public void delete(Entity entity) {
        if (!(entity instanceof Translation translation)) {
            throw new IllegalArgumentException("Invalid entity type");
        }
        deleteById(translation.clientId());
    }

    @Override
    public void deleteById(int id) {
        String query = "DELETE FROM translations WHERE client_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
