package ru.ksanxxx.abitur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ksanxxx.abitur.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
