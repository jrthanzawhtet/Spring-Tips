package com.spring.dev.utils;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

@Service
public class JpaAuditorAwareBean implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.empty();
	}

}
