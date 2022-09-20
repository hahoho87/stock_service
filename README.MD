# Stock Service

### mini project for resolve Java concurrency Problem

## Getting Started

```bash
docker run --name mariadb -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mariadb
```

## 자바 동시성 이슈

- 여러 쓰레드가 접근 시 동시성 문제 발생
- 동시성 문제 해결을 위해 동기화 처리

### synchronized

- 메소드 전체에 동기화 처리
- 하나의 쓰레드만 접근 가능할 수 있게 처리

 ```java
   public synchronized void decrease(Long quantity) {
       this.quantity -= quantity;
   }
``` 
- 서버가 여러대 일 경우 동시성 보장하지 못함


### database lock
#### optimistic lock
- lock 을 걸지않고 문제가 발생할 때 처리
- version column 을 만들어 해결
#### pessimistic lock
- 다른 트랜잭션이 특정 row 의 lock 을 얻는 것을 방지
- 특정 row 를 update 하거나 delete 할 수 있음
- 일반 select 는 별다른 lock 이 없기 때문에 조회 가능