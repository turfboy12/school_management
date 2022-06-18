package za.ac.cput.schoolmanagement.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.schoolmanagement.domain.StudentAddress;

public interface IStudentAddressRepository {

    @Repository
    abstract static
    class IStudentAddressRepository implements JpaRepository<StudentAddress, String> {
    }
}
