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
    public synchronized void decrease(long quantity){
	    this.stock-=stock;
	} 
    ``` 

- 서버가 여러대 일 경우 동시성 보장하지 못함