package org.learner.dao;

import org.learner.dto.MessageDto;

import java.util.ArrayList;
import java.util.List;

public class MessageDao implements BaseDao<MessageDto> {

    private List<MessageDto> messageDtoList = new ArrayList<>();

    private static MessageDao messageDAO = new MessageDao();


    private MessageDao (){};
    public static MessageDao getInstance() {
        return messageDAO;
    }

    // TODO fill this out
    @Override
    public void put(MessageDto messageDto) {
        messageDtoList.add(messageDto);
    }

    // TODO fill this out
    @Override
    public MessageDto get(String uniqueId) {

        // iterate over the loop to find the messageDto with the uniqueId
        for (MessageDto temp : messageDtoList){
            if (temp.getUniqueId().compareTo(uniqueId) == 0){
                return temp;
            }
        }
        return null;
    }

    // TODO fill this out
    @Override
    public List<MessageDto> getAll() {
        return messageDtoList;
    }
}
