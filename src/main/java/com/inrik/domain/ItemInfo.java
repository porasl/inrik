package com.inrik.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Type;

import com.inrik.utils.State;

@Entity
@Table(name = "iteminfo")
public class ItemInfo {
	
	private long iteminfoid;
	
	@Column(nullable=true)
	private double version;
	
	@Column(nullable=true)
	private String locale;
	
	@Column(nullable=true)
	private String name;
	
	@Column(nullable=true)
	private String type;
	
	@Column(nullable=true)
	private boolean accesstype;
	
	@Column(nullable=true)
	private boolean notified;
	
	@Column(nullable=true)
	private boolean deleted;
	
	@Column(nullable=true)
	private int deletecode;
	
	@Column(nullable=true)
	private State state;
	
	@Column(nullable=true)
	private String description;
	
	@Column(nullable=true)
	private String format;
	
	@Column(nullable=true)
	private String audiopath;
	
	@Column(nullable=true)
	private String imagepath;
	
	@Column(nullable=true)
	private String videopath;
	
	@Column(nullable=true)
	private String audiomainname;
	
	@Column(nullable=true)
	private String imagemainname;
	
	@Column(nullable=true)
	private String videomainname;
	
	@Column(nullable=true)
	private String price;
	
	@Column(nullable=true)
	private String paidamount;
	
	@Column(nullable=true) 
	private String selectedtemplate;
	
	@Column(nullable=true)
	@Type(type="timestamp")
	public Date creationdate;
	
	@Column(nullable=true)
	@Type(type="timestamp")
	private Date modificationdate;
	
	@Column(nullable=true)
	@Type(type="timestamp")
	private Date expirationdate;
	
	@Column(nullable=true)
	@Type(type="timestamp")
	private Date deletiondate;

	@Column(nullable=true)
	private Long userid;
	
	public void setUserid(Long userid)
	{
		this.userid = userid;
	}
	
	
	public Long getUserid()
	{
		return userid;
	}
	
	
	@Id
	@Column(name="iteminfoid")
	@TableGenerator(name="iteminfo", table="Item_Pktb", 
	pkColumnName="itemKey", pkColumnValue="itemValue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="iteminfo")
	public long getIteminfoid() {
		return iteminfoid;
	}
	
	public void setIteminfoid(long iteminfoId) {
		this.iteminfoid = iteminfoId;
	}
	
	
	public boolean getAccesstype(){
	  return accesstype;
	}
	
	public void setAccesstype(boolean accesstype){
		 this.accesstype = accesstype;
	}
	
	public boolean getNotified(){
		  return notified;
		}
		
	public void setNotified(boolean notified){
			 this.notified = notified;
		}
	
	public boolean getDeleted(){
		  return deleted;
		}
		
	public void setDeleted(boolean deleted){
			 this.deleted = deleted;
		}
	
	public int getDeletecode(){
		  return deletecode;
		}
		
	public void setDeletecode(int deletecode){
			 this.deletecode = deletecode;
		}
	
	public State getState(){
		  return state;
		}
		
	public void setState(State state){
			 this.state = state;
		}
	
	public String getSelectedtemplate(){
		  return selectedtemplate;
		}
		
	public void setSelectedtemplate(String selectedtemplate){
			 this.selectedtemplate = selectedtemplate;
		}
	
	public String getImagemainname(){
		  return imagemainname;
	}
		
	public void setImagemainname(String imagemainname){
			 this.imagemainname = imagemainname;
		}
	

	public double getVersion() {
		return version;
	}

	public void setVersion(double version) {
		this.version = version;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getAudiopath() {
		return audiopath;
	}

	public void setAudiopath(String audiopath) {
		this.audiopath = audiopath;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	public String getVideopath() {
		return videopath;
	}

	public void setVideopath(String videopath) {
		this.videopath = videopath;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getPaidamount() {
		return paidamount;
	}

	public void setPaidamount(String paidamount) {
		this.paidamount = paidamount;
	}
	
	public Date getDeletiondate() {
		return deletiondate;
	}

	public void setDeletiondate(Date deletiondate) {
		this.deletiondate = deletiondate;
	}
	
	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public Date getModificationdate() {
		return modificationdate;
	}

	public void setModificationdate(Date modificationdate) {
		this.modificationdate = modificationdate;
	}

	public Date getExpirationdate() {
		return expirationdate;
	}

	public void setExpirationdate(Date expirationdate) {
		this.expirationdate = expirationdate;
	}


	public String getVideomainname() {
		return videomainname;
	}


	public void setVideomainname(String videomainname) {
		this.videomainname = videomainname;
	}
	
	public String getAudiomainname() {
		return audiomainname;
	}


	public void setAudiomainname(String audiomainname) {
		this.audiomainname = audiomainname;
	}
}
