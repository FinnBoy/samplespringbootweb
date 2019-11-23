package org.finn.demo.service;

import org.finn.demo.domain.primary.Role;
import org.finn.demo.domain.secondary.RoleReadonly;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
public interface UserService {

    void saveUser(String name, String email);

    void saveRole(String name);

    Role obtainRole(Long id);

    RoleReadonly getRole(Long id);
}
