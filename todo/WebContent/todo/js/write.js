var date = document.getElementById("date");
	var time = document.getElementById("time");
	var current = new Date();
	var year = current.getYear() + 1900;
	var month = current.getMonth() + 1 > 9 ? current.getMonth() + 1 : "0" + (current.getMonth() + 1);
	var day = current.getDate() > 9 ? current.getDate() : "0" + current.getDate();
	var today = year + "-" + month + "-" + day;
	date.value = today;
	var hour = current.getHours() > 9 ? current.getHours() : "0" + current.getHours();
	var minute = current.getMinutes() > 9 ? current.getMinutes() : "0" + current.getMinutes();
	time.value = hour + ":" + minute
	
	var promise = document.getElementById("promise");
	promise.selected = true;
	
	var btn_main = document.getElementById("btn_main");
	btn_main.addEventListener("click", function(event){
		location.href = "../index.html";
		event.preventDefault();
	})
