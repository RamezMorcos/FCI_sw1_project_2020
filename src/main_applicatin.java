import java.util.ArrayList;
import java.util.Scanner;
public class main_applicatin {
    Scanner s=new Scanner(System.in);
    user u;
    registration reg=new registration();
    log_in l;
    ArrayList<friend_request> f=new ArrayList<>();;
 public user login(){
     int x=0;
     while (x<3){
         System.out.println("please enter your email  and password");
         String email=s.next();
         String password=s.next();
         l=new log_in(email,password);
         user b=l.auth(reg.users);
         if(b!=null){System.out.println("User Logged in successfully  ");return b;}
            System.out.println("email or password is not correct try again ");
                 x++;
     }
     return null;
 }
 public void sign_up(){
     u=new user();
     System.out.println("Enter your first name");
     u.firstname=s.next();
     System.out.println("Enter your last  name");
     u.lastname=s.next();
     System.out.println("Enter your email");
     u.email=s.next();
     while (true) {
         System.out.println("Enter your password");
         u.password = s.next();
         System.out.println("confirm password ");
         u.confirm_password = s.next();
         if(u.password.equals(u.confirm_password)){
             break;
         }
         System.out.println(" password and its confirm are not matched please try again");

     }
     System.out.println("Enter your telephone number");
     u.telephone_number = s.next();
     System.out.println("Enter your country");
     u.country = s.next();
     System.out.println("Enter your date_birth");
     u.date = s.next();
     while (true) {
         System.out.println("press true if Male or false for Female)");
         u.gender = s.nextBoolean();

         if(u.gender==true|u.gender==false){
             break;
         }
     System.out.println("There is something wrong try again");
     }
     while (true) {
         System.out.println("if u want to be a premier user press 1 if u want to be a normal user press 0");
     int x=s.nextInt();
     if(x==1){
         u.prem_or_normal=true;
         System.out.println("tell us about payment method ex paypal ...etc");
        u.payment_method=s.next();
        break ;
     }
     else if(x==0){
     u.prem_or_normal=false;
     break;
     }
     else{System.out.println("There is something wrong please try again");}

 }
 reg.signup_user(u);

 }
public void show_options(){
     System.out.println("press 1 to show your friends ");
    System.out.println("press 2 to search for  friends ");
    System.out.println("press 3 to send friend request friend ");
    System.out.println("press 4 to show your  friends requests ");
    System.out.println("press 5 to show accept or reject a friend request ");

    System.out.println("press 6 to be converted as a premier user to make use of new features ");
    System.out.println("press 7 to log out  ");
    System.out.println("press 8 to Exit  ");
}
public void to_be_prem_user(user u) {
    u.prem_or_normal=true;
    System.out.println("tell us about payment method ex paypal ...etc");
    u.payment_method=s.next();
}
public void show_your_friends(user u){
    if(u.friends.size()==0){System.out.println("there is no friends yet");return ;}
    for (int i=0;i<u.friends.size();i++){
        System.out.println(i+1+" )" +u.friends.get(i).firstname+" " +u.friends.get(i).lastname);
    }
}

public boolean search_for_friend_byname(String name){
    ArrayList<user>u=new ArrayList<>();
    for (int i=0;i<reg.users.size();i++){
        if(reg.users.get(i).firstname.equals(name)|reg.users.get(i).lastname.equals(name)|(reg.users.get(i).firstname+reg.users.get(i).lastname).equals(name)){
            u.add(reg.users.get(i));
        }}
        if(u.size()==0){System.out.println("There is  no one with this name ");return false;}
        else{
            for(int i=0 ;i<u.size();i++){
                System.out.println(" "+(i+1)+")"+u.get(i).firstname+" "+u.get(i).lastname);
            }
        }
        return true;
    }
public void add_friend(ArrayList<friend_request>fr,user sender){
    System.out.println("enter the names of friends u want to send request to ");
    String x=s.next();
    boolean check=search_for_friend_byname(x);
    if(check==false){System.out.println(" try again");return;}
    System.out.println("Enter the number of user u want to send ");
    int i=s.nextInt();
    user u=reg.users.get(i-1);
    friend_request f=new friend_request();
    f.sender=sender;
    f.reciever=u;
    fr.add(f);
}
public boolean view_friends_request(ArrayList<friend_request>fr,user u){
    int count =0;
    for(int i=0;i<fr.size();i++){
        if(fr.get(i).reciever.id==u.id){
            System.out.println((i+1)+" ) " +fr.get(i).sender.firstname+" "+fr.get(i).sender.lastname);
            count++;
        }
    }
    if(count==0){System.out.println("there is no friend requests to you ");return false;}
    return true;
}
public void accept_friend_request(ArrayList<friend_request>fr,user u){
    boolean b=view_friends_request(fr,u);
    if(b==false){;return;}
    System.out.println("Enter the number of request u want to accept or reject");
    int x=s.nextInt();
    System.out.println(fr.get(x-1).sender.firstname+" "+fr.get(x-1).sender.lastname);
    System.out.println("press 1 to accept him as a friend or 0 to reject him");
    int y=s.nextInt();
    if(y==1){
        user us=reg.addfriend(u.id,fr.get(x-1).sender);
       user sender= reg.addfriend(fr.get(x-1).sender.id,u);
       fr.remove(x-1);
    }
    else if(y==0){
        fr.remove(x-1);
    }
    else {
        System.out.println("There is something wrong please try again");
    }

}


    public static void main(String[] args) {

        main_applicatin main=new main_applicatin();
        while(true) {
            int choice;
            System.out.println("Welcome to Rbook social media press 1 to log in or 2  to sign up");
            int x = main.s.nextInt();
            user logged_user;
            while (true) {
                if (x == 1) {
                    user s=main.login();
                    if (s != null) {
                        logged_user = s;
                        break;
                    }
                    System.out.println("you will be turned into signn up to create an account");
                }
                    main.sign_up();
                    System.out.println("account is successfully created ... log in into system");
                    user s=main.login();
                    if (s != null) {
                        logged_user = s;
                        break;

                }
            }

            while (true) {

                main.show_options();
                 choice=main.s.nextInt();
                if(choice==1){
                   main.show_your_friends(logged_user);
                }
                if(choice==2){
                    System.out.println("please enter the name u want");
                    String name=main.s.next();
                    main.search_for_friend_byname(name);
                }
                if(choice==3){
                    main.add_friend( main.f,logged_user);
                }
                if(choice==4){
                    main.view_friends_request(main.f,logged_user);
                }
                if(choice==5){
                    main.accept_friend_request(main.f,logged_user);
                }
                if(choice==6){
                    main.to_be_prem_user(logged_user);
                }
                if(choice==7){
                        break;
                }
                if(choice==8){
                    break;

                }

            }
            if(choice==8){
                break;
            }
        }
 }
}
