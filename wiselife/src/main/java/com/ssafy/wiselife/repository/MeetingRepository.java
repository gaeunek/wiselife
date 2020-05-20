package com.ssafy.wiselife.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ssafy.wiselife.domain.Meeting;
import com.ssafy.wiselife.domain.User;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer>{
	
	@Transactional
	@Query(value = "SELECT LAST_INSERT_ID() FROM MEETING", nativeQuery = true)
	public int findLaseMeetingId();
	
	public Meeting findByMeetingIdAndUser(int meeting_id, User user);
}
