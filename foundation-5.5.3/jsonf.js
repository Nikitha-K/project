var data = [];
data = JSON.parse(localStorage.getItem("formdata"));
function insert() {
    var myForm = document.getElementById('myForm');
    var formData = new FormData(myForm);
    var name = formData.get('name');
    var mail = formData.get('mail');
    var mobile = formData.get('mobile');
    var b = validform(name, mobile, mail);
    if (b) {
        var result = {};
        for (var entry of formData.entries()) {
            result[entry[0]] = entry[1];
        }
        data = JSON.parse(localStorage.getItem("formdata"));
        data.push(result);
        $("#done").text("completed");
        localStorage.setItem("formdata", JSON.stringify(data));
        $("#myForm").trigger('reset');
    }
}














