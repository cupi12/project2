<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script type="text/javascript"> 
		window.onload = function() { 
		
		var wstart = document.getElementById('wstart'); 	
		var wend = document.getElementById('wend');
		var totalTime = document.getElementById('toralTime');
		var money = document.getElementById('money');
		
		var counter1 = document.getElementById('counter1'); 
		var counter2 = document.getElementById('counter2');
		var counter3 = document.getElementById('counter3');
		var counter4 = document.getElementById('counter4');
		
		wstart.onclick = function() { 
			counter1.innerHTML = Number(counter1.innerHTML) + 1; 
			}; 				
		wend.onclick = function() { 
			counter2.innerHTML = Number(counter2.innerHTML) + 1; 
		};		
		totalTime.onclick = function() { 
			counter3.innerHTML = Number(counter3.innerHTML) + 1; 
		// wend 를 클릭하면 money 클릭한 이벤트도 발생 
		wend.onclick(); 
		}; 
	}; 
		
	//ajax 호출
	
    function getChartData(){
        var wstart = ();
        var wend = ();
        var totalTime = ();
      //1.xhr 객체 생성
      var xhr = new XMLHttpRequest(); //부분 수정 : 새로고침 없이 데이타 받아와서 수정하는 메소드, 모든 데이터값 받아옴, html도 받아옴
      
      //2.콜백 함수
      xhr.onreadystatechange = function(){
         if(xhr.readyState == 4 && xhr.status == 200){
            var obj = JSON.parse(xhr.responseText); //string -> 객체                     
            list.push([obj[i].wstart, obj[i].wend, obj[i].totalTime);           
         }         
      }
      //3. 연결
      xhr.open("get", "../AdminWorkerInsert.do", false);
      
      //4.전송
      xhr.send();
      return list;
   }	
	
	function start(param){
		document.frm.wstart.value = param;
	}
	</script>

	
	
</head>
<body>
<form >
<input type="hidden" name="start" id="start">
</form>
<h3 align ="center">직원 수정 페이지</h3>
<form action ="WorkerMemberInsert.do" name="frm" method="post" enctype = "multijpart/form-data"></form>

<!-- 번호 : <input type = ""><br>          -->                                    <!-- 데이터 타입  -->
직원이름 : <input type = "text" name = "wname" id="wname"><br>
근무시작 : <input type = "text" name = "wstart" id="wstart"><br>             <!-- 데이터 타입 date -->
근무종료 : <input type = "text" name = "wend" id="wend"><br>                <!-- 데이터 타입 date -->
근무시간 : <input type = "text" name = "totaltime" id = "totaltime"><br>    <!-- 데이터 타입 number -->
급여 : <input type = "money" name = "money" id = "money">               <!-- 데이터 타입 number -->
<br>
<br>

<button id="wstart">등록하기</button> 
<button type="button" onclick="start()">근무시작</button> 
<button id="totalTime">근무종료</button> 
<button id="money">근무시간</button> 
<h1>wstart - <span id="counter1">0</span></h1> 
<h1>wend - <span id="counter2">0</span></h1> 
<h1>totalTime - <span id="counter3">0</span></h1> 
<h1>money - <span id="counter4">0</span></h1>


</body>
</html>