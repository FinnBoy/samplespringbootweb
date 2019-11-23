package org.finn.demo.repository.primary;

import org.finn.demo.domain.primary.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
