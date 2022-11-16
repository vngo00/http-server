package org.learner.dao;

import org.learner.dto.UserDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* singleton design pattern */
public class UserDao implements BaseDao<UserDto> {

    private Map<String, UserDto> data = new HashMap<>();

    private static UserDao userDao = new UserDao();

    private UserDao() {

    }


    public static UserDao getInstance() {
        return userDao;
    }


    @Override
    public void put(UserDto messageDto) {
        data.put(messageDto.getUniqueId(), messageDto);
    }


    @Override
    public UserDto get(String uniqueId) {

        return data.get(uniqueId);
    }


    @Override
    public List<UserDto> getAll() {
        return new ArrayList<>(data.values());
    }
}
