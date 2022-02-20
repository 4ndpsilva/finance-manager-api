package aps.financemanagerapi.infrastructure.exception;

import aps.financemanagerapi.infrastructure.exception.dto.ErrorDetailDTO;
import aps.financemanagerapi.infrastructure.exception.dto.ErrorResponseDTO;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public record ResponseMessageCreator(MessageSource messageSource){

    public ResponseEntity<List<ErrorResponseDTO>> error(final String codeMessage, final HttpStatus httpStatus) {
        final List<ErrorResponseDTO> errors = List.of(buildErrorResponse(codeMessage, httpStatus));
        return ResponseEntity.status(httpStatus).body(errors);
    }

    public List<ErrorResponseDTO> getErrors(final BindingResult bindingResult) {
        final List<ErrorDetailDTO> errors = new ArrayList<>();
        bindingResult.getFieldErrors().forEach(f -> errors.add(new ErrorDetailDTO(f.getField(), f.getDefaultMessage())));

        final ErrorResponseDTO error = buildErrorResponse("API-011", HttpStatus.BAD_REQUEST);
        error.setErrorDetails(errors);

        return List.of(error);
    }

    private ErrorResponseDTO buildErrorResponse(final String codeMessage, final HttpStatus httpStatus) {
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setCode(codeMessage);
        error.setMessage(messageSource.getMessage(codeMessage, null, LocaleContextHolder.getLocale()));
        error.setStatusCode(httpStatus.value());
        error.setTimestamp(LocalDateTime.now());
        return error;
    }
}