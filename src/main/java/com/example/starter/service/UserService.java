/**
 * If you really care for the license, look for the LICENSE.txt at the project root. Frankly, I 
 * really don't care.
 **/
package com.example.starter.service;

import com.example.starter.entity.User;

/**
 * This interface defines service routines related to user details.
 * 
 * @author Roshan Amadoru
 **/
public interface UserService {
    
    /**
     * This method returns the User entity object of the session's signed in user
     * @return User entity object of the current session's signed in user
     */
    public User getCurrentUser();
}
