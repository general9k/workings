package ru.ksanxxx.abitur.service.facade;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ksanxxx.abitur.model.Address;
import ru.ksanxxx.abitur.service.AddressService;

@Service
@Slf4j
@AllArgsConstructor
public class AddressFacade {

    private final AddressService addressService;

    public Address saveAddress(Address address) {
        return addressService.save(address);
    }
}
