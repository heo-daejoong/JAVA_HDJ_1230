INSERT INTO CHANNEL(CH_NUM, CH_NAME)VALUE(5, "SBS");

INSERT INTO CHANNEL(CH_NUM, CH_NAME)VALUES(7, "KBS"), (11, "MBC");

SELECT * FROM CHANNEL;

INSERT INTO BROAD.PROGRAM(
PG_KEY, PG_NAME, PG_AGE, PG_CH_NUM, PG_TIME
)VALUES("SBS001", "런닝맨", "15세", 5, "19시");

INSERT INTO WEEK(WE_KEY, WE_NAME)VALUES
(0, "일요일"),(1, "월요일"),(2, "화요일"),(3, "수요일"),(4, "목요일"),(5, "금요일"),(6, "토요일");

INSERT INTO VIEW(VW_PG_KEY, VW_WE_KEY)VALUE("SBS001", 0);

INSERT INTO BROADTIME(BT_VW_KEY, BT_DATE, BT_TIMETABLE)
VALUE(1, NOW(), NOW());

INSERT INTO USER(US_ID, US_PW, US_NAME)
VALUE("USER", "USER1234", "USER");
SELECT * FROM USER;

INSERT INTO USER(US_ID, US_PW, US_NAME)
VALUE("USER", "USER1234", "USER");
SELECT * FROM USER;






