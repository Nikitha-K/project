


function insert() {
    var myForm =$("#myForm")[0];
    var formData = new FormData(myForm);
    var name = formData.get('name');
    var mail = formData.get('mail');
    var mobile = formData.get('mobile');
    var b = validform(name, mobile, mail);
    if (b) {
    var dataString = {'name':name,'gmail':mail,'mobile':mobile,"operation":"add"};
    alert(dataString);
    $.ajax({
     url : "/adddata/",
     type : "POST",
     data : dataString,
     success: function(){
    alert('success');
    window.location.href = "http://127.0.0.1:8000/employee/";
  },
  error: function(){
    alert('mail should be unique');
  },

    });
     $("#myForm").trigger('reset');


    }
    return b;
}
function hidevalidation(){
    $("#err1").text("");
    $("#err2").text("");
    $("#err3").text("");
}












