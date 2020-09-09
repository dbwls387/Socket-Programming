# Socket-Programming
소켓 API를 활용한 네트워크 프로그래밍 

## 야구게임 
### 게임 설명
- 서버가 랜덤으로 생각한 0~9까지의 숫자 4가지를 클라이언트가 추리하여 맞추는 게임
- 숫자와 자리가 모두 같으면 스트라이크, 숫자는 존재하지만 자리가 틀리면 볼
- 서버는 스트라이크와 볼의 개수를 클라이언트에게 알려줌 

### 구조 및 주요 클래스 
 ![야구게임 클래스](https://user-images.githubusercontent.com/52234053/92568449-28c41780-f2ba-11ea-8307-5960190d8e2b.png)
 
### 실행 화면
 - 게임 실행 
 ![11](https://user-images.githubusercontent.com/52234053/92569948-34b0d900-f2bc-11ea-96b0-a5a4b8f208fe.png)
 
 - 클라이언트가 정답을 맞힐 시 클라이언트 승리
 ![22](https://user-images.githubusercontent.com/52234053/92569951-37133300-f2bc-11ea-8f29-769b8380136a.png)
 
 - 남은 횟수를 다 쓸 때까지 맞히지 못하면 서버 승리 
 ![33](https://user-images.githubusercontent.com/52234053/92569955-38446000-f2bc-11ea-893a-418672544f67.png)
