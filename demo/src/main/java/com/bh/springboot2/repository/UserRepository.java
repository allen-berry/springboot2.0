package com.bh.springboot2.repository;

import com.bh.springboot2.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {

    private final ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户
     * @param user
     * @return
     */
    public boolean save(User user){
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id,user) == null;
    }

    /**
     * 查询所有用户
     * @return
     */
    public Collection<User> findAll() {
        List<User> list = new ArrayList();
        User user = new User();
        user.setId(idGenerator.incrementAndGet());
        user.setName("点点点");
        list.add(user);

        User user2 = new User();
        user2.setId(idGenerator.incrementAndGet());
        user2.setName("yyy");
        list.add(user2);

        return list;
    }
}
