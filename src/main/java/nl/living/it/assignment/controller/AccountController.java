package nl.living.it.assignment.controller;

import lombok.RequiredArgsConstructor;
import nl.living.it.assignment.dto.AccountDetailsDto;
import nl.living.it.assignment.dto.AccountDto;
import nl.living.it.assignment.dto.AccountListDto;
import nl.living.it.assignment.exception.BusinessException;
import nl.living.it.assignment.service.AccountService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@RestController
@RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AccountController {
    private final AccountService service;

    @GetMapping
    public List<AccountListDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AccountDetailsDto findOne(@PathVariable final Long id) {
        return service.findOne(id);
    }

    @PostMapping
    public AccountDto create(@RequestBody final AccountDto account) throws BusinessException {
        return service.create(account);
    }
}
