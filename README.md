# 체스 요구사항

<br>

## 기능 명세

<br>

### 체스 기물 기능 명세
- 공통
    - [ ] 목표위치에 적의 기물이 있는 경우 그 기물을 없애고 해당 위치로 이동한다.
    - [ ] 목표위치에 아군의 기물이 존재할 경우 이동할 수 없다.
    - [ ] 목표위치까지의 경로에 기물이 존재할 경우 이동할 수 없다. (단, 나이트는 점프가 가능하다.)
- 비숍
    - [ ] 대각선 방향으로 몇칸이든 이동할 수 있다.
- 킹
    - [ ] 모든 방향(수평, 수직, 대각선)으로 1칸만 이동할 수 있다.
    - [ ] 적의 기물의 공격 포지션으로는 이동할 수 없다. (체크 방지)
- 나이트
    - [ ] 대각선으로 한 칸 이동 후 수평혹은 수직으로 한 칸 이동할 수 있다.
- 폰
    - [ ] 전진만 가능하며 뒤나 옆으로 움직일 수 없다.
    - [ ] 전방으로 1칸씩 전진할 수 있다. (앞 위치에 기물(아군, 적 포함)있으면 이동할 수 없다.)
    - [ ] 초기 위치인 경우 전방으로 2칸 전진할 수 있다. (목표위치에 기물이 있으면 이동할 수 없다.)
    - [ ] 앞쪽 대각선에 적의 기물이 존재할 경우 대각선으로 이동할 수 있다.
- 퀸
    - [ ] 모든 방향(수평, 수직, 대각선)으로 몇칸이든 이동할 수 있다.
- 룩
    - [ ] 수평, 수직으로 몇칸이든 이동할 수 있다.
    
<br>

### 게임 기능 명세


