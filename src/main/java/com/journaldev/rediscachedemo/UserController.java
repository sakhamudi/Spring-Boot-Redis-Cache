package com.journaldev.rediscachedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Cacheable(value = "users", key = "#userId" )
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@PathVariable Long userId) {
        LOG.info("Getting user with ID {}.", userId);
         User user = userRepository.findOne(1L);
         LOG.info("User ::"+user);  
         return user;
    }

    @CachePut(value = "users", key = "#user.id")
    @PutMapping("/update")
    public User updatePersonByID(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @CacheEvict(value = "users", allEntries=true)
    @DeleteMapping("/{userId}")
    public void deleteUserByID(@PathVariable Long userId) {
        LOG.info("deleting person with id {}", userId);
        userRepository.delete(userId);
    }
}
