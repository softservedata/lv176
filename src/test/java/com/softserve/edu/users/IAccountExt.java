package com.softserve.edu.users;

public interface IAccountExt extends IAccount {
	
	IAccountExt setDate(String date);

	IAccountExt setRegisterNumber(String registerNumber);

	IAccountExt setRegistratorNumber(String registratorNumber);

	IAccountExt setVolumeNumber(String volumeNumber);

}
