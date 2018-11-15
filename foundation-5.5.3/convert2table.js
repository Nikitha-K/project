var jdata1 = [];
var id;
function ConvertToTable(flag) {
    var jdata = localStorage.getItem("formdata");
    jdata1 = JSON.parse(jdata);
    if (jdata1 != null) {
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
            if (flag) {
                $tableTr.append("<td><button id='" + i + "' onclick='deletefun(this)'>delete</button></td>");

                $tableTr.append("<td><a href='#' data-reveal-id='myupdate'><button style='color:black;'id='" + i + "' onclick='updatefun(this)'>update</button></a></td>")
            }
            $table.append($tableTr);
        }
        $("#displaytable").html($table);
        console.log(jdata);
        return $table;
    } else {
        alert("data is empty");
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
    hidevalidationupdate();

}

function updateelement() {
    var b;
    var myForm = document.getElementById('updateform');
    var formData = new FormData(myForm);
    var name = formData.get('name');
    var email = formData.get('mail');
    var mobile = formData.get('mobile');
    b = validform(name, mobile, email,id);



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
        alert("updated");
        $("#close").click();
        


    }



}

function searchdata() {
    var s = $("#searchrow").val();
    jdata1 = JSON.parse(localStorage.getItem("formdata"));
    var $table = $('<table/>');
    var dataarray = [];
    var sd;
    if (jdata1 != null) {
        for (var i = 0; i < jdata1.length; i++) {
            sd = jdata1[i];
            if (sd.name == s || sd.mobile == s || sd.mail == s) {
                dataarray.push(i);
            }
        }

        if (dataarray.length > 0) {
            $.each(dataarray, function (index, value) {
                $($table).append('<tr><td>' + jdata1[value].name + '</td><td>' + jdata1[value].mobile + '</td><td>' + jdata1[value].mail + '</td></tr>');

            });
            $("#displaytable1").html($table);

        } else {
            alert("no data found");
        }
    } else {
        alert("data is empty");
    }
    $("#formsearch").trigger('reset');
}
function hidevalidationupdate() {
    $("#uerr1").text("");
    $("#uerr2").text("");
    $("#uerr3").text("");
}


