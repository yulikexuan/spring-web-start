//: webstart.domain.model.UserCredential.java


package webstart.domain.model;


import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Accessors;


@Value
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "of")
public class UserCredential {
    String username;
    String password;
}///:~