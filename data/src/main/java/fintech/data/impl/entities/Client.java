package fintech.data.impl.entities;

import fintech.data.declare.Entity;
import lombok.Getter;

@Getter
public record Client(int id, String ip) implements Entity {

}
