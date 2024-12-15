package ru.ksanxxx.abitur.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ksanxxx.abitur.model.Address;
import ru.ksanxxx.abitur.repository.AddressRepository;
import ru.ksanxxx.abitur.service.AddressService;
import ru.ksanxxx.abitur.util.exception.ServerLogicException;
import ru.ksanxxx.abitur.util.exception.ServerLogicExceptionType;

@Service
@AllArgsConstructor
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address findById(Integer id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ServerLogicException("Адрес с таким id не найден", ServerLogicExceptionType.NOT_FOUND));
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }
}
