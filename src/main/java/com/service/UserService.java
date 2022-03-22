//package com.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import com.repos.UserDAORepos;
//
//@Service
//public class UserService implements UserDetailsService {
//    @Autowired
//    private UserDAORepos userRepos;
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        return userRepos.findByPassport(login);
//    }
//
//    /*public List<UserDAO> findAll(){
//        return userRepos.findAll();
//    }
//
//    public void saveChangedUser(User user, Map<String, String> form){
//        Set<String> roles = Arrays.stream(Role.values())
//                .map(Role::name)
//                .collect(Collectors.toSet());
//
//        user.getRoles().clear();
//        for(String key : form.keySet()){
//            if (key.equals("ADMIN")){
//                user.getRoles().add(Role.valueOf("ADMIN"));
//                user.getRoles().add(Role.valueOf("MASTER"));
//            }
//            if (key.equals("MASTER")){
//                user.getRoles().add(Role.valueOf("MASTER"));
//            }
//            if (key.equals("USER")){
//                user.getRoles().add(Role.valueOf("USER"));
//            }
////
//        }
//        userRepos.save(user);
//    }
//
//    public void saveUser(User user) {
//        userRepos.save(user);
//    }*/
//
//    /*public void updateProfile(User user, String nickname, String email) {
//        String userEmail = user.getEmail();
//
//
//        boolean isEmailChanged = (email != null && !email.equals(userEmail))
//                || (userEmail != null && userEmail.equals(email));
//
//        if (isEmailChanged)
//            user.setEmail(email);
//
//        user.setNickname(nickname);
//        userRepos.save(user);
//
//    }*/
//}
