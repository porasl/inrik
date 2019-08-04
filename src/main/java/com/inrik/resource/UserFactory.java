package com.inrik.resource;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.inrik.auth.model.User;

public class UserFactory {

	public User getUserInfo(String jsonString) throws JSONException {

		JSONObject jsonObject = new JSONObject(jsonString);
		User userInfo = new User();
		/*PublisherInfo publisherInfo = new UserInfo();
		publisherInfo.setFirstName(jsonObject.getString("firstName"));
		publisherInfo.setLastName(jsonObject.getString("lastName"));
		publisherInfo.setPhoneNumber(jsonObject.getString("phoneNumber"));
		publisherInfo.setEmailAddress(URLDecoder.decode(jsonObject.getString("emailAddress")));
		publisherInfo.setAddress(jsonObject.getString("address"));
		publisherInfo.setZipcode(jsonObject.getString("zipcode"));
		publisherInfo.setCity(jsonObject.getString("city"));
		publisherInfo.setCountry(jsonObject.getString("country"));
		publisherInfo.setPassword(jsonObject.getString("password"));
		publisherInfo.setCreationDate(new Date());
		*/

		return userInfo;
	}
}
