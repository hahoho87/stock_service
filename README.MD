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
- 실패 로직을 구현해야함
- 충돌이 빈번하게 일어나게 된다면 pessimistic lock 보다 더 느려짐
#### pessimistic lock
- 다른 트랜잭션이 특정 row 의 lock 을 얻는 것을 방지
- 특정 row 를 update 하거나 delete 할 수 있음
- 일반 select 는 별다른 lock 이 없기 때문에 조회 가능
### named lock
- 이름과 함께 lock 획득. 해당 lock 은 다른 세션에서 획득 및 해제 불가
- connection pool 을 다수 차지할 수 있어 다른 datasource 사용 권장