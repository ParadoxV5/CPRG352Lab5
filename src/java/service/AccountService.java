package service;
import model.User;
public class AccountService implements java.io.Serializable {
  private static final long serialVersionUID = 1;
  private java.util.HashSet<String> users = new java.util.HashSet<String>() {
    private static final long serialVersionUID = AccountService.serialVersionUID;
    {
      add("adam");
      add("betty");
    }
  };
  private transient String password = "password";
  
  /** Dummy project, IKR… */
  @SuppressWarnings("javadoc") public User login(String username, String password) {
    if(users.contains(username) && java.util.Objects.equals(this.password, password))
      return new User(username);
    return null;
  }
}