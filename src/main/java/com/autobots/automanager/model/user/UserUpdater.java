package com.autobots.automanager.model.user;

import com.autobots.automanager.entity.User;
import com.autobots.automanager.model.NullStringVerifier;
import org.springframework.stereotype.Component;

@Component
public class UserUpdater {
	private NullStringVerifier verifier = new NullStringVerifier();

	public void update(User user, User updatedUser) {
		if (updatedUser.getRole() != null) {
			user.setRole(updatedUser.getRole());
		}
		if (!verifier.verify(updatedUser.getName())) {
			user.setName(updatedUser.getName());
		}
		if (!verifier.verify(updatedUser.getNickname())) {
			user.setNickname(updatedUser.getNickname());
		}
		if (updatedUser.getDocumentType() != null) {
			user.setDocumentType(updatedUser.getDocumentType());
		}
		if (updatedUser.getDocumentValue() != null) {
			user.setDocumentValue(updatedUser.getDocumentValue());
		}
		if (updatedUser.getPhone() != null) {
			user.setPhone(updatedUser.getPhone());
		}
		if (updatedUser.getEmail() != null) {
			user.setEmail(updatedUser.getEmail());
		}
		if (updatedUser.getBirthDate() != null) {
			user.setBirthDate(updatedUser.getBirthDate());
		}

		// Address
		if (!verifier.verify(updatedUser.getState())) {
			user.setState(updatedUser.getState());
		}
		if (!verifier.verify(updatedUser.getCity())) {
			user.setCity(updatedUser.getCity());
		}
		if (!verifier.verify(updatedUser.getDistrict())) {
			user.setDistrict(updatedUser.getDistrict());
		}
		if (!verifier.verify(updatedUser.getStreet())) {
			user.setStreet(updatedUser.getStreet());
		}
		if (updatedUser.getNumber() != null) {
			user.setNumber(updatedUser.getNumber());
		}
		if (!verifier.verify(updatedUser.getComplement())) {
			user.setComplement(updatedUser.getComplement());
		}
	}
}