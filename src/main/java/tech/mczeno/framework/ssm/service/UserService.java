package tech.mczeno.framework.ssm.service;

/**
 * @author Chongming Zhou
 * @date 2018-07-08
 */
public interface UserService {

    String getToken(String username, String password);
}
