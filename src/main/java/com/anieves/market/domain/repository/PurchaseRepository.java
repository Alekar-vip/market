package com.anieves.market.domain.repository;

import com.anieves.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    //recupere todas las compras dentro del super mercado
    List<Purchase> getAll();

    //lista de compras realizadas por un cliente en particular
    Optional<List<Purchase>> getByClient(String clientId);

    //metodo para guardar una compra
    Purchase save(Purchase purchase);
}
