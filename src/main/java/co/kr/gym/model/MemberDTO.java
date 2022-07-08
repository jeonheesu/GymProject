package co.kr.gym.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberDTO {
    
 private int g_no;
 private String g_id;
 private String g_password;
 private String g_Rpassword;
 private String g_name;
 private double g_height;
 private double g_weight;
 private double g_bmi;
 private Timestamp c_regDate;
}
