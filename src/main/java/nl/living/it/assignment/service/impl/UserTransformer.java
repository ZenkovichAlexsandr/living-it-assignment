package nl.living.it.assignment.service.impl;

import nl.living.it.assignment.dto.UserDto;
import nl.living.it.assignment.model.User;
import nl.living.it.assignment.service.transformers.ToDtoTransformer;
import org.springframework.stereotype.Component;

/**
 * @author a.zenkovich
 * @since 27.03.18.
 */
@Component
public class UserTransformer implements ToDtoTransformer<UserDto, User> {
    @Override
    public UserDto transform(final User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .fullName(entity.getFirstName() + " " + entity.getLastName())
                .build();
    }
}
