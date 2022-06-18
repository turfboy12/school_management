package za.ac.cput.schoolmanagement.domain;

public class StudentAddress {
    private String studentId;
    private Address address;

    public StudentAddress(StudentAddress.Builder builder){
        this.studentId = builder.studentId;
        this.address = builder.address;
    }

    public String getStudentId(){
        return studentId;
    }

    public void setStudentId(String studentId){
        this.studentId = studentId;
    }

    public Address getAddress(){
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "studentId='" + studentId + '\'' +
                ", address=" + address +
                '}';
    }

    public static class Builder{
        private String studentId;
        private Address address;

        public StudentAddress.Builder setStudentId(String studentId){
            this.studentId = studentId;
            return this;
        }

        public StudentAddress.Builder setAddress(Address address){
            this.address = address;
            return this;
        }

        public StudentAddress build(){
            return new StudentAddress(this);
        }
    }
}


