package com.locknlol.coukie.adapter.staticdatav3;

import com.google.gson.Gson;
import com.locknlol.coukie.domain.champion.Champion;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by kev on 2017. 5. 25.
 */
@Component
public class StaticDataV3Adapter {

	public Champion getJaxTest() {
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
		Map map = jsonParser.parseMap(sb.toString());
		Map map2 = (Map)map.get("data");

		Gson gson = new Gson();
		Champion jax = gson.fromJson(gson.toJson(map2.get("Jax")),Champion.class);
		return jax;
	}


}
