import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class user {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id=count.incrementAndGet();
    String firstname;
    String lastname;
    String password;
    String confirm_password;
    String telephone_number;
    String email ;
    boolean gender;
    String country ;
    String date;
    boolean prem_or_normal;
    String payment_method;
    ArrayList<user>friends=new ArrayList<>();
    ArrayList<user>friend_requets=new ArrayList<>();
    user(){}
    user(String first_name,String last_name,String pass,String confirm_pass,String tel_num,String em,boolean gen,String coun,String paym,boolean p_n){
        firstname=first_name;
        lastname=last_name;
        password=pass;
        confirm_password=confirm_pass;
        telephone_number=tel_num;
        email=em;
        gender=gen;
        country=coun;
        prem_or_normal=p_n;
        payment_method=paym;

    }




}
