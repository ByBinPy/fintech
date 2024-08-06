package fintech.data.impl.entities;

import fintech.data.declare.Entity;
import lombok.Getter;

@Getter
public record Translation(int clientId, String receivedText, String translatedText) implements Entity {
    @Override
    public int id() {
        return clientId;
    }
}
