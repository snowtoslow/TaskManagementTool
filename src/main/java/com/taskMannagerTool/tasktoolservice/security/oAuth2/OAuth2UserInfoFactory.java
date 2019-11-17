package com.taskMannagerTool.tasktoolservice.security.oAuth2;

import com.taskMannagerTool.tasktoolservice.exceptions.OAuth2AuthenticationProcessingException;
import com.taskMannagerTool.tasktoolservice.models.AuthProvider;
import com.taskMannagerTool.tasktoolservice.security.oAuth2.user.GithubOAuth2UserInfo;
import com.taskMannagerTool.tasktoolservice.security.oAuth2.user.GoogleOAuth2UserInfo;
import com.taskMannagerTool.tasktoolservice.security.oAuth2.user.OAuth2UserInfo;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProvider.GOOGLE.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.GITHUB.toString())) {
            return new GithubOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}