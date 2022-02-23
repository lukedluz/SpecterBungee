package com.lucas.specterbungee.changelog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lucas.specterbungee.alertbans.MySQL;

public class Changelog {
	
	public static List<Changelog> log;
	private String title;
	private String topic;
	private int id;
	private String date;

	public Changelog() {
		this.title = "";
		this.topic = "";
		this.id = 0;
		this.date = "";
	}

	public Changelog(int id) {
		this.title = "";
		this.topic = "";
		this.id = id;
		this.date = "";
	}

	public String getTitle() {
		return this.title;
	}

	public String getTopic() {
		return this.topic;
	}

	public String getDate() {
		return this.date;
	}

	public int getId() {
		return this.id;
	}

	public void setTitle(String args) {
		this.title = args;
	}

	public void setTopic(String args) {
		this.topic = args;
	}

	public void setDate(String args) {
		this.date = args;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static List<Changelog> getList() {
		return Changelog.log;
	}

	public static void carregarChangelog() {
		List<Changelog> los = new ArrayList<Changelog>();
		try {
			PreparedStatement ps = MySQL.connection.prepareStatement("SELECT * FROM website_changelog ORDER BY website_changelog.changelog_ID DESC;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("changelog_ID");
				String bruto = rs.getString("changelog_DATE");
				String date = String.valueOf(bruto.split("-")[2]) + "/" + bruto.split("-")[1] + "/" + bruto.split("-")[0];
				String title = rs.getString("changelog_TITLE");
				String topic = rs.getString("changelog_TOPIC");
				Changelog change = new Changelog(id);
				change.setId(id);
				change.setTitle(title);
				change.setTopic(topic);
				change.setDate(date);
				los.add(change);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Changelog.log = los;
	}
}
