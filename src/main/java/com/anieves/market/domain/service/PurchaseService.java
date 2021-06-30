package com.anieves.market.domain.service;

import com.anieves.market.domain.Purchase;
import com.anieves.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    //mostrar todas las compras
    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    //lista de compras realizadas por un cliente en particular
     public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId);
     }

    //metodo para guardar una compra
    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
}
