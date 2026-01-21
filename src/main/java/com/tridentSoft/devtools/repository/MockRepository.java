package com.tridentSoft.devtools.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tridentSoft.devtools.domain.MockApiResponse;

@Repository
public interface MockRepository
        extends JpaRepository<MockApiResponse, Long> {

	Optional<MockApiResponse> findByUsernameAndToken(String username, String token);
	
	
}