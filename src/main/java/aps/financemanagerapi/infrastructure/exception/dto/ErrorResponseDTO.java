package aps.financemanagerapi.infrastructure.exception.dto;

import aps.financemanagerapi.infrastructure.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErrorResponseDTO {
    private String code;
    private String message;
    private Integer statusCode;

    @JsonFormat(pattern = DateUtil.DATE_PATTERN +" " +DateUtil.TIME_PATTERN)
    private LocalDateTime timestamp;

    private List<ErrorDetailDTO> errorDetails;
}