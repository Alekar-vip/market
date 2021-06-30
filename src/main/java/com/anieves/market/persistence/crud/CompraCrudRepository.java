package com.anieves.market.persistence.crud;

import com.anieves.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//CrudRepository recibe como parametro el Entity que es compra y su PK
public interface CompraCrudRepository  extends CrudRepository<Compra, Integer> {

    Optional<List<Compra>> findByIdCliente(String idCliente);

}
