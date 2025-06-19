package com.example.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {
    private ResponseStatusTypeEnum status;
    private String message;
    private Object data;

    public ResponseModel(ResponseStatusTypeEnum status, String message) {
        this.status = status;
        this.message = message;
    }

    public enum ResponseStatusTypeEnum {
        SUCCESS("SUCCESS"),
        FAILURE("FAILURE");

        private final String code;

        ResponseStatusTypeEnum(String code) {
            this.code = code;
        }

        @JsonValue
        public String getCode() {
            return code;
        }

        @JsonCreator
        public static ResponseStatusTypeEnum fromCode(String code) {
            for (ResponseStatusTypeEnum type : values()) {
                if (type.code.equals(code)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Invalid response type code: " + code);
        }
    }
}