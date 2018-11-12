function validform(name,mobile,mail){
    var data = [];
data = JSON.parse(localStorage.getItem("formdata"));

    var b=true;
    $.each(data, function (key, value) {
        if (name == value.name) {
            $("#err1").text("name should be unique");
            b = false;
        }

    });
    if (name == "") {
        $("#err1").text("name is not valid");
        b = false;
    } else {
        $("#err1").text("");
    }

    if (isNaN(mobile) || mobile.length != 10) {
        $("#err2").text("number is not valid");
        b = false;
    } else {
        $("#err2").text("");
    }
    if (mail.indexOf('@') < 0 || mail.indexOf('@') < 0 || mail.indexOf('@') > mail.lastIndexOf('.')) {
        $("#err3").text("mail is not valid");
        b = false;

    } else {
        $("#err3").text("");
    }
    return b;

}