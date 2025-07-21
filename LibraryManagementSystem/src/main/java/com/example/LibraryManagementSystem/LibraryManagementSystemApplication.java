package com.example.LibraryManagementSystem;

import com.example.LibraryManagementSystem.Repositry.AppUserRepository;
import com.example.LibraryManagementSystem.entity.AppUser;
import com.example.LibraryManagementSystem.entity.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner createAdminUser(AppUserRepository repo, PasswordEncoder encoder) {
		return args -> {
			if (repo.findByUsername("admin2").isEmpty()) {
				repo.save(new AppUser(null, "admin2", "admin@example.com", encoder.encode("1234"), Role.ADMIN, null));
				System.out.println("✅ Admin user created");
			}

			if (repo.findByUsername("librarian1").isEmpty()) {
				repo.save(new AppUser(null, "librarian1", "librarian@example.com", encoder.encode("1234"), Role.LIBRARIAN, null));
				System.out.println("✅ Librarian user created");
			}

			if (repo.findByUsername("staff1").isEmpty()) {
				repo.save(new AppUser(null, "staff1", "staff@example.com", encoder.encode("1234"), Role.STAFF, null));
				System.out.println("✅ Staff user created");
			}
		};
	}
}

