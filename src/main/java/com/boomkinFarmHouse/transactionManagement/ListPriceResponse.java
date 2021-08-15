package com.boomkinFarmHouse.transactionManagement;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ListPriceResponse {

    List<PricesResponse> results;
}
