package com.kitsune.kitsune_api.dto;

import lombok.Data;

@Data
public class HttpResponse<E> {

    private short status;

    private E responseBody;
}
