package za.ac.cput.schoolmanagement.factory;


import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.util.helper;


public class StudentAddressFactory {
    public static StudentAddress createAddress(String studentId, Address address){
        return new StudentAddress.Builder().setStudentId(studentId).setAddress(address).build();
    }
}
