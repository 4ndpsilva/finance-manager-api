package aps.financemanagerapi.infrastructure.exception.dto;

import aps.financemanagerapi.infrastructure.util.ConstantUtil;
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

    @JsonFormat(pattern = ConstantUtil.DATE_PATTERN +" " +ConstantUtil.TIME_PATTERN+":ss")
    private LocalDateTime timestamp;

    private List<ErrorDetailDTO> errorDetails;
}