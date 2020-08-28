//package edu.northeastern.cs5200.controller;
//
//import java.io.UnsupportedEncodingException;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.google.common.collect.Lists;
//
//import edu.northeastern.cs5200.constant.Result;
//import edu.northeastern.cs5200.daos.CustomerDao;
//import edu.northeastern.cs5200.daos.UserDao;
//import edu.northeastern.cs5200.domain.RequestUserHolder;
//import edu.northeastern.cs5200.models.Customer;
//import edu.northeastern.cs5200.models.User;
////import edu.northeastern.cs5200.models.UserRole;
//import edu.northeastern.cs5200.util.CookieHelper;
//
//@RestController
//@RequestMapping(value = "/user")
//public class UserController {
//
//    @Autowired
//    private UserDao userDao;
//    @Autowired
//    private CustomerDao customerDao;
////    
//////customer login
////    @GetMapping("/login")
////    public Result login(HttpServletRequest request,
////                        HttpServletResponse response,
////                        String email,
////                        String password) throws UnsupportedEncodingException {
////        User user = userDao.findUserByEmail(email);
//////        Customer customer = customerDao.findCustomerByEmail(email);
////        if(!user.getPassword().equals(password)){
////            return Result.fail(1004, "password error");
////        }
//////        List<UserRole> userRoles = userDao.findUserByEmail(email);
//////        user.setUserRoles(userRoles);
////        CookieHelper.clearCookie(request, response);
////        HttpSession session = request.getSession();
////        session.setAttribute("session", user);
////        return Result.SUCCESS_RESULT;
////    }
//    
//    @GetMapping("/login")
//    public String login(HttpServletRequest request,
//                        HttpServletResponse response,
//                        String email,
//                        String password) throws UnsupportedEncodingException {
//        User user = userDao.findUserByEmail(email);
////        Customer customer = customerDao.findCustomerByEmail(email);
//        if(!user.getPassword().equals(password)){
//            return "failed login";
//        }
////        List<UserRole> userRoles = userDao.findUserByEmail(email);
////        user.setUserRoles(userRoles);
//        CookieHelper.clearCookie(request, response);
//        HttpSession session = request.getSession();
//        session.setAttribute("session", user);
//        return "success";
//    }
//
//    @GetMapping(value = "/logout")
//    public void logout(HttpServletRequest request, HttpServletResponse response){
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.removeAttribute("session");
//            session.invalidate();
//        }
//        CookieHelper.clearCookie(request, response);
//    }
//
////    @PostMapping(value = "/seller")
////    public Result registerSeller(@RequestBody User user){
////        UserRole userRole = new UserRole();
////        userRole.setUserRole(UserRoleEnum.SELLER);
////        user.setUserRoles(Lists.newArrayList());
////        user.getUserRoles().add(userRole);
////        userDao.createUser(user);
////        return Result.SUCCESS_RESULT;
////    }
////
////    @PostMapping(value = "/shopper")
////    public Result registerShopper(@RequestBody User user){
////        UserRole userRole = new UserRole();
////        userRole.setUid(user.getId());
////        userRole.setUserRole(UserRoleEnum.SHOPPER);
////        user.setUserRoles(Lists.newArrayList());
////        user.getUserRoles().add(userRole);
////        userService.createUser(user);
////        return Result.SUCCESS_RESULT;
////    }
////
////    @PostMapping(value = "/admin")
////    public Result registerAdmin(@RequestBody User user){
////        UserRole userRole = new UserRole();
////        userRole.setUid(user.getId());
////        userRole.setUserRole(UserRoleEnum.ADMIN);
////        user.setUserRoles(Lists.newArrayList());
////        user.getUserRoles().add(userRole);
////        userService.createUser(user);
////        return Result.SUCCESS_RESULT;
////    }
////
//    @GetMapping(value = "/user")
//    public Result getInfo(){
//        User user = RequestUserHolder.get();
//        return Result.okWithData(user);
//    }
//}