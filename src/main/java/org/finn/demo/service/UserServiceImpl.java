package org.finn.demo.service;

import org.finn.demo.configuration.PrimaryDataSourceConfiguration;
import org.finn.demo.configuration.SecondaryDataSourceConfiguration;
import org.finn.demo.domain.primary.Role;
import org.finn.demo.domain.primary.User;
import org.finn.demo.domain.secondary.RoleReadonly;
import org.finn.demo.repository.primary.RoleRepository;
import org.finn.demo.repository.primary.UserRepository;
import org.finn.demo.repository.secondary.RoleReadonlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleReadonlyRepository roleReadonlyRepository;

    @Transactional(value = PrimaryDataSourceConfiguration.TRANSACTION_MANAGER)
    public void saveUser(String name, String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
    }

    @Transactional(value = PrimaryDataSourceConfiguration.TRANSACTION_MANAGER)
    public void saveRole(String name) {
        Role role = new Role();
        role.setName(name);
        roleRepository.save(role);
    }

    @Transactional(value = PrimaryDataSourceConfiguration.TRANSACTION_MANAGER)
    public Role obtainRole(Long id) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        return optionalRole.get();
    }

    @Transactional(value = SecondaryDataSourceConfiguration.TRANSACTION_MANAGER, readOnly = true)
    public RoleReadonly getRole(Long id) {
        Optional<RoleReadonly> optionalRole = roleReadonlyRepository.findById(id);
        return optionalRole.get();
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void setRoleReadonlyRepository(RoleReadonlyRepository roleReadonlyRepository) {
        this.roleReadonlyRepository = roleReadonlyRepository;
    }

}
