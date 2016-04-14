package com.softserve.edu.entity;

public interface IAccountExt extends IAccount {
	
	IAccountExt setDate(String date);

	IAccountExt setRegisterNumber(String registerNumber);

	IAccountExt setRegistratorNumber(String registratorNumber);

	IAccountExt setVolumeNumber(String volumeNumber);

}
