package com.sarojaba.namematcher;

import static org.junit.Assert.*;

import org.junit.Test;

public class NameMatcherTest {

	@Test
	public void testScoreWithMe() {

		assertEquals(75, NameMatcher.match("우준혁", "김소은"));
		assertEquals(35, NameMatcher.match("우준혁", "박민영"));
		assertEquals(55, NameMatcher.match("우준혁", "박신혜"));
		assertEquals(72, NameMatcher.match("우준혁", "손예진"));
		assertEquals(12, NameMatcher.match("우준혁", "송혜교"));
		assertEquals(10, NameMatcher.match("우준혁", "신민아"));
		assertEquals(39, NameMatcher.match("우준혁", "아이유"));
		assertEquals(19, NameMatcher.match("우준혁", "이다혜"));
		assertEquals(53, NameMatcher.match("우준혁", "이연희"));
		assertEquals(96, NameMatcher.match("우준혁", "하지원"));
		assertEquals(78, NameMatcher.match("우준혁", "한지민"));
		assertEquals(58, NameMatcher.match("우준혁", "한효주"));
	}

	@Test
	public void testScoreNormal() {

		assertEquals(37, NameMatcher.match("연정훈", "한가인"));
		assertEquals(31, NameMatcher.match("한가인", "연정훈"));

		assertEquals(30, NameMatcher.match("이병헌", "이민정"));
		assertEquals(9, NameMatcher.match("이민정", "이병헌"));
	}

	@Test
	public void testScoreNotSameLength() {

		assertEquals(39, NameMatcher.match("원빈", "이나영"));
		assertEquals(75, NameMatcher.match("이나영", "원빈"));

		assertEquals(52, NameMatcher.match("이승기", "윤아"));
		assertEquals(81, NameMatcher.match("윤아", "이승기"));

		assertEquals(16, NameMatcher.match("이민호", "수지"));
		assertEquals(45, NameMatcher.match("수지", "이민호"));

		assertEquals(14, NameMatcher.match("비", "김태희"));
		assertEquals(43, NameMatcher.match("김태희", "비"));

		assertEquals(12, NameMatcher.match("믹키유천", "신세경"));
		assertEquals(65, NameMatcher.match("신세경", "믹키유천"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testScoreNotKorean() {

		NameMatcher.match("JK김동욱", "미련한사랑");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testScoreEmptyLeft() {

		NameMatcher.match("", "김개똥");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testScoreEmptyRight() {

		NameMatcher.match("김개똥", "");
	}
}
