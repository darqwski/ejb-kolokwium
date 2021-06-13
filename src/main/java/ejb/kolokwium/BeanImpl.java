package ejb.kolokwium;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

@Stateful
public class BeanImpl implements IBeanInterface{
    private int counter = 0;
    @Override
    public String someMethodWhichMustBeImplemented() {
        return "Some string";
    }

    @Override
    public String anotherButWithParam() {


        counter++;
        return ""+counter;
    }
}
