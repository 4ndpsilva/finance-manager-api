
package aps.financemanagerapi.domain.account.controller;

import aps.financemanagerapi.core.mapper.GenericMapper;
import aps.financemanagerapi.core.service.AbstractCrudService;
import aps.financemanagerapi.domain.account.dto.AccountDTO;
import aps.financemanagerapi.domain.account.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController{
    private final AbstractCrudService<Account, Long> service;
    private final GenericMapper<Account, AccountDTO> mapper;

    @PostMapping
    public ResponseEntity<AccountDTO> save(@RequestBody @Valid final AccountDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(service.save(mapper.toEntity(dto))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> update(@PathVariable final Long id, @RequestBody @Valid final AccountDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(service.update(id, mapper.toEntity(dto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> findById(@PathVariable final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toDTO(service.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> list(@RequestParam final Map<String, Object> params) {
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toListDTO(service.find(params)));
    }
}