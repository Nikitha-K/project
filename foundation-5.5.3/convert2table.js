var jdata1 = [];
var id;
function ConvertToTable(flag) {
    var jdata = localStorage.getItem("formdata");
    jdata1 = JSON.parse(jdata);
    if(jdata1!=null){
    var $table = $('<table/>');
    var $headerTr = $('<tr/>');
    for (var index in jdata1[0]) {

        $headerTr.append($('<th/>').html(index));
    }
    $table.append($headerTr);
    for (var i = 0; i < jdata1.length; i++) {

        var $tableTr = $('<tr/>');

        for (var index in jdata1[i]) {
            $tableTr.append($('<td/>').html(jdata1[i][index]));
        }
        if(flag){
        $tableTr.append("<td><button id='" + i + "' onclick='deletefun(this)'>delete</button></td>");

        $tableTr.append("<td><a href='#' data-reveal-id='myupdate'><button style='color:black;'id='" + i + "' onclick='updatefun(this)'>update</button></a></td>")
        }
        $table.append($tableTr);
    }
    $("#displaytable").html($table);
    console.log(jdata);
return $table;
    }else{
        alert("no values")
    }
}


function deletefun(obj) {
    jdata1.splice(obj.id, 1);
    localStorage.setItem("formdata", JSON.stringify(jdata1));
    ConvertToTable(true);
}

function updatefun(obj) {
    id = obj.id;
    var d = jdata1[obj.id];
    $("#nameupdate").val(d.name);
    $("#mobileupdate").val(d.mobile);
    $("#mailupdate").val(d.mail);

}

function updateelement() {

    var b = true;
    var myForm = document.getElementById('updateform');
    var formData = new FormData(myForm);
    var name = formData.get('name');
    var email = formData.get('mail');
    var mobile = formData.get('mobile');

    var d = jdata1[id];
    $.each(jdata1, function (key, value) {
        if (d.name != name) {
            if (name == value.name) {
                alert("name should be unique");
                b = false;
            } 
        }

    });

    if (name == "") {
        $("#uerr1").text("name is not valid");
        b = false;
    } else {
        $("#uerr1").text("");
    }

    if (isNaN(mobile) || mobile.length != 10) {
        $("#uerr2").text("number is not valid");
        b = false;
    } else {
        $("#uerr2").text("");
    }
    if (email.indexOf('@') < 0 || email.indexOf('@') < 0 || email.indexOf('@') > email.lastIndexOf('.')) {
        $("#uerr3").text("email is not valid");
        b = false;

    } else {
        $("#uerr3").text("");
    }

    if (b) {


        var result = {};

        for (var entry of formData.entries()) {
            result[entry[0]] = entry[1];
        }

        jdata1[id].name = name;
        jdata1[id].mobile = mobile;
        jdata1[id].mail = email;
        localStorage.setItem("formdata", JSON.stringify(jdata1));
        ConvertToTable(true);
        $("#updateform").trigger('reset');
    }
   
   

}

function searchdata() {
    var s = $("#searchrow").val();


    var i;
    var sd;

    for (i = 0; i < jdata1.length; i++) {
        sd = jdata1[i];
        if (sd.name == s) {
            break;
        }
        if (sd.mobile == s) {
            break;
        }
        if (sd.mail == s) {
            break;
        }
    }
    if (i < jdata1.length) {

        $('#displaytable1').html('<table><tr><td>' + sd.name + '</td><td>' + sd.mobile + '</td><td>' + sd.mail + '</td></tr></table>');

    }else{
        alert("no data found");
    }
}

