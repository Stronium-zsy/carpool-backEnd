package com.example.carpoolforcollegestudents.Interceptors;

//import com.example.carpoolforcollegestudents.Pojo.Result;
//import com.example.carpoolforcollegestudents.Utils.JwtUtil;
//import com.example.carpoolforcollegestudents.Utils.ThreadLocalUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Map;
//
//@Component
//public class LoginInterceptor implements HandlerInterceptor {
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
//
//        String token=request.getHeader("Authorization");
//        try {
//
//            ValueOperations<String,String> operations=stringRedisTemplate.opsForValue();
//            String redistoken=operations.get(token);
//            if(redistoken==null){
//                throw new RuntimeException();
//            }
//            Map<String,Object> claims= JwtUtil.parseToken(token);
//            ThreadLocalUtil.set(claims);
//
//            return true;
//
//        } catch (Exception e) {
//
//            response.setStatus(401);
//            return false;
//
//        }
//
//    }
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        ThreadLocalUtil.remove();
//    }
//
//}
