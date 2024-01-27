 package tw.com.eeit.midtermfix.dao;

import java.io.Serializable;

public class ModelMemberBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int Jan109Id;
	private String YM;
	private String Region;
	private String LandAmount;
	private String LandArea;
	private String BuildingAmount;
	private String BuildingArea;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getJan109Id() {
		return Jan109Id;
	}
	public void setJan109Id(int jan109Id) {
		this.Jan109Id = jan109Id;
	}
	public String getYM() {
		return YM;
	}
	public void setYM(String yM) {
		this.YM = yM;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		this.Region = region;
	}
	public String getLandAmount() {
		return LandAmount;
	}
	public void setLandAmount(String landAmount) {
		this.LandAmount = landAmount;
	}
	public String getLandArea() {
		return LandArea;
	}
	public void setLandArea(String landArea) {
		this.LandArea = landArea;
	}
	public String getBuildingAmount() {
		return BuildingAmount;
	}
	public void setBuildingAmount(String buildingAmount) {
		this.BuildingAmount = buildingAmount;
	}
	public String getBuildingArea() {
		return BuildingArea;
	}
	public void setBuildingArea(String buildingArea) {
		this.BuildingArea = buildingArea;
	}
	@Override
	public String toString() {
		return "ModelMemberBean [Jan109Id=" + Jan109Id + ", YM=" + YM + ", Region=" + Region + ", LandAmount="
				+ LandAmount + ", LandArea=" + LandArea + ", BuildingAmount=" + BuildingAmount + ", BuildingArea="
				+ BuildingArea + "]";
	}
	public ModelMemberBean() {
	}

	public ModelMemberBean(int Jan109Id,String yM, String region, String landAmount, String landArea, String buildingAmount, String buildingArea) {
		this.Jan109Id=Jan109Id;
		this.YM = yM;
		this.Region = region;
		this.LandAmount = landAmount;
		this.LandArea = landArea;
		this.BuildingAmount = buildingAmount;
		this.BuildingArea = buildingArea;
	}
	public ModelMemberBean(String yM, String region, String landAmount, String landArea, String buildingAmount, String buildingArea) {
		this.YM = yM;
		this.Region = region;
		this.LandAmount = landAmount;
		this.LandArea = landArea;
		this.BuildingAmount = buildingAmount;
		this.BuildingArea = buildingArea;
	}
	public ModelMemberBean(int Jan109Id, String region) {
		this.Jan109Id = Jan109Id;
		this.Region = region;
	}
	
	
}

