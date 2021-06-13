package ejb.kolokwium;

import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

@Stateless
public class BeanImpl implements IBeanInterface{
    @Override
    public String someMethodWhichMustBeImplemented() {
        return "Some string";
    }

    @Override
    public String anotherButWithParam(HttpSession session) {
        Integer counter = (Integer) session.getAttribute("counter");
        if(counter == null){
            counter = 0;
        }

        counter++;
        session.setAttribute("counter", counter);
        return ""+counter;
    }
}
