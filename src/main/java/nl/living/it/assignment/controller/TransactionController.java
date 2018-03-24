package nl.living.it.assignment.controller;

import lombok.RequiredArgsConstructor;
import nl.living.it.assignment.dto.TransactionDto;
import nl.living.it.assignment.dto.TransactionListDto;
import nl.living.it.assignment.exception.BusinessException;
import nl.living.it.assignment.exception.EntityNotFoundException;
import nl.living.it.assignment.model.TransactionStatus;
import nl.living.it.assignment.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author a.zenkovich
 * @since 24.03.18.
 */
@RestController
@RequestMapping(value = "/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;

    @GetMapping
    public List<TransactionListDto> findByStatus(@RequestParam final TransactionStatus status) {
        return service.findByStatus(status);
    }

    @PostMapping
    public TransactionListDto create(@RequestBody final TransactionDto transaction) throws BusinessException {
        return service.create(transaction);
    }

    @PostMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void manage(@PathVariable final Long id, @RequestParam final TransactionStatus status)
            throws EntityNotFoundException {
        service.manage(id, status);
    }
}
