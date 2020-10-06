package com.satyadara.websocket;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

  @MessageMapping("/chat/{userId}")
  @SendTo("/topic/messages/{userId}")
  public OutputMessage send(@DestinationVariable String userId, final Message message) {
    System.out.println(userId);
    return new OutputMessage(message.getFrom(), message.getText());
  }
}
