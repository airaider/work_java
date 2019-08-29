# HTML

html5 : 아직 표준안이 아님 (브라우저에 따라 지원하는 기능이 다름)

비정상적인 포트 종료 방법

> 윈도우 종료
>
> 작업 관리자에서 javaEE.exe 프로세스 종료





`<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<h1>hello</h1>

</body>
</html>`



doctype : 초기설정

head : 환경 설정, 화면에 안 보임

body : 화면에 보이는 부분



외부 자원으로 연결 `<a href="url" target=" ">  </a>`

**경로**

**`절대경로`**

로컬 : Drive 부터 파일까지 경로 표시 C:\ssafy\a.txt

web : protocal부터 표시 http://IP:port/파일경로

ex) http://localhost:8080/html5/test.html

절대 경로는 하지만 프로젝트 진행시에는 경로가 지속적으로 바뀌기 때문에 잘 사용하지 않는다

**`상대 경로`**

로컬 : 현재 작업하는 파일을 기준

웹 : 브라우져에 표시된 url이 기준



[./] : 현재 경로

.. : 상위 경로

[./]하위경로명/ : 하위 경로



UL : Unordered List

- 목록앞에 기호가 표시됨
- type을 지정하지 않으면 기본적으로 disc 설정

OL : Ordered List

- 목록에 순서를 표시

- type을 지정하지 않으면 기본적으로 아라비아 숫자로 설정

  l : 아라비아 숫자

  i : 소문자 로마 숫자

  I : 대문자 로마 숫자

  a : 소문자 알파벳

  A : 대문자 알파벳

li : 목록의 아이템



table

tr : table의 한 줄

td : tr의 한 셀

th : 굵고, 중앙정렬

다른 정렬시 : align='   '



| table | thead |          th          |      |      |
| ----- | ----- | :------------------: | ---- | ---- |
| tr    | tbody |                      |      |      |
| td    | tbody |                      |      |      |
|       | tfoot | 셀합치기 colspan='2' |      |      |



이미지의 크기변경시 width or height 중 하나의 size만 변경

나머지는 자동으로 배율에 맞게 조정이 된다



`<form method=" " action:"url" enctype=" ">`

입력 받은 data를 전송할 server url

file : multipart/form-data

`
</form>`

`<input type=" " name=" " value=" "/>`

name = value

name = 값을 구별할 이름, value = 서버에 전송될 값



**inline 요소**

- content의 width, height를 지정할 수 없다
- inline 요소의 크기는 데이터의 크기에 의해 결정됨
- 한 행에 여러개의 inline 요소를 표시
- a, span, img ...

**block 요소**

- content의 width, height를 지정할 수 있다
- 한 행에 block 요소 하나만 표시
- table, div, li, p, h6~h1 ...





# CSS

CSS 설정

1. css 파일을 설정
   	`<link rel='styleseet' href='css 경로'/>`

2. 내부css 설정

   2.1 head 태그에 설정

   	<head>
   		<style>
   		    css
   		</style>
   	</head>
   
   2.2 태그에 설정
   
      `<tag style='css 설정'/>`



기본 선택자

1. 태크명 {    } 	ex) h1 {color : red;}

   `<div id : 'box'> ... </div>`

2. #id 명 {    }     ex) #box{color : pink;}

3. .class 명{   }   ex) .box{color : orange;}