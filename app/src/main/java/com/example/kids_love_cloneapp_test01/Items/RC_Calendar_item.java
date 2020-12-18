package com.example.kids_love_cloneapp_test01.Items;

public class RC_Calendar_item {
    public String header, title, kids, kidsNum, location, from;
    public String winning, teacher_position;
    public String participants, maxParticipants;

    public String imageNum, userFace, ban;

//    todo 이미지 개수, 사용자가 선택한 표정, 부/반 데이터 추가


    public RC_Calendar_item(String header, String title, String kids, String kidsNum, String location, String from, String winning, String teacher_position, String participants, String maxParticipants, String imageNum, String userFace, String ban) {
        this.header = header;
        this.title = title;
        this.kids = kids;
        this.kidsNum = kidsNum;
        this.location = location;
        this.from = from;
        this.winning = winning;
        this.teacher_position = teacher_position;
        this.participants = participants;
        this.maxParticipants = maxParticipants;
        this.imageNum = imageNum;
        this.userFace = userFace;
        this.ban = ban;
    }
}
