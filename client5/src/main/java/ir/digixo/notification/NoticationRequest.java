package ir.digixo.notification;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class NoticationRequest
{
    private String message;

    private String sender ;

    private LocalDateTime senderAt;
}
