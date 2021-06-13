package ejb.kolokwium;

import javax.ejb.Remote;

@Remote
public interface IBeanInterface {
    String someMethodWhichMustBeImplemented();
    String anotherButWithParam();
}
