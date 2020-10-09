package com.satyadara.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class WebSocketController {

  @MessageMapping("/chat/{userId}")
  @SendTo("/topic/messages/{userId}")
  public OutputMessage send(@DestinationVariable String userId, final Message message) {
    log.info(userId);
    return new OutputMessage(message.getFrom(), message.getText());
  }
}
