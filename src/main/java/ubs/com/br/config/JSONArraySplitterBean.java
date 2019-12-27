package ubs.com.br.config;

import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class JSONArraySplitterBean {
	public static List<JSONObject> convertToListOfJsonObjects(String input) {
		try {
			JSONArray array = new JSONArray(input);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
	