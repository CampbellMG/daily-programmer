package com.cmgcode.dailies

data class Meeting(val startTime: Int, val endTime: Int)

fun Meeting.endsWhenStarts(other: Meeting): Boolean = endTime == other.startTime

//fun combine(meetings: List<Meeting>): List<Meeting> {
////    return meetings.fold(mutableListOf()){acc, meeting ->  }
//}
