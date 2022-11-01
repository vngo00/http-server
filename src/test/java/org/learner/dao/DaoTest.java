package org.learner.dao;

import org.learner.dto.MessageDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

public class DaoTest {
    public void testDao(){
        MessageDao messageDao = MessageDao.getInstance();
        Assert.assertEquals(messageDao, MessageDao.getInstance());

        List<Constructor> constructors = Arrays.asList(MessageDao.class.getConstructors());
        Assert.assertEquals(constructors.size(), 0);
        constructors = Arrays.asList(MessageDao.class.getDeclaredConstructors());
        Assert.assertEquals(constructors.size(), 1);
        Assert.assertTrue(Modifier.isPrivate(constructors.get(0).getModifiers()));
    }

    @Test
    public void testStore(){
        MessageDao messageDao = MessageDao.getInstance();
        String id = String.valueOf(Math.random());
        MessageDto messageDto = new MessageDto(id);
        messageDao.put(messageDto);
        Assert.assertEquals(messageDao.get(id), messageDto);
    }
}
