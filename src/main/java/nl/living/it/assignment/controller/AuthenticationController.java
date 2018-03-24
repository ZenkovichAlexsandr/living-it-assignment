package nl.living.it.assignment.controller;

import lombok.RequiredArgsConstructor;
import nl.living.it.assignment.dto.LoginRequestDto;
import nl.living.it.assignment.dto.LoginResponseDto;
import nl.living.it.assignment.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.OK)
    public LoginResponseDto login(@RequestBody final LoginRequestDto loginRequestDto) {
        return authenticationService.login(loginRequestDto);
    }
}
