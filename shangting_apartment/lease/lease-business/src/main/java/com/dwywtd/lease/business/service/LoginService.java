package com.dwywtd.lease.business.service;

import com.dwywtd.lease.business.vo.CaptchaVo;
import com.dwywtd.lease.business.vo.LoginVo;
import com.dwywtd.lease.business.vo.SystemUserInfoVo;

public interface LoginService {

    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);

    SystemUserInfoVo getLoginUserInfo(Long userId);
}
