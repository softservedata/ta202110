package com.softserve.edu;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

class GitHubSimple {

	private String login;
	private String id;
	private String name;

	public GitHubSimple(String login, String id, String name) {
		this.login = login;
		this.id = id;
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "GitHubSimple ["
				+ " login=" + login
				+ ", id=" + id
				+ ", name=" + name
				+ " ]";
	}
}

public class RestTest {

	@Test
	public void checkGithubSimple() throws Exception {
		Gson gson = new Gson();
		GitHubSimple gitHubSimple;
		//
		OkHttpClient client = new OkHttpClient();
		Request request;
		Response response;
		String resultJson;
		//
		// Get TokenLifetime
		request = new Request.Builder()
				.url("https://api.github.com/users/softservedata")
				.get()
				.build();
		response = client.newCall(request).execute();
		resultJson = response.body().string();
		gitHubSimple = gson.fromJson(resultJson, GitHubSimple.class);
		//
		Assert.assertTrue(response.isSuccessful());
		System.out.println("resultJson: " + resultJson);
		System.out.println("gitHubSimple: " + gitHubSimple);
		//
	}
	
}
