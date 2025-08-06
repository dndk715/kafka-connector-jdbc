


docker-compose down
docker-compose up --build



curl -X DELETE http://localhost:8083/connectors/oracle-jdbc-source
curl -X POST -H "Content-Type: application/json" --data @register-oracle-source.json http://localhost:8083/connectors

curl http://localhost:8083/connectors
curl http://localhost:8083/connectors/oracle-jdbc-source/config
curl http://localhost:8083/connectors/oracle-jdbc-source/status




CREATE TABLE YOUR_TABLE (
  ID NUMBER PRIMARY KEY, 
  NAME VARCHAR2(100), 
  DESCRIPTION VARCHAR2(500), 
  CREATED_AT TIMESTAMP DEFAULT SYSTIMESTAMP
);

INSERT INTO YOUR_TABLE (ID, NAME, DESCRIPTION, CREATED_AT) VALUES (3, '테스트', '테스트t', SYSDATE);
   COMMIT;









카프카 커넥터는 무조건 폴링 방식인가

좋은 질문입니다!
Kafka Connect JDBC Source Connector는 기본적으로 폴링(polling) 방식입니다.
즉, 주기적으로 DB를 조회해서 변경사항을 감지합니다.
1. JDBC Source Connector (RDBMS → Kafka)
폴링 방식만 지원합니다.
poll.interval.ms 설정에 따라 주기적으로 DB를 조회
변경된 row(새로운 PK, 타임스탬프 등)가 있으면 Kafka로 전송
RDBMS(오라클, MySQL, PostgreSQL 등)에서 트리거 기반, 푸시 기반은 지원하지 않습니다.
2. 예외: CDC(변경 데이터 캡처) 기반 커넥터
Debezium 등 일부 커넥터는 CDC(Change Data Capture) 방식으로 동작합니다.
DB의 트랜잭션 로그(redo log, binlog 등)를 실시간으로 읽어 변경사항을 감지
이 방식은 폴링이 아니라, 로그 기반 실시간 스트리밍에 가깝습니다.
오라클, MySQL, PostgreSQL 등에서 CDC를 지원하는 별도의 커넥터가 필요합니다.
3. 결론
Kafka Connect JDBC Source Connector는 무조건 폴링 방식입니다.
실시간(로그 기반) 연동이 필요하다면,
Debezium 등 CDC 커넥터를 사용해야 합니다.