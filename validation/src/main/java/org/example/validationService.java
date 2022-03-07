package org.example;

public interface validationService {

     boolean emailIdValidate(final String emailId);

     boolean userNameValidate(final String userName);

     boolean passwordValidate(final String password);

     boolean mobileNumberValidate(final String mobileNumber);
}


