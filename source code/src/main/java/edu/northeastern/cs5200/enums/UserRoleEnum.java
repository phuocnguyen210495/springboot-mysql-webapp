//package edu.northeastern.cs5200.enums;
//
//
//import lombok.Getter;
//
//import java.io.Serializable;
//
//@Getter
//public enum UserRoleEnum implements Serializable {
//
//    SELLER(1,"seller"),
//    SHOPPER(2,"shopper"),
//    ADMIN(3,"admin");
//
//    private Integer code;
//    private String message;
//
//    public static UserRoleEnum parseByCode(Integer code){
//        for(UserRoleEnum status: UserRoleEnum.values()){
//            if(status.getCode().equals(code))
//                return status;
//        }
//        return  null;
//    }
//
//    UserRoleEnum(Integer code, String message){
//        this.code = code;
//        this.message = message;
//    }
//
//	public Integer getCode() {
//		return code;
//	}
//
//	public void setCode(Integer code) {
//		this.code = code;
//	}
//
//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}
//    
//}
