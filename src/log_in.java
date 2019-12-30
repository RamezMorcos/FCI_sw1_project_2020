import java.util.ArrayList;

public class log_in {
    String logged_email;
    String password;
    log_in(String email,String entered_password){
        logged_email=email;
         password=entered_password;
    }

    public user auth(ArrayList<user> n) {
        for (int i = 0; i < n.size(); i++) {
            if (n.get(i).email.equals(logged_email) && n.get(i).password.equals(password)) {
                return n.get(i);
            }
        }
        return null;
    }

}
