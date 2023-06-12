package ir.digixo.notification;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class NoticationRequest implements Serializable
{
    private String message;

    private String sender ;

    private LocalDateTime senderAt;
}
