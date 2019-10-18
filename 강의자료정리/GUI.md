# GUI

AWT : O/S UI 다른 모습

SWING : O/S UI 같은 모습, 다양한 UI 컴포넌트(재사용 가능한 객체) 지원



Component 재사용 가능한 추상 객체

Container : component를 상속받아 partition 역할을 수행

Frame : 독립적으로 실행 가능한 창

Panel



배치 관리자

LayoutManager

- BoarderLayout (NEWS+Center) : 한 영역당 한 컴포넌트, 크기 가변, 위치 고정 (Frame)

- FlowLayout : 왼쪽에서 오른쪽으로 가로 배치, 크기 고정, 위치 가변 (Panel)

- GridLayout : 격자 형태로 배치 가능, 크기 가변, 위치 고정







# Event

> **Event**

발생한 사건 정보

Exception도 부정적인 event이다



> **Event Source**

Event가 발생한 근원지(대상)



> **Event Handler**

Event를 처리해주는 처리기

Catch랑 비슷한 역할을 한다

Event를 특정 Handler에 등록을 해야한다

보통 nested class로 설계한다

