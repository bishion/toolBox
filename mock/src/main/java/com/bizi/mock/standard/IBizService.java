package com.bizi.mock.standard;

import com.bizi.mock.spring.UserDTO;

/**
 * 描述：
 * Created by GuoFangBi on 16-3-8.
 */
public interface IBizService {
    String sendMail(String content);
    String getRemoteResult(String username);
}
