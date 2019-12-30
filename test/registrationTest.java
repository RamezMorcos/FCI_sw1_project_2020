import junit.framework.TestCase;

import java.util.ArrayList;

public class registrationTest extends TestCase {
    user u1=new user("ramez","morkos","1234","1234","0122","ramea.morc",true,"eg","paypall",true);
    user u2=new user("remon","salem","1234","1234","0122","ramea.morc",true,"eg","paypall",true);
    registration r=new registration();

        registrationTest(){
            r.signup_user(u1);
            r.signup_user(u2);

        }


    public void testAddfriend() throws Exception {
assertEquals(r.search_for_user(u1.id),u1.id);
        }

}