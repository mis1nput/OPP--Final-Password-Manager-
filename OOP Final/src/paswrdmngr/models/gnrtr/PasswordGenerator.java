package paswrdmngr.models.gnrtr;

public final class PasswordGenerator {

    private final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    private final String numbers = "0123456789";
    private final String specialChar = "!@#$%^&*";

    public String generator(){

        StringBuilder password = new StringBuilder();
        String combinedChars = upperCase + lowerCase + specialChar + numbers;
        int length = 12;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * combinedChars.length());
            password.append(combinedChars.charAt(index));
        }

        return password.toString();

    }

    @Override
    public String toString() {
        return super.toString();
    }

    
    
}
