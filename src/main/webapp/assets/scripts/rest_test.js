$(function() {
   var d = new Date();
   var curDate = d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
   console.log(curDate);
   $.ajax({
        url: "/bestore/rest/user/login1",
         headers: {
	        "Date":curDate
    	}
    }).then(function(data) {
       alert(data);
    });
}); 