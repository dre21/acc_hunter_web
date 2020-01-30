/*Copyright (c) 2019-2020 deltadatamandiri.com All Rights Reserved.
 This software is the confidential and proprietary information of deltadatamandiri.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with deltadatamandiri.com*/
package com.acc_hunter_web.sendmailservice;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

import org.springframework.beans.factory.annotation.Autowired;


import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;


import javax.servlet.http.HttpServletRequest;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import java.util.Properties;
import javax.mail. * ;
import javax.mail.internet. * ;
import java.util.Properties;
import javax.activation. * ;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import com.wavemaker.runtime.security.SecurityService;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
import com.wavemaker.runtime.service.annotations.HideFromClient;

//import com.acc_hunter_mobile.emailservice.model.*;

/**
 * This is a singleton class with all its public methods exposed as REST APIs via generated controller class.
 * To avoid exposing an API for a particular public method, annotate it with @HideFromClient.
 *
 * Method names will play a major role in defining the Http Method for the generated APIs. For example, a method name
 * that starts with delete/remove, will make the API exposed as Http Method "DELETE".
 *
 * Method Parameters of type primitives (including java.lang.String) will be exposed as Query Parameters &
 * Complex Types/Objects will become part of the Request body in the generated API.
 *
 * NOTE: We do not recommend using method overloading on client exposed methods.
 */
@ExposeToClient
public class SendMailService {

    private static final Logger logger = LoggerFactory.getLogger(SendMailService.class);
    private Session session;

    private boolean authentication=true;
    private boolean smtpServerTTLSEnabled = true;
    // @Value("${app.environment.host}") private String host;
    // @Value("${app.environment.port}") private String port;
    // @Value("${app.environment.username}") private String username;
    // @Value("${app.environment.password}") private String password;
    
    private String host = "smtp.gmail.com";
    private String port = "587";
    private String username="acchunter2019@gmail.com";
    private String password="ACCHunter2019";
    private String fromEmailAddress = "acchunter2019@gmail.com";
    
    // private String host = "smail.acc.co.id";
    // private String port = "465";
    // private String username = "hunter_noreply@acc.co.id";
    // private String password = "Hunter2019#!";
    // private String fromEmailAddress = "hunter_noreply@acc.co.id";
    
    @PostConstruct
    public void init() throws Exception {
        Properties props = new Properties();
        props.put("mail.smtp.auth", String.valueOf(authentication));
        props.put("mail.smtp.starttls.enable",smtpServerTTLSEnabled);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
    
    public void sendEmail(String toEmailAddress, String emailSubject, String emailMessage) {
         logger.info("toEmailAddress {}, emailSubject {}, emailMessage {} ",
         toEmailAddress,emailSubject,emailMessage);
         try {
             MimeBodyPart htmlPart = new MimeBodyPart();
             htmlPart.setContent(emailMessage, "text/html");
             
             Multipart mp = new MimeMultipart();
             mp.addBodyPart(htmlPart);
             
            Properties props = System.getProperties();
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", username);
            props.put("mail.smtp.password", password);
            props.put("mail.smtp.port", 587);
            props.put("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(props);
             
             Transport tr = session.getTransport("smtp");
             tr.connect(host, 587, username, password);
             String[] listemails = toEmailAddress.split(",");
             
             for (int i = 0; i < listemails.length; i++) {
                // Create email message
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(fromEmailAddress));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(listemails[i]));
                message.setSubject(emailSubject);
                message.setContent(mp);

                message.saveChanges();
                tr.sendMessage(message, message.getAllRecipients());
             }
             tr.close();
             
             logger.info("Sent message successfully....");
              } catch (MessagingException e) {
                 throw new RuntimeException(e);
             }
         }

}