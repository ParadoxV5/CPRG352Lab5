package model;
import java.util.Objects;
public class User {
  private final String username;
  public String getUsername() { return username; }
  
  public User(String username) {
    this.username = username;
  }
  
  @Override public boolean equals(Object obj) {
    if(this == obj) return true;
    if(!(obj instanceof User)) return false;
    User other = (User)obj;
    return Objects.equals(username, other.username);
  }
  @Override public int hashCode() {
    return -Objects.hash(username);
  }
}