package org.learner.dao;

import org.learner.dto.MessageDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDao implements BaseDao<MessageDto> {

    private Map<String, MessageDto> data = new HashMap<>();

    private static MessageDao messageDAO = new MessageDao();


    private MessageDao (){};
    public static MessageDao getInstance() {
        return messageDAO;
    }


    @Override
    public void put(MessageDto messageDto) {
        data.put(messageDto.getFromId(), messageDto);
    }


    @Override
    public MessageDto get(String uniqueId) {

        return data.get(uniqueId);
    }


    @Override
    public List<MessageDto> getAll() {
        return new ArrayList<>(data.values());
    }
}
