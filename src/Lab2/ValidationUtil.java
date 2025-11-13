package Lab2;

public class ValidationUtil {

    public boolean patternMatches(String input, String pattern) {
        return  input.matches(pattern);
    }

    public String upperCaseAndLowerCasePattern() {
        return "[A-Za-z]+";
    }

    public String binaryNumberPattern() {
        return "[01]+";
    }

    public String saturdayOrSundayPattern() {
        return "(Saturday|Sunday)";
    }

    public String DKiTStudentNumberPattern() {
        return "(D|d)00[0-9]{6}";
    }

    public String irishNumberPattern() {
        return "(\\+353|0)8[35679][0-9]{7}";
    }

    public String mathematicalExpressionPattern() {
        return "[0-9-*/()=]+";
    }

    public String passwordPattern() {
        return "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{12}$";
    }

    public String emailPattern() {
        return "[A-Za-z0-9._%=+-]+@[A-Za-z0-9._]+.[A-Za-z]{2,}";
    }
}
