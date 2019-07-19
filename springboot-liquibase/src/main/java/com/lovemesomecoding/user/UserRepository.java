package com.lovemesomecoding.user;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;
import java.lang.String;

public interface UserRepository extends JpaRepository<User, Long>{

	@Async
	public Future<User> findByAge(int age);
	
	@Async
	public CompletableFuture<User> findByName(String name);
	
	@Async
	public ListenableFuture<User> findByEmail(String email);
}
