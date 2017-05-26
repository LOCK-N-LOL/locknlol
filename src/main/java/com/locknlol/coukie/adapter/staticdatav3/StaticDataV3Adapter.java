package com.locknlol.coukie.adapter.staticdatav3;

import org.springframework.boot.json.JacksonJsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kev on 2017. 5. 25.
 */
public class StaticDataV3Adapter {

	public static void test() {
		BufferedReader rd = null;
		HttpURLConnection conn = null;
		try

		{
			int id = 266;
			String urlAdress = "https://kr.api.riotgames.com/lol/static-data/v3/champions?champListData=all&api_key=98930870-11b9-4d43-ad3d-2c629c631a38";

			String urlAdress2 = "https://kr.api.riotgames.com/lol/static-data/v3/champions/" + id + "?api_key=RGAPI-57969e80-fe51-4674-bfc7-14c0cdd69617";
			URL url = new URL(
				urlAdress);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		try {

			String line;
			while ((line = rd.readLine()) != null)

			{
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
		} catch (Exception e) {

		}
		JacksonJsonParser jsonParser = new JacksonJsonParser();
		System.out.println(jsonParser.parseMap(sb.toString()));


	}

	public static void main(String[] args) {
		test();
	}

}
