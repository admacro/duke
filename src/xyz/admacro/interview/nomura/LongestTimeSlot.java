package xyz.admacro.interview.nomura;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Given a businessman's schedule as following, calculate the longest time slot
 * he can sleep
 *
 * Mon 01:00-23:00
 * Tue 01:00-23:00
 * Wed 01:00-23:00
 * Thu 01:00-23:00
 * Fri 01:00-23:00
 * Sat 01:00-23:00
 * Sun 01:00-21:00
 */
public class LongestTimeSlot {
    public static final int WEEKDAY_COUNT = 7;
    private static final  DateFormat PARSE_FORMAT = new SimpleDateFormat("EEE HH:mm");
    private static final  DateFormat PRINT_FORMAT = new SimpleDateFormat("EEE yyyy-MM-dd HH:mm");

    public int solution(String S) {
        List<Meeting> meetings = getMeetings(S);
        List<Slot> slots = getSlots(meetings);
        long longest = 0;
        for (Slot slot: slots) {
//            System.out.println(slot);
            long duration = Duration.between(slot.getStartTime().toInstant(), slot.getEndTime().toInstant()).toMinutes();
            if (duration > longest) {
                longest = duration;
            }
        }
        return Long.valueOf(longest).intValue();
    }

    public static void main(String[] args) {
        LongestTimeSlot s = new LongestTimeSlot();
        String schedule = "Mon 01:00-23:00\nTue 01:00-23:00\nWed 01:00-23:00\nThu 01:00-23:00\nFri 01:00-23:00\nSat 01:00-23:00\nSun 01:00-21:00\n";
        String schedule2 = "Mon 05:00-13:00\nMon 15:00-21:00\nTue 03:30-18:15\nTue 19:00-20:00\nWed 04:25-15:14\nWed 15:14-22:40\nThu 00:00-23:59\nFri 05:00-10:00\nFri 16:30-23:50\nSat 02:00-06:00\nSat 10:00-24:00\nSun 01:00-04:00\nSun 10:00-20:00\n";
        String schedule3 = "Mon 03:00-11:00\nMon 13:00-22:00\nTue 05:30-15:15\nTue 22:00-24:00\nWed 07:25-12:35\nWed 18:14-21:30\nThu 00:00-23:59\nFri 09:00-11:45\nFri 14:30-17:50\nSat 01:00-06:00\nSat 12:00-22:00\nSun 03:00-06:00\nSun 12:00-15:00\n";
        System.out.println("Given the following schedule: \n" + schedule + "The longest time slot is " + s.solution(schedule) + " minutes.\n");
        System.out.println("Given the following schedule: \n" + schedule2 + "The longest time slot is " + s.solution(schedule2) + " minutes.\n");
        System.out.println("Given the following schedule: \n" + schedule3 + "The longest time slot is " + s.solution(schedule3) + " minutes.\n");
    }

    private List<Slot> getSlots(List<Meeting> meetings) {
        Date slotStart = getStartOfDay(meetings.get(0).getStartTime());
        List<Slot> slots = new ArrayList<>();
        for (int i = 0; i < meetings.size(); i++) {
            Meeting meeting = meetings.get(i);
//            System.out.println(meeting);
            slots.add(new Slot(slotStart, meeting.getStartTime()));
            slotStart = meeting.getEndTime();
        }
        Date slotEnd = getEndOfDay(meetings.get(meetings.size() - 1).getStartTime());
        slots.add(new Slot(slotStart, slotEnd));
        return slots;
    }

    private Date getStartOfDay(Date date){
        Instant inst = date.toInstant();
        LocalDate localDate = inst.atZone(ZoneId.systemDefault()).toLocalDate();
        Instant dayInst = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        return Date.from(dayInst);
    }

    private Date getEndOfDay(Date date){
        Instant inst = date.toInstant();
        LocalDate localDate = inst.atZone(ZoneId.systemDefault()).toLocalDate();
        Instant dayInst = localDate.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant();
        return Date.from(dayInst);
    }

    private List<Meeting> getMeetings(String s) {
        String[] schedule = s.split(System.getProperty("line.separator"));
        List<Meeting> meetings = new ArrayList<>(schedule.length);
        LocalDateTime previousDate = null;
        for (int i = 0; i < schedule.length; i++) {
            Meeting meeting = convertToMeeting(schedule[i]);
            if (meeting == null) {
                System.out.println(schedule[i] + " is not a valid entry. Line " + (i + 1));
                continue;
            }
            if (i > 0) { // correct datetime from the second meeting
                setCorrectMeetingTime(meeting, previousDate);
            }
            meetings.add(meeting);
            previousDate = meeting.getLocalStartTime();
        }
        return meetings;
    }

    private void setCorrectMeetingTime(Meeting meeting, LocalDateTime previousDateTime) {
        if (meeting.getLocalStartTime().isBefore(previousDateTime)) {
            meeting.setStartTime(Date.from(meeting.getLocalStartTime().plusDays(WEEKDAY_COUNT).atZone(ZoneId.systemDefault()).toInstant()));
            meeting.setEndTime(Date.from(meeting.getLocalEndTime().plusDays(WEEKDAY_COUNT).atZone(ZoneId.systemDefault()).toInstant()));
        }
    }

    private Meeting convertToMeeting(String s) {
        String[] weekdayAndTime = s.split(" ");
        String weekday = weekdayAndTime[0];
        String[] meetingStartAndEnd = weekdayAndTime[1].split("-");
        String meetingStart = meetingStartAndEnd[0];
        String meetingEnd = meetingStartAndEnd[1];
        try {
            return new Meeting(PARSE_FORMAT.parse(weekday + " " + meetingStart),
                    PARSE_FORMAT.parse(weekday + " " + meetingEnd));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private abstract class TimeRange {
        Date startTime;
        Date endTime;

        public TimeRange(Date startTime, Date endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Date getStartTime() {
            return startTime;
        }

        public LocalDateTime getLocalStartTime() {
            return startTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        }

        public LocalDateTime getLocalEndTime() {
            return endTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "{" +
                    "startTime=" + PRINT_FORMAT.format(startTime) +
                    ", endTime=" + PRINT_FORMAT.format(endTime) +
                    '}';
        }
    }

    private class Meeting extends TimeRange {
        public Meeting(Date startTime, Date endTime) {
            super(startTime, endTime);
        }

        @Override
        public String toString() {
            return "Meeting" + super.toString();
        }
    }
    private class Slot extends TimeRange {
        public Slot(Date startTime, Date endTime) {
            super(startTime, endTime);
        }

        @Override
        public String toString() {
            return "Slot" + super.toString();
        }
    }
}
