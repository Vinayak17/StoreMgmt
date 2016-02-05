package com.storemgmt.model;

import java.util.Date;

import org.joda.time.LocalDateTime;

public interface IAuditable 
{
	public long getId();
	public String getLogDetail();
}