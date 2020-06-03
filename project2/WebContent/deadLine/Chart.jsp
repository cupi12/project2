<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  
  
  
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    

    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(drawCurveTypes);

    function drawCurveTypes() {
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'regdt');
          data.addColumn('number', 'sum');

          var list = getChartData();
          data.addRows( list ); 
          
          
          
          

          var options = {
            hAxis: {
              title: '날짜(일)'
            },
            vAxis: {
              title: '일일 총 매출액'
            },
            series: {
              1: {curveType: 'function'}
            }
          };

          var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
          chart.draw(data, options);
        }
    
  	function getChartData(){
  		var list = [];
		//1.xhr 객체 생성
		var xhr = new XMLHttpRequest();
		
		//2.콜백 함수
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				var obj = JSON.parse(xhr.responseText); 
				for(i=0; i<obj.length; i++){
				 	//방법2
					list.push([obj[i].regdt, obj[i].sum]);
				}	
					
			}			
		}
		//3.서버 연결
		
		xhr.open("get", "DeadLine", false);
		//4.전송
		xhr.send();
		return list;
	}
    </script>
  </head>
  <body>
    <div id="chart_div" style="width: 800px; height: 500px;"></div>
  </body>
</html>
