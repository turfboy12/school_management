package za.ac.cput.schoolmanagement.controller.studentController;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.schoolmanagement.domain.StudentAddress;
import za.ac.cput.schoolmanagement.factory.StudentAddressFactory;
import za.ac.cput.schoolmanagement.service.address.impl.IStudentAddressService;

@Slf4j
@RestController
@RequestMapping("school-management/student-address/")

public class StudentAddressController {
    private final IStudentAddressService service;

    @Autowired
    public StudentAddressController(IStudentAddressService service)
    {
        this.service = service;
    }

    @PostMapping("save")
    public ResponseEntity<StudentAddress> save(@RequestBody StudentAddress studentAddress)
    {
        StudentAddress studentAddressAlt = null;
        try
        {
            studentAddressAlt = service.save(StudentAddressFactory.build(
                    studentAddress.getStudentId(),
                    studentAddress.getAddress()
            ));
        }catch(IllegalArgumentException exception)
        {
            Log log;
            log.info("StudentAddress Save : {}", exception);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(studentAddressAlt);
    }

    @GetMapping("read/{id}")
    public ResponseEntity<StudentAddress> read(@PathVariable String id)
    {
        StudentAddress studentAddress = service.read(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(studentAddress);
    }

    @GetMapping("find-all")
    public ResponseEntity<List<StudentAddress>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(@RequestBody StudentAddress object)
    {
        service.delete(object);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete-by-id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id)
    {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

