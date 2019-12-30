
import java.util.ArrayList;
import java.util.Scanner;

public class registration {

    ArrayList<user>users=new ArrayList<>();
    public void signup_user(user u){
        users.add(u);

    }
    public user search_for_user(int id){
        for(int i=0;i<users.size();i++){
            if(users.get(i).id==id){
                return users.get(i);
            }
        }
        return null;

    }
    public user addfriend(int id,user u){
        for(int i=0;i<users.size();i++){
            if(users.get(i).id==id){
                users.get(i).friends.add(u);
                return users.get(i);
            }
        }
        return null;

    }


  /*  public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        boolean b=s.nextBoolean();
        System.out.println(b);
    }*/

}
