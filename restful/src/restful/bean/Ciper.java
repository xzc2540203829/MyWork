package restful.bean;

import javax.ws.rs.FormParam;

public class Ciper {
    @FormParam("cipher1")
    private String cipher1;
    @FormParam("mess_cipher1")
    private String mess_cipher1;
    @FormParam("studentNum")
    private String studentNum;
    @FormParam("zh_key")
    private String zh_key;
    @FormParam("zh_mess")
    private String zh_mess;
    @FormParam("zh_cipher")
    private String zh_cipher;

    public String getCipher1() {
        return cipher1;
    }

    public void setCipher1(String cipher1) {
        this.cipher1 = cipher1;
    }

    public String getMess_cipher1() {
        return mess_cipher1;
    }

    public void setMess_cipher1(String mess_cipher1) {
        this.mess_cipher1 = mess_cipher1;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getZh_key() {
        return zh_key;
    }

    public void setZh_key(String zh_key) {
        this.zh_key = zh_key;
    }

    public String getZh_mess() {
        return zh_mess;
    }

    public void setZh_mess(String zh_mess) {
        this.zh_mess = zh_mess;
    }

    public String getZh_cipher() {
        return zh_cipher;
    }

    public void setZh_cipher(String zh_cipher) {
        this.zh_cipher = zh_cipher;
    }
}
