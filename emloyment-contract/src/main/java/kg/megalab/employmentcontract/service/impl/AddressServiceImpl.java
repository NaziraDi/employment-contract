package kg.megalab.employmentcontract.service.impl;

import kg.megalab.employmentcontract.mapper.AddressMapper;
import kg.megalab.employmentcontract.model.dto.AddressDto;
import kg.megalab.employmentcontract.model.entity.Address;
import kg.megalab.employmentcontract.model.request.CreateAddressRequest;
import kg.megalab.employmentcontract.repository.AddressRepository;
import kg.megalab.employmentcontract.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

//    @Override
//    public AddressDto create(CreateAddressRequest request) {
//
//        Address address = Address
//                .builder()
//                .country(request.getCountry())
//                .city(request.getCity())
//                .street(request.getStreet())
//                .house(request.getHouse())
//                .apartment(request.getApartment())
//                .postcode(request.getPostcode())
//                .build();
//        AddressDto addressDto = AddressMapper.INSTANSE.toDto(address);
//        addressRepository.save(address);
//
//        return addressDto;
//    }

    @Override
    public AddressDto findById(Long id) {
        return AddressMapper.INSTANCE
                .toDto(addressRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Address is not found")));
    }

    @Override
    public AddressDto update(AddressDto addressDto) {
        Address address = addressRepository
                .findById(addressDto.getId()).map(address1 -> {
                    address1.setCountry(addressDto.getCountry());
                    address1.setCity(addressDto.getCity());
                    address1.setStreet(addressDto.getStreet());
                    address1.setHouse(addressDto.getHouse());
                    address1.setApartment(addressDto.getApartment());
                    address1.setPostcode(addressDto.getPostcode());
                    return addressRepository.save(address1);

        }).orElseThrow(() -> new RuntimeException("Not found"));

        return AddressMapper.INSTANCE.toDto(address);
    }

    @Override
    public void save(Address address) {
        addressRepository.save(address);
    }

//    @Override
//    public AddressDto delete(Long id) {
//        Address address = addressRepository
//                .findById(id)
//                .map(address1 -> {
//                    address1.setIsActive(false);
//                    return addressRepository.save(address1);
//                }).orElseThrow(() -> new RuntimeException("Address is not found or already deleted"));
//        return AddressMapper.INSTANCE.toDto(address);
//    }

}
