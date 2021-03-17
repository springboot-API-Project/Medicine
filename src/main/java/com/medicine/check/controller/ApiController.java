package com.medicine.check.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/allow_info/basic")
    public String allowBasic() {
        StringBuffer result = new StringBuffer();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471057/MdcinPrductPrmisnInfoService1/getMdcinPrductList"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=hjXd0PEo4ZCLTmgH470u%2F78OfjgmIJ5FCe%2BbsvihjtnU8CSYbABQr%2BllthZnA7ODRmgqbrmLKz8P9m7%2FImWgfA%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
            urlBuilder.append("&type=json"); /*결과 json 포맷*/
//            URL url = new URL(urlBuilder.toString());
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line + "\n");
            }
            rd.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        return result + "";
        return result.toString();
    }

    @GetMapping("/allow_info/detail")
    public String allowDetail() {
        StringBuffer result = new StringBuffer();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471057/MdcinPrductPrmisnInfoService1/getMdcinPrductItem"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=hjXd0PEo4ZCLTmgH470u%2F78OfjgmIJ5FCe%2BbsvihjtnU8CSYbABQr%2BllthZnA7ODRmgqbrmLKz8P9m7%2FImWgfA%3D%3D"); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
            urlBuilder.append("&type=json"); /*결과 json 포맷*/
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String line;
            result.append("<xmp>");
            while ((line = rd.readLine()) != null) {
                result.append(line + "\n");
            }
            rd.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result + "</xmp>";
    }

    @GetMapping("/side-effect")
    public StringBuffer sideEffect() {
        StringBuffer result = new StringBuffer();
        try {
            String urlstr = "http://apis.data.go.kr/1471000/MdcinSdefctInfoService/getMdcinSdefctInfoList?" +
                    "ServiceKey=XtgKFCFkYw2%2F3iWJ0SQQoq2%2BgoizLC4nKTMTi6%2BgHEreb3FFNtxxJf%2FfawW%2FHqT0A0vtGqoBXWZbzi0uhhBnJg%3D%3D" +
                    "&type=json" +
                    "&pageNo=1" +
                    "&numOfRows=3" +
                    "&col_002=Isoniazide";

            URL url = new URL(urlstr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line + "\n");
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}


