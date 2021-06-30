package com.anieves.market.persistence;

import com.anieves.market.domain.Purchase;
import com.anieves.market.domain.repository.PurchaseRepository;
import com.anieves.market.persistence.crud.CompraCrudRepository;
import com.anieves.market.persistence.entity.Compra;
import com.anieves.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    //inyectamos la interfaz CompraCrudRepository
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    //inyectamos tambien el Mapper, ya que repositorio debe hablar en terminos del dominio
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    /*
        El .map() nos sirve para operar con lo que venga dentro del optional,
        si no hay nada dentro del optional no se ejecuta
     */
    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
       //Recibe un Purchase lo convertimos a Compra
        Compra compra = mapper.toCompra(purchase);
        //Garantizamos de que toda la informacion se guarde en cascada
        compra.getProductos().forEach(comprasProducto -> comprasProducto.setCompra(compra));

        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
