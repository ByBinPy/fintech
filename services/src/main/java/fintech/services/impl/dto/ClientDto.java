package fintech.services.impl.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
    private int id;
    private String ip;
}
