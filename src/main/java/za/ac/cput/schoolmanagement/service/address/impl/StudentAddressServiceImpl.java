package za.ac.cput.schoolmanagement.service.address.impl;


import com.intellij.openapi.components.Service;
import lombok.extern.java.Log;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.repository.address.IStudentAddressRepository;

import java.util.Optional;

@Log
@Service
public class StudentAddressServiceImpl implements IStudentAddressService{

    private final IStudentAddressRepository repository;

    public StudentAddressServiceImpl(IStudentAddressRepository repo)
    {
        this.repository = repo;
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress) throws IllegalArgumentException
    {
        return repository.save(studentAddress);
    }

    @Override
    public Optional<StudentAddress> read(String studentId)
    {
        return repository.findById(studentId);
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public List<StudentAddress> findAll()
    {
        return repository.findAll();
    }

    @Override
    public void deleteById(String studentId)
    {
        Optional<StudentAddress> studentAddress = read(studentId);
        studentAddress.ifPresent(this::delete);
    }

    @Override
    public void delete(StudentAddress object)
    {
        repository.delete(object);
    }

}
