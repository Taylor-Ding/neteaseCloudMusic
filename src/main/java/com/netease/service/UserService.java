package com.netease.service;

import com.netease.bean.UrlParam;
import com.netease.common.Api;
import com.netease.common.SendRequest;
import com.netease.config.MusicProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private MusicProperties MP;

    public String loginCellphone(String phone, String password) throws Exception {
        String url = MP.BASEURL + MP.LOGINCELLPHONE;
        String encryptionPw = DigestUtils.md5DigestAsHex(password.getBytes());
        UrlParam up = Api.loginCellphone(url, phone, encryptionPw);
        return SendRequest.getMusicData(up);
    }

    public String login(String email, String password) throws Exception {
        String url = MP.BASEURL + MP.LOGIN;
        String encryptionPw = DigestUtils.md5DigestAsHex(password.getBytes());
        UrlParam up = Api.login(url, email, encryptionPw);
        return SendRequest.getMusicData(up);
    }

    public String recommendSongs(String cookie) throws Exception {
        String url = MP.BASEURL + MP.RECOMMENDSONGS;
        UrlParam up = Api.recommendSongs(url, cookie);
        return SendRequest.getMusicDataByCookie(up);
    }

    public String recommendResource(String cookie) throws Exception {
        String url = MP.BASEURL + MP.RECOMMENDRESOURCE;
        UrlParam up = Api.recommendResource(url, cookie);
        return SendRequest.getMusicDataByCookie(up);
    }

    public String userPlayList(String uid, Integer limit, Integer offset) throws Exception {
        String url = MP.BASEURL + MP.USERPLAYLIST;
        UrlParam up = Api.userPlayList(url, uid, limit, offset);
        return SendRequest.getMusicData(up);
    }

}
