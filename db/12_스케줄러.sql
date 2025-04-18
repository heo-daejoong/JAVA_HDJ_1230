# 이벤트 스케줄러
# - 특정 작업이 정기적으로 실행되도록 예약하는 기능

# 이벤트 스케줄러 상태 확인 쿼리
# ON : 스케줄러 사용. OFF : 스케줄러 사용 안함
# SHOW VARIABLES LIKE 'EVENT%';

# 이벤트 스케줄러 상태 수정
# SET GLOBAL EVENT_SCHEDULER = 값;
# 값 : ON | OFF

# 이벤트 스케줄러 확인
# SELECT * FROM INFORMATION_SCHEMA.EVENTS;

# 이벤트 스케줄러 등록
/*
CREATE EVENT 이벤트명
ON SCHEDULE EVERY 숫자 단위
[STARTS 시간]
[ON COMPLETION PRESERVE | ON COMPLETION NOT PRESERVE]
[COMMENT '설명']
DO
	실행할 쿼리; # 복잡한 쿼리가 필요하면 프로시저를 생성하여 호출

 - 단위
	- YEAR | QUARTER | MONTH | DAY | HOUR | MINUTE | WEEK | SECOND
    - YEAR_MONTH | DAY_HOUR | DAY_MINUTE | DAY_SECOND | HOUR_MINUTE | HOUR_SECOND | MINUTE_SECOND
 - STARTS
	- 스케줄러가 실행될 기준 시간. 생략하면 스케줄러 등록 시간이 기준 시간이 됨.
 - ON COMPLETION PRESERVE
	- 이벤트가 성공한 후 이벤트를 보존(이벤트가 유지)
 - ON COMPLETION NOT PRESERVE
	- 이벤트가 성공한 후 이벤트를 삭제(한번만 실행)
    - 기본 값
*/

USE COMMUNITY;

# 이벤트 삭제
# DROP EVENT IF EXISTS 이벤트명;
DROP EVENT IF EXISTS INCREASE_VIEW;

CREATE EVENT INCREASE_VIEW
ON SCHEDULE EVERY 1 MINUTE
ON COMPLETION PRESERVE
DO
	UPDATE BOARD SET BO_VIEW = BO_VIEW + 1 WHERE BO_NUM = 1;
SELECT * FROM BOARD;

/*
# 이벤트 스케줄러 등록(NOT PRESERVE)
CREATE EVENT 이벤트명
ON SCHEDULE
AT 시간
ON COMPLETION NOT PRESERVE
[COMMENT '설명']
DO
	실행할 쿼리;
*/
DROP EVENT IF EXISTS INCREASE_VIEW_ONCE;

CREATE EVENT INCREASE_VIEW_ONCE
ON SCHEDULE
AT ADDTIME(NOW(), "00:00:30")
ON COMPLETION NOT PRESERVE
DO
	UPDATE BOARD SET BO_VIEW = BO_VIEW + 1 WHERE BO_NUM = 2;
SELECT * FROM BOARD;