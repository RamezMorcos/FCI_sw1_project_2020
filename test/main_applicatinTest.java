import junit.framework.TestCase;

public class main_applicatinTest extends TestCase {
main_applicatin m=new main_applicatin();
main_applicatinTest(){
    user u1=new user("ramez","morkos","1234","1234","0122","ramea.morc",true,"eg","paypall",true);
    user u2=new user("remon","salem","1234","1234","0122","ramea.morc",true,"eg","paypall",true);
    m.reg.signup_user(u1);
    m.reg.signup_user(u2);

}

    public void testAdd_friend() throws Exception {
    m.add_friend(m.f,m.reg.users.get(0));
    assertEquals(m.view_friends_request(m.f,m.reg.users.get(1)),true);

    }

}