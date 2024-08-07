package fintech.data.impl.entities;

import fintech.data.declare.Entity;

public record Translation(int id, int clientId, String receivedText, String translatedText) implements Entity {
    @Override
    public int id() {
        return id;
    }
}
