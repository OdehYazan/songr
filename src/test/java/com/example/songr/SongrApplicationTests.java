package com.example.songr;

import com.example.songr.model.Album;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class SongrApplicationTests {

	@Test
	void testGetTitle() {
		Album test = new Album("yazan","yazan","yazan",12,1000);

		assertEquals("yazan",test.getTitle());
	}@Test
	void testGetArtist() {
		Album test = new Album("yazan","yazan","yazan",12,1000);

		assertEquals("yazan",test.getArtist());
	}@Test
	void testGetUrl() {
		Album test = new Album("yazan","yazan","yazan",12,1000);

		assertEquals("yazan",test.getImageUrl());
	}@Test
	void testGetCount() {
		Album test = new Album("yazan","yazan","yazan",12,1000);

		assertEquals(12,test.getSongCount());
	}@Test
	void testGetLength() {
		Album test = new Album("yazan","yazan","yazan",12,1000);

		assertEquals(1000,test.getLength());
	}

}
