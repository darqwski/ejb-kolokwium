package ejb.kolokwium;

import javax.ejb.Remote;
import javax.servlet.http.HttpSession;

@Remote
public interface IBeanInterface {
    String someMethodWhichMustBeImplemented();
    String anotherButWithParam(HttpSession session);
}
