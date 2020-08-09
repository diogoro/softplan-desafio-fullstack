package dev.diogoro.softplan.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("testH2")
class ParecerRepositoryTest {

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

}
