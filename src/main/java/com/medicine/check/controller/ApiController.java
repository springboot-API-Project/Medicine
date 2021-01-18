package com.medicine.check.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
//            urlBuilder.append("&" + URLEncoder.encode("item_name", "UTF-8") + "=" + URLEncoder.encode("종근당염산에페드린정", "UTF-8")); /*제품명*/
//            urlBuilder.append("&" + URLEncoder.encode("entp_name", "UTF-8") + "=" + URLEncoder.encode("(주)종근당", "UTF-8")); /*업체명*/
//            urlBuilder.append("&" + URLEncoder.encode("induty", "UTF-8") + "=" + URLEncoder.encode("의약품", "UTF-8")); /*업종*/
//            urlBuilder.append("&" + URLEncoder.encode("prdlst_Stdr_code", "UTF-8") + "=" + URLEncoder.encode("195500002", "UTF-8")); /*품목일련번호*/
//            urlBuilder.append("&" + URLEncoder.encode("spclty_pblc", "UTF-8") + "=" + URLEncoder.encode("전문의약품", "UTF-8")); /*전문/일반구분코드_M58*/
//            urlBuilder.append("&" + URLEncoder.encode("prduct_prmisn_no", "UTF-8") + "=" + URLEncoder.encode("7", "UTF-8")); /*품목허가번호*/
//            urlBuilder.append("&" + URLEncoder.encode("order", "UTF-8") + "=" + URLEncoder.encode("Y", "UTF-8")); /*order=Y로 요청메시지를 주게 되면, 품목허가일자 역순으로 데이터가 조회된다.*/
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과수*/
            urlBuilder.append("&type=json"); /*결과 json 포맷*/
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Content-type", "application/json");
            BufferedReader rd;
            if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
//            StringBuilder sb = new StringBuilder();
            String line;
//            while ((line = rd.readLine()) != null) {
//                sb.append(line);
//            }
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
}
