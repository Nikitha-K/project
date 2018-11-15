function validform(name,mobile,mail,operation){
    var data = [];
data = JSON.parse(localStorage.getItem("formdata"));
    var b=true;
    if(data!=null)
    if(operation<0)
    $.each(data, function (key, value) {
        if (name == value.name) {
        alert("name should be unique");
            b = false;
        }

    });

    if(operation>=0){
        var d = data[operation];
        $.each(data, function (key, value) {
            if (d.name != name) {
                if (name == value.name) {
                    alert("name should be unique");
                    b = false;
                }
            }
    
        });
    }


    if (name == "") {
        $("#uerr1").text("name is not valid");
        $("#err1").text("name is not valid");
        b = false;
    } else {
        $("#uerr1").text("");
        $("#err1").text("");

    }

    if (isNaN(mobile) || mobile.length != 10) {
        $("#uerr2").text("number is not valid");
        $("#err2").text("number is not valid");

        b = false;
    } else {
        $("#uerr2").text("");
        $("#err2").text("");

    }
    if (mail.indexOf('@') < 0 || mail.indexOf('@') < 0 || mail.indexOf('@') > mail.lastIndexOf('.')) {
        $("#uerr3").text("mail is not valid");
        $("#err3").text("mail is not valid");

        b = false;

    } else {
        $("#uerr3").text("");
        $("#err3").text("");

    }
    return b;

}