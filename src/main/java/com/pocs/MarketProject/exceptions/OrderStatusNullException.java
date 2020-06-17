package com.pocs.MarketProject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "É preciso informar o status do pedido")
public class OrderStatusNullException extends RuntimeException {
}
