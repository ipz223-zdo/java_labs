import com.education.ztu.*;
public class Main {
    public static void main(String[] args) {
        //Task 2
        System.out.println(CredentialChecker.checkCredentials("validLogin_123", "password123", "password123")); // true
        System.out.println(CredentialChecker.checkCredentials("invalid login", "password123", "password123")); // false
        System.out.println(CredentialChecker.checkCredentials("validLogin_123", "pass", "differentPass")); // false
        System.out.println(CredentialChecker.checkCredentials("validLogin_123", "tooLongPassword_123456789", "tooLongPassword_123456789")); // false
    }
}