/**
 * 
 */
package net.i77soft.spring.mvc3.model;


/**
 * @author shines77
 *
 */

/*
CREATE TABLE `gameserver` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `regionId` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `regionName` char(15) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'UNK',
  `areaId` smallint(5) unsigned NOT NULL DEFAULT '0',
  `areaName` char(15) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Unknown',
  `areaNameFull` char(63) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Unknown Area',
  `langId` tinyint(3) unsigned NOT NULL DEFAULT '0',
  `langLocale` char(15) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'LOC',
  `serverId` int(8) unsigned NOT NULL DEFAULT '0',
  `serverName` char(15) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Unknown',
  `serverNameFull` char(31) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Unknown Server',
  `serverNameAlias` char(63) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Unknown Server Alias',
  `serverIP` char(31) COLLATE utf8_unicode_ci NOT NULL DEFAULT '1.1.1.1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci

 */

public class GameServer /* implements Serializable */ {
	private long id;
	private int regionId;
	private String regionName;
	private int areaId;
	private String areaName;
	private String areaNameFull;
	private int langId;
	private String langLocale;
	private long serverId;
	private String serverName;
	private String serverNameFull;
	private String serverNameAlias;
	private String serverIP;

	public GameServer() {
		id = 0;
		regionId = 0;
		regionName = "UNK";
		areaId = 0;
		areaName = "Unknown";
		areaNameFull = "Unknown Area";
		langId = 0;
		langLocale = "LOC";
		serverId = 0;
		serverName = "Unknown";
		serverNameFull = "Unknown Server";
		serverNameAlias = "Unknown Server Alias";
		serverIP = "1.1.1.1";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaNameFull() {
		return areaNameFull;
	}

	public void setAreaNameFull(String areaNameFull) {
		this.areaNameFull = areaNameFull;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	public String getLangLocale() {
		return langLocale;
	}

	public void setLangLocale(String langLocale) {
		this.langLocale = langLocale;
	}

	public long getServerId() {
		return serverId;
	}

	public void setServerId(long serverId) {
		this.serverId = serverId;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerNameFull() {
		return serverNameFull;
	}

	public void setServerNameFull(String serverNameFull) {
		this.serverNameFull = serverNameFull;
	}

	public String getServerNameAlias() {
		return serverNameAlias;
	}

	public void setServerNameAlias(String serverNameAlias) {
		this.serverNameAlias = serverNameAlias;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(getClass()).append("[")
		.append("regionId=").append(regionId).append(", ")
		.append("regionName=").append(regionName).append(", ")
		.append("areaId=").append(areaId).append(", ")
		.append("areaName=").append(areaName).append(", ")
		.append("areaNameFull=").append(areaNameFull).append(", ")
		.append("langId=").append(langId).append(", ")
		.append("langLocale=").append(langLocale).append(", ")
		.append("serverId=").append(serverId).append(", ")
		.append("serverName=").append(serverName).append(", ")
		.append("serverNameFull=").append(serverNameFull).append(", ")
		.append("serverNameAlias=").append(serverNameAlias).append(", ")
		.append("serverIP=").append(serverIP).append("]");

		return sb.toString();
	}

}
