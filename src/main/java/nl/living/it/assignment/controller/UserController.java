package nl.living.it.assignment.controller;

import lombok.RequiredArgsConstructor;
import nl.living.it.assignment.dto.UserListDto;
import nl.living.it.assignment.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public List<UserListDto> lookup() {
        return service.lookup();
    }
}
