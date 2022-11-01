package org.learner.handler;


import org.learner.dao.MessageDao;
import org.learner.dto.MessageDto;
import org.learner.server.Server;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

public class CreateMessageHandlerTest {

  @Test
  public void createMessageTest(){
    MessageDto messageDto = new MessageDto();
    messageDto.setMessage(String.valueOf(Math.random()));
    messageDto.setFromId(String.valueOf(Math.random()));
    messageDto.setToId(String.valueOf(Math.random()));

    String test1 = "POST /createMessage HTTP/1.1\n"
        + "Host: test\n"
        + "Connection: Keep-Alive\r\n"
        + "\r\n"
        + GsonTool.gson.toJson(messageDto);
    String response = Server.processRequest(test1);
    String[] responseParts = response.split("\n");
    Assert.assertEquals(responseParts[0], "HTTP/1.1 200 OK");
    List<MessageDto> messageDtos = MessageDao.getInstance().getAll();
    Assert.assertEquals(messageDtos.size(), 1);
    Assert.assertNotNull(messageDtos.get(0).getUniqueId());
    Assert.assertEquals(messageDtos.get(0).getMessage(), messageDto.getMessage());
  }
}
