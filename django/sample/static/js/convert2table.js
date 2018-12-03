



function updateelement(id) {
    var b;
    var myForm =$("#updateform")[0];
    var formData = new FormData(myForm);
    var name = formData.get('name');
    var email = formData.get('mail');
    var mobile = formData.get('mobile');
    b = validform(name, mobile, email);



    if (b) {
     var dataString = {'id':id,'name':name,'gmail':email,'mobile':mobile,"operation":"update"};
    alert(name);
    $.ajax({
     url : "/adddata/",
     type : "POST",
     data : dataString,
     success: function(){
    alert('success');
    window.location.href = "http://127.0.0.1:8000/employee/viewall/";
  },
  error: function(){
    alert('failure');
  },
    });
        $("#updateform").trigger('reset');
    }



}

function searchfunction(){
 var myForm = $("#formsearch")[0];
 var formData = new FormData(myForm);
 var searchdata=formData.get('search');
 searchdata=$.trim(searchdata);
 if (searchdata==""){
 $("#errsearch").text("text cant be empty");
  }else{
  $("#searchbutton").click();
  }




}

function deletefunction(obj){

 $.ajax({
     url : "/employee/delete/"+obj.id,
     type : "DELETE",
     success: function(){
    alert('success');
    window.location.href = "http://127.0.0.1:8000/employee/viewall/";

     }

  });


}
