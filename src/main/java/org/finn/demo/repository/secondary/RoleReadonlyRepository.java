package org.finn.demo.repository.secondary;

import org.finn.demo.domain.secondary.RoleReadonly;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Finn Zhao
 * @version 2019-11-15
 */
public interface RoleReadonlyRepository extends CrudRepository<RoleReadonly, Long> {
}
