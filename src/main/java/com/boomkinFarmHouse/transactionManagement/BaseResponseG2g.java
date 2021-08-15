package com.boomkinFarmHouse.transactionManagement;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BaseResponseG2g<T> {

    private Integer code;

    private T payload;
}
