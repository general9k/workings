package ru.ksanxxx.abitur.service;

import ru.ksanxxx.abitur.model.Address;

public interface AddressService {

    Address findById(Integer id);

    Address save(Address address);
}
