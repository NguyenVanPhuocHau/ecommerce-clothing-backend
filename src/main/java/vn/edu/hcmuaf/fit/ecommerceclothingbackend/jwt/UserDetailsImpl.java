package vn.edu.hcmuaf.fit.ecommerceclothingbackend.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vn.edu.hcmuaf.fit.ecommerceclothingbackend.entitys.*;

import java.util.*;
import java.util.stream.Collectors;

public class UserDetailsImpl  implements UserDetails {
    private static final long serialVersionUID = 1L;

    private final  int id;
    private final String username;
    private final String password;

    private final  String email;
    private final Collection<? extends GrantedAuthority> authorities;
    private final List<UserAddress> userAddress;
    private final List<UserOrder> userOrder;
    private final UserInformation information;
    private final String status;

    public UserDetailsImpl(int id, String username, String password, String email, Set<GrantedAuthority> authorities, List<UserAddress> userAddress, List<UserOrder> userOrder, UserInformation information, String status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.userAddress = userAddress;
        this.userOrder = userOrder;
        this.information = information;
        this.status = status;
    }

    public UserDetailsImpl(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toSet());
        this.userAddress = user.getUserAddress();
        this.userOrder = user.getUserOrder();
        this.information = user.getInformation();
        this.status = user.getStatus();
    }

    public static UserDetails build(User user) {
       return new UserDetailsImpl(user);
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public List<UserAddress> getUserAddress() {
        return userAddress;
    }

    public List<UserOrder> getUserOrder() {
        return userOrder;
    }

    public UserInformation getInformation() {
        return information;
    }

    public String getStatus() {
        return status;
    }
}

