package za.ac.cput.schoolmanagement.service.address.impl;

import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.service.IService;

public interface IStudentAddressService extends IService<StudentAddress, String> {
    void deleteById(String employeeId);
}
