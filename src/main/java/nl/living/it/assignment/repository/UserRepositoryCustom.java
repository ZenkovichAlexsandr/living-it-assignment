package nl.living.it.assignment.repository;

import nl.living.it.assignment.dto.UserListDto;

import java.util.List;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
public interface UserRepositoryCustom {
    List<UserListDto> lookup();
}
