function validform(name,mobile,mail){
    var b=true;
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