package com.example.medical.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/email-otp")
@CrossOrigin(origins = "*")
public class EmailOtpController {

    @Autowired
    private JavaMailSender mailSender;

    private String generatedOtp;
    private long otpGeneratedTime;

    @PostMapping("/send")
    public String sendOtp(@RequestParam String email) {

        Random random = new Random();

        generatedOtp = String.format("%06d", random.nextInt(1000000));

        otpGeneratedTime = System.currentTimeMillis();

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Medical Lab Portal - Email OTP");

        message.setText(
                "Your OTP is: " + generatedOtp +
                "\n\nThis OTP is valid for 5 minutes." +
                "\n\nThis OTP is for Medical Lab Portal registration."
        );

        mailSender.send(message);

        return "OTP sent successfully";
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String otp) {

        long currentTime = System.currentTimeMillis();

        // OTP valid for 5 minutes
        if (currentTime - otpGeneratedTime > 5 * 60 * 1000) {
            return "OTP expired";
        }

        if (generatedOtp != null && generatedOtp.equals(otp)) {
            return "OTP verified successfully";
        }

        return "Invalid OTP";
    }
}